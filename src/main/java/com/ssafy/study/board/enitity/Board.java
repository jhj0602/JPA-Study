package com.ssafy.study.board.enitity;

import com.ssafy.study.member.enitity.Member;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)//fetch join N+1문제 해결 방법
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Board(String content, Member member) {
        this.content = content;
        this.member = member;
    }
}
