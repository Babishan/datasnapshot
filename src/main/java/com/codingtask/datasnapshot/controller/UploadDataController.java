package com.codingtask.datasnapshot.controller;

import com.codingtask.datasnapshot.service.ReconDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.logging.Logger;

@RestController
@RequestMapping("/uploaddata")
public class UploadDataController {

    private static final Logger logger = Logger.getLogger(ReconDataController.class.getName());

    @Autowired
    private ReconDataService reconDataService;

    @PostMapping("/csv")
    public ResponseEntity<String> uploadData(@RequestParam("file") MultipartFile file) throws Exception {

        if (file == null) {
            throw new RuntimeException("You must select the a file for uploading");
        }

        InputStream inputStream = file.getInputStream();
        String originalName = file.getOriginalFilename();
        String contentType = file.getContentType();

        reconDataService.validateAndPersist(inputStream);

        return new ResponseEntity<String>(originalName, HttpStatus.OK);
    }
}
