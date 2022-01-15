package com.ssafy.study.board.enitity;

import com.ssafy.study.comment.Comment;
import com.ssafy.study.member.enitity.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    private String content;

    private Integer views;

    @ManyToOne(fetch = FetchType.LAZY)//fetch join N+1문제 해결 방법
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();

    @Builder
    public Board(String content, Member member) {
        this.content = content;
        this.views= 0;
        this.member = member;
    }

    public void addView() {
        this.views ++;
    }
}
