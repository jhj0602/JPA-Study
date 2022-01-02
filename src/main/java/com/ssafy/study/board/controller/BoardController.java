package com.ssafy.study.board.controller;

import com.ssafy.study.board.common.response.CommonResponseDto;
import com.ssafy.study.board.dto.ValidErrorTestDto;
import com.ssafy.study.board.enitity.Board;
import com.ssafy.study.board.enitity.BoardRepository;
import com.ssafy.study.board.exception.NotBoardException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardRepository boardRepository;

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponseDto> boardFindById(@PathVariable("id") Long id) {
        Board board = boardRepository.findById(id).orElseThrow(NotBoardException::new);
        return new ResponseEntity<>(new CommonResponseDto(board),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<CommonResponseDto> boardFindAll() {
        return new ResponseEntity<>(
                new CommonResponseDto(boardRepository.findAll()), HttpStatus.OK
        );
    }

    @PostMapping("/validtest")
    public ResponseEntity<Void> validTest(@RequestBody @Valid ValidErrorTestDto validErrorTestDto){
        log.info(validErrorTestDto.toString());
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
