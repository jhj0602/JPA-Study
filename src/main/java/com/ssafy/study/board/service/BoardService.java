package com.ssafy.study.board.service;

import com.ssafy.study.board.dto.BoardResponseDto;
import com.ssafy.study.board.enitity.Board;
import com.ssafy.study.board.enitity.BoardRepository;
import com.ssafy.study.board.exception.NotBoardException;
import com.ssafy.study.member.enitity.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;


    public List<BoardResponseDto> findAll() {
        List<Board> boards = boardRepository.findAll();
        return boards.stream().map(BoardResponseDto::from).collect(Collectors.toList());
    }

    public BoardResponseDto findById(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(NotBoardException::new);
        return BoardResponseDto.from(board);
    }

}
