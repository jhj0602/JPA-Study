package com.ssafy.study.email.dto;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
public class EmailDto {
    @NotBlank
    @Email(message = "email 형식이 아닙니다.")
    private String email;
}
