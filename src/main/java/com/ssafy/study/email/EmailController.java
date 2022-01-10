package com.ssafy.study.email;


import com.ssafy.study.email.dto.EmailCodeDto;
import com.ssafy.study.email.dto.EmailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/email") // 이메일 인증 코드 보내기
    public ResponseEntity<String> sendEmail(@RequestBody @Valid EmailDto email) {
        emailService.sendEmailMessage(email.getEmail());
        return new ResponseEntity(true, HttpStatus.OK);
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verifyCode(@RequestBody @Valid EmailCodeDto code) {
        boolean userId = emailService.getUserIdByCode(code.getCode());
        return new ResponseEntity(1, HttpStatus.OK);
    }
}