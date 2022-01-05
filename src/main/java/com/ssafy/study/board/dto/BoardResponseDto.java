package com.ssafy.study.board.dto;

import com.ssafy.study.board.enitity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardResponseDto {

    private Long id;
    private String content;
    private String userName;

    public static BoardResponseDto from(Board board) { //정적 팩토리 메소드 https://tecoble.techcourse.co.kr/post/2020-05-26-static-factory-method/
        return new BoardResponseDto(board.getId(), board.getContent(),
                board.getMember().getUserName());
    }
}
