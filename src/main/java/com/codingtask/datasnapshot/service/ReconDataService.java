package com.codingtask.datasnapshot.service;

import com.codingtask.datasnapshot.controller.CorruptDataController;
import com.codingtask.datasnapshot.entity.CorruptData;
import com.codingtask.datasnapshot.entity.ReconData;
import com.codingtask.datasnapshot.exception.LineParseException;
import com.codingtask.datasnapshot.parser.ReconDataParser;
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
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
@Validated
public class ReconDataService {
    @Autowired
    private ReconDataRepository reconDataRepository;

    @Autowired
    private CorruptDataService corruptDataService;

    @Autowired
    private Validator validator;

    private static final Logger logger = Logger.getLogger(ReconDataService.class.getName());

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

    public boolean isPresent(ReconData reconData) {
        return reconDataRepository.findById(reconData.getId()).isPresent();
    }
    public void validateAndPersist(String line) {
        try {
            ReconData data = ReconDataParser.parse(line);
            if ( this.isPresent(data)) this.corruptDataService.addCorruptData("DUPLICATE_PRIMARY_KEY", line);

            Set<ConstraintViolation<ReconData>> constrainViolationSet= this.validator.validate(data);
            if (constrainViolationSet.isEmpty()) {
                this.reconDataRepository.save(data);
            } else {
                String reason= constrainViolationSet
                        .stream()
                        .map(reconDataConstraintViolation -> reconDataConstraintViolation.getMessage() + " ,")
                        .collect(Collectors.joining());
                this.corruptDataService.addCorruptData(reason,line);
            }

        } catch (LineParseException lineParseException){
            logger.info(lineParseException.getMessage());
            this.corruptDataService.addCorruptData("LINE_CANT_BE_PARSED", line);
        } catch (ParseException e) {
            logger.info(e.toString());
            this.corruptDataService.addCorruptData("NOT_A_TIMESTAMP", line);
        }

    }
    public void validateAndPersist(InputStream inputStream){

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String header = reader.readLine();
            reader
                    .lines()
                    .filter(line->line != null)
                    .forEach(this::validateAndPersist);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
