package com.ssafy.study.comment;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class CommentResponseDto {
    private final Long commentId;
    private final String content;
    private final String userName;


    public CommentResponseDto(Comment comment) {
        this.commentId = comment.getId();
        this.content = comment.getContent();
        this.userName = comment.getMember().getUserName();
    }


}
