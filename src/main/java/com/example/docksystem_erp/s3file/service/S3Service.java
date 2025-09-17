//package com.example.docksystem_erp.s3file.service;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//import software.amazon.awssdk.core.sync.RequestBody;
//import software.amazon.awssdk.services.s3.S3Client;
//import software.amazon.awssdk.services.s3.model.PutObjectRequest;
//
//import java.io.IOException;
//
//@Service
//@RequiredArgsConstructor
//public class S3Service {
//
//    private final S3Client s3Client;
//
//    @Value("${cloud.aws.s3.bucket}")
//    private String bucketName;
//
//    public String uploadFile(MultipartFile file) throws IOException {
//        String fileName = file.getOriginalFilename(); // 원본 파일명
//
//        // S3에 업로드할 요청 객체 생성
//        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
//                .bucket(bucketName)
//                .key(fileName) // S3에 저장될 파일명
//                .build();
//
//        // S3에 파일 업로드
//        s3Client.putObject(putObjectRequest, RequestBody.fromInputStream(file.getInputStream(), file.getSize()));
//
//        // S3에 업로드된 파일의 URL 반환
//        return s3Client.utilities().getUrl(builder -> builder.bucket(bucketName).key(fileName)).toString();
//    }
//}