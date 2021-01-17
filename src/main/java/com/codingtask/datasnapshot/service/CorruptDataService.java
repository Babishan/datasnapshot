package com.codingtask.datasnapshot.service;

import com.codingtask.datasnapshot.entity.CorruptData;
import com.codingtask.datasnapshot.repository.CorruptDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorruptDataService {
    @Autowired
    private CorruptDataRepository corruptDataRepository;

    public long findCorruptDataCount() {
        return corruptDataRepository.count();
    }
    public List<CorruptData> findAllCorruptData() {
        return corruptDataRepository.findAll();
    }
    public CorruptData addCorruptData(CorruptData data) {
        return corruptDataRepository.save(data);
    }
    public void addCorruptData(String reason,String line) { this.addCorruptData(new CorruptData(reason,line));}
}
