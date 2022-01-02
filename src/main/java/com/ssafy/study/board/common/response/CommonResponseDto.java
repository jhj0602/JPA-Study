package com.ssafy.study.board.common.response;

import com.ssafy.study.board.enitity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Optional;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponseDto<T> {
    T data;
}