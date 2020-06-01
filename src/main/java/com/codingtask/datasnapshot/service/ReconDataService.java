package com.codingtask.datasnapshot.service;

import com.codingtask.datasnapshot.entity.CorruptData;
import com.codingtask.datasnapshot.entity.ReconData;
import com.codingtask.datasnapshot.repository.CorruptDataRepository;
import com.codingtask.datasnapshot.repository.ReconDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.validation.annotation.Validated;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Set;

@Service
@Validated
public class ReconDataService {
    @Autowired
    private ReconDataRepository reconDataRepository;

    @Autowired
    private CorruptDataRepository corruptDataRepository;

    @Autowired
    private Validator validator;

    public List<ReconData> findAllData() {
        return reconDataRepository.findAll();
    }

    public ReconData addData(ReconData reconData) {
        return reconDataRepository.save(reconData);
    }

    public ReconData findDataById(String id) {
        return reconDataRepository.findById(id).get();
    }

    public void deleteDataById(String id) {
        reconDataRepository.deleteById(id);
    }

    public long findCorruptDataCount() {
        return corruptDataRepository.count();
    }

    public CorruptData addCorruptData(CorruptData data) {
        return corruptDataRepository.save(data);
    }

    public boolean isPresent(ReconData reconData) {
        return reconDataRepository.findById(reconData.getId()).isPresent();
    }

    public ReconData convert(String line) throws ParseException {

        String[] metadata = line.split(",");
        String id = metadata[0];
        String name = metadata[1];
        String description = metadata[2];
        Calendar timestamp = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        timestamp.setTime(dateFormat.parse(metadata[3]));

        return new ReconData(id, name, description, timestamp);
    }

    public void validateAndPersist(InputStream inputStream) {

        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String header = reader.readLine();
            String line = reader.readLine();
            while ( line != null ) {

                ReconData data = null;

                if(!line.trim().isEmpty()) {
                    try {
                        data = convert(line);
                    } catch (ParseException e) {
                        CorruptData corruptData = new CorruptData("NOT_A_TIMESTAMP", line);
                        this.addCorruptData(corruptData);
                        line = reader.readLine();
                        continue;
                    }
                }

                Set<ConstraintViolation<ReconData>> constrainViolationSet=validator.validate( data );

                if (this.isPresent(data)) {
                    CorruptData corruptData = new CorruptData("DUPLICATE_PRIMARY_KEY",line);
                    this.addCorruptData(corruptData);
                    line = reader.readLine();
                    continue;
                }

                if (constrainViolationSet.isEmpty()) {
                    reconDataRepository.save(data);
                } else {

                    String reason="";

                    for (ConstraintViolation<ReconData> constraintViolation: constrainViolationSet)
                    {
                        reason=reason+constraintViolation.getMessage()+" ,";
                    }
                    CorruptData corruptData=new CorruptData(reason,line);
                    this.addCorruptData(corruptData);
                }
                line = reader.readLine();

            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }


}
