package com.codingtask.datasnapshot.controller;


import com.codingtask.datasnapshot.entity.ReconData;
import com.codingtask.datasnapshot.service.ReconDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/recondata")
public class ReconDataController {

    private static final Logger logger = Logger.getLogger(ReconDataController.class.getName());

    @Autowired
    private ReconDataService reconDataService;

    @GetMapping("/")
    public List<ReconData> findAllData() {
        return reconDataService.findAllData();
    }

    @GetMapping("/{id}")
    public ReconData findDataById(@PathVariable String id) {
        return reconDataService.findDataById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteDataById(@PathVariable String id) {
        reconDataService.deleteDataById(id);
    }

    @PostMapping("/uploaddata")
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
    @GetMapping("/corruptdatacount")
    public long corruptDataCount() {
        return reconDataService.findCorruptDataCount();
    }
}
