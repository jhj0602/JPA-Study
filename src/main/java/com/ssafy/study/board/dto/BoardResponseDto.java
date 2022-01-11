package com.ssafy.study.board.dto;

import com.ssafy.study.board.enitity.Board;
import com.ssafy.study.comment.Comment;
import com.ssafy.study.comment.CommentResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Set;

@Getter
@AllArgsConstructor
public class BoardResponseDto {

    private Long id;

    private String writer;

    private String content;


    private List<CommentResponseDto> comments;


    public static BoardResponseDto from(Board board, List<CommentResponseDto> comments) { //정적 팩토리 메소드 https://tecoble.techcourse.co.kr/post/2020-05-26-static-factory-method/
        return new BoardResponseDto(board.getId(), board.getMember().getUserName(), board.getContent(), comments);
    }


//    public static BoardResponseDto from(Board board) { //정적 팩토리 메소드 https://tecoble.techcourse.co.kr/post/2020-05-26-static-factory-method/
//        return new BoardResponseDto(board.getId(), board.getContent(),
//                board.getMember().getUserName(),board.getComments());
//    }
}
