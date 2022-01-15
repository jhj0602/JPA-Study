package com.ssafy.study.board.service;

import com.ssafy.study.board.dto.BoardResponseDto;
import com.ssafy.study.board.enitity.Board;
import com.ssafy.study.board.enitity.BoardRepository;
import com.ssafy.study.board.exception.NotBoardException;
import com.ssafy.study.comment.Comment;
import com.ssafy.study.comment.CommentRepository;
import com.ssafy.study.comment.CommentResponseDto;
import com.ssafy.study.member.enitity.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor //DI
@Transactional(readOnly = true)
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;
    private final CommentRepository commentRepository;


    public List<BoardResponseDto> findAll(int limit) {
        Page<Board> boards = boardRepository.findAll(
                PageRequest.of(limit - 1, 4, Sort.by(Sort.Direction.DESC, "id")));
        return boards.stream().map(board -> {
            Integer totalComment = commentRepository.countByBoardId(board.getId());
            return new BoardResponseDto(board, totalComment);
        }).collect(Collectors.toList());
    }
    public BoardResponseDto findById(Long boardId) {
        List<Comment> findComments = commentRepository.findByJoinBoardId(boardId);
        List<CommentResponseDto> comments = findComments.stream()
                .map(comment -> new CommentResponseDto(comment))
                .collect(Collectors.toList());
        Board board = boardRepository.findById(boardId).orElseThrow(NotBoardException::new);
        return new BoardResponseDto(board, comments);
    }

    public List<BoardResponseDto> findByMemberId(Long userId) {
        List<Board> boards = boardRepository.findByMemberId(userId);
        return boards.stream().map(board -> {
            Integer totalComment = commentRepository.countByBoardId(board.getId());
            return new BoardResponseDto(board, totalComment);
        }).collect(Collectors.toList());
    }

    @Transactional
    public void addView(Long boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(NotBoardException::new);
        board.addView();
    }
}
