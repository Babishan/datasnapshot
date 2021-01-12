package com.codingtask.datasnapshot.controller;

import com.codingtask.datasnapshot.service.ReconDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/corruptdata")
public class CoruptDataController {

    private static final Logger logger = Logger.getLogger(CoruptDataController.class.getName());

    @Autowired
    private ReconDataService reconDataService;

    @GetMapping("/count")
    public long corruptDataCount() {
        return reconDataService.findCorruptDataCount();
    }
}
