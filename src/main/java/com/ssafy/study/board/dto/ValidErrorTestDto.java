package com.ssafy.study.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ValidErrorTestDto {

    @NotBlank(message = "test1 없음")
    private String test1;

    @NotBlank(message = "test2 없음")
    @Size(min = 5, max = 10)
    private String test2;
}
