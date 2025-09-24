package com.example.docksystem_erp.controller.User;

import com.example.docksystem_erp.dto.User.UserLoginDto;
import com.example.docksystem_erp.service.User.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth/api")
public class UserInternalController {

    private final UserService userService;

    @Value("${api.secret}")
    private String apiSecret;

    // 인증 서버의 WebClient가 호출하는 API 엔드포인트
    @GetMapping("/{userId}")
    public ResponseEntity<UserLoginDto> getUserAuthInfo(@PathVariable String userId, @RequestHeader("X-API-Key") String apiKey) {

        // 1. API Key 검증
        if (!apiSecret.equals(apiKey)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED); // 401 Unauthorized
        }

        try {
            // 2. 서비스 로직 호출 및 응답 반환
            UserLoginDto authInfo = userService.findByUserId(userId);
            return ResponseEntity.ok(authInfo);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
        }
    }




}
