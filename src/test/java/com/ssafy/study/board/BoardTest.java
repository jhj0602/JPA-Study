package com.ssafy.study.board;

import com.ssafy.study.board.enitity.Board;
import com.ssafy.study.board.enitity.BoardRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTest {
    @Autowired
    BoardRepository boardRepository;

    @Test
    @Transactional
    public void 영속성컨텍스트이해한거() throws Exception {
        Board board = new Board(1L,"영속성알고쓰자.");
        Board board1 = boardRepository.save(board);
        String str =  "영속성 알고쓰자 Update";
        Board boardUpdate = boardRepository.findById(board1.getId()).orElseThrow(()->new IllegalArgumentException("없움"));
//        boardUpdate.setContent(str);
        Board boardUpdate2 = boardRepository.findById(board1.getId()).orElseThrow(()->new IllegalArgumentException("없움"));
        Assertions.assertThat(boardUpdate.getContent()).isEqualTo(boardUpdate2.getContent());
    }

    @Test
    public void 영속성컨텍스트이해못한거() throws Exception {
        //given

        //when

        //then

    }
}

//    @Test
//    @Transactional
//    @Rollback(false)
//    public void testMember() {
//        Member member = new Member();
//        member.setUsername("memberA");
//        Long savedId = memberRepository.save(member);
//        Member findMember = memberRepository.find(savedId);
//        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
//        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
//        Assertions.assertThat(findMember).isEqualTo(member); //JPA 엔티티 동일성 보장
//    }