package com.ssafy.study.member.enitity;

import com.ssafy.study.comment.Comment;
import com.ssafy.study.board.enitity.Board;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String userName;

    @OneToMany(fetch = FetchType.LAZY)//fetch join N+1문제 해결 방법 //단방향 양방향 맵핑
    private Set<Board> boards =  new LinkedHashSet<>();

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Comment> comments =   new LinkedHashSet<>();

    @Builder
    public Member(String userName) {
        this.userName = userName;
    }
}
