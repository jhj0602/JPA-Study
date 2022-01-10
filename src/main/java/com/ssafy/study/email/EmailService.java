package com.ssafy.study.email;

import com.ssafy.study.email.config.RedisUtil;
import com.ssafy.study.email.exception.EmailCodeException;
import com.ssafy.study.email.exception.EmailSendException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Random;

@RequiredArgsConstructor
@Service
@Slf4j
public class EmailService {

    private final JavaMailSender emailSender;
    private final RedisUtil redisUtil;

    public void sendEmailMessage(String email) {
        try {
            String code = createCode();
            redisUtil.setDataExpire(code, email, 60 * 5L);
            MimeMessage message = createMessage(email, code);
            emailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
            throw new EmailSendException();
        }
    }

    private MimeMessage createMessage(String toEmail, String code) throws Exception {
        MimeMessage message = emailSender.createMimeMessage();
        message.addRecipients(RecipientType.TO, toEmail); //보내는 대상
        message.setSubject("ssafe 확인 코드: " + code); //제목
        String msg = "";
        msg += "<h1 style=\"font-size: 30px; padding-right: 30px; padding-left: 30px;\">Ssafe 회원 가입을 위한 본인 확인 메일 입니다.</h1>";
        msg += "<p style=\"font-size: 17px; padding-right: 30px; padding-left: 30px;\">본인 확인을 위하여 아래의 ID 및 인증 번호를 확인하신 후, 회원 가입 창에 입력하여 주시기바랍니다.</p>";
        msg += "<p style=\"font-size: 17px; padding-right: 30px; padding-left: 30px;\">인증 번호 : " + code + "</p>";
        msg += "<p style=\"font-size: 17px; padding-right: 30px; padding-left: 30px;\">감사합니다.";
        message.setText(msg, "utf-8", "html"); //내용
        message.setFrom(new InternetAddress("ssafe@ssafe.com", "ssafe 관리자")); //보내는 사람
        return message;
    }


    // 인증코드 만들기
    private String createCode() {
        StringBuilder code = new StringBuilder();
        Random rnd = new Random();
        for (int i = 0; i < 7; i++) {
            int rIndex = rnd.nextInt(3);
            switch (rIndex) {
                case 0:
                    code.append((char) (rnd.nextInt(26) + 97));
                    break;
                case 1:
                    code.append((char) (rnd.nextInt(26) + 65));
                    break;
                case 2:
                    code.append((rnd.nextInt(10)));
                    break;
            }
        }
        return code.toString();
    }

    public boolean getUserIdByCode(String code) {
        String email = redisUtil.getData(code); // 입력 받은 인증 코드(key)를 이용해 email(value)을 꺼낸다.
        if (email == null) { // email이 존재하지 않으면, 유효 기간 만료이거나 코드 잘못 입력
            throw new EmailCodeException();
        }
        return true;
    }

}