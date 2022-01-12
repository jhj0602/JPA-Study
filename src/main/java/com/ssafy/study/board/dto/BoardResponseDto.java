package com.ssafy.study.board.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ssafy.study.board.enitity.Board;
import com.ssafy.study.comment.CommentResponseDto;
import lombok.Getter;

import java.util.List;

@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BoardResponseDto {

    private Long id;

    private String writer;

    private String content;

    private List<CommentResponseDto> comments;

    private Integer totalComment;


    public BoardResponseDto(Board board, List<CommentResponseDto> comments) { //단건 조회
        this.id = board.getId();
        this.writer = board.getMember().getUserName();
        this.content = board.getContent();
        this.comments = comments;
    }

    public BoardResponseDto(Board board, Integer totalComment) { // 전체조회
      this.id = board.getId();
      this.writer = board.getMember().getUserName();
      this.content = board.getContent();
      this.totalComment = totalComment;
    }
}
