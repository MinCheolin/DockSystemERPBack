package com.example.docksystem_erp.s3file.controller;

import com.example.docksystem_erp.s3file.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class S3FileUploadController {

    private final S3Service s3Service;

    @PostMapping("/s3")
    public ResponseEntity<String> uploadToS3(@RequestParam("file") MultipartFile file) {
        try {
            String fileUrl = s3Service.uploadFile(file);
            return ResponseEntity.ok("파일 업로드 성공" + fileUrl);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("파일 업로드 실패");
        }
    }
}
