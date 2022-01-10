package com.ssafy.study.email.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class EmailCodeDto {
    @NotBlank
    private String code;
}
