package com.ssafy.study.member;

import com.ssafy.study.board.enitity.Board;
import com.ssafy.study.board.enitity.BoardRepository;
import com.ssafy.study.member.enitity.Member;
import com.ssafy.study.member.enitity.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;



@SpringBootTest
@Transactional
public class MemberTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    BoardRepository boardRepository;

    @Test
    public void EntityGraph_설정안했을때() throws Exception {
        Member member = new Member("member");
        memberRepository.save(member);
        Member member2 = new Member("member2");
        memberRepository.save(member2);
        List<Member> all = memberRepository.findAll();
        assertThat(all.size()).isEqualTo(2);
        boardRepository.save(Board.builder().content("content2").build());
        List<Board> boards = boardRepository.findAll();
    }

}