package com.codingtask.datasnapshot.controller;

import com.codingtask.datasnapshot.entity.CorruptData;
import com.codingtask.datasnapshot.service.ReconDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/corruptdata")
public class CorruptDataController {

    private static final Logger logger = Logger.getLogger(CorruptDataController.class.getName());

    @Autowired
    private ReconDataService reconDataService;

    @GetMapping("/")
    public List<CorruptData> findAllData() {
        return reconDataService.findAllCorruptData();
    }

    @GetMapping("/count")
    public long corruptDataCount() {
        return reconDataService.findCorruptDataCount();
    }
}
