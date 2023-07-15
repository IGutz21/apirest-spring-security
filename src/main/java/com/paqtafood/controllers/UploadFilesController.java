package com.paqtafood.controllers;

import com.paqtafood.services.IUploadFilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/images")
public class UploadFilesController {

    @Autowired
    private IUploadFilesService uploadFilesService;

    @PostMapping("/picture")
    private ResponseEntity<String> uploadPic(@RequestParam("file") MultipartFile file) throws Exception {
        return ResponseEntity.ok(uploadFilesService.handleFileUpload(file));
    }

}
