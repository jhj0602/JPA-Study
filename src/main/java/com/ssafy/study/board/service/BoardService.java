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


    //    public List<BoardResponseDto> findAll() {
//        List<Board> boards = boardRepository.findAll();
//        return boards.stream().map(BoardResponseDto::from).collect(Collectors.toList());
//    }
    @Transactional(readOnly = true)
    public BoardResponseDto findById(Long boardId) {

        List<Comment> findComments = commentRepository.findByJoinBoardId(boardId);
        List<CommentResponseDto> comments = findComments.stream()
                .map(comment -> new CommentResponseDto(comment))
                .collect(Collectors.toList());
        log.info(comments.size() + ": size");
        Board board = boardRepository.findById(boardId).orElseThrow(NotBoardException::new);
        log.info(comments.size() + ": size");
        return BoardResponseDto.from(board, comments);
    }


//    @Transactional(readOnly = true)
//    public BoardResponseDto findById(Long boardId) {
//        log.info(boardId+" ");
//        Board board = boardRepository.findById(boardId).orElseThrow(NotBoardException::new);
//        log.info(board.getComments().size()+" ");
//        return BoardResponseDto.from(board);
//    }

//    public List<BoardResponseDto> findByMemberId(Long userId) {
//        List<Board> boards = boardRepository.findByMemberId(userId);
//        return boards.stream().map(BoardResponseDto::from).collect(Collectors.toList());
//    }
}
