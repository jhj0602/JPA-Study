package com.ssafy.study.board.controller;

import com.ssafy.study.board.dto.ValidErrorTestDto;
import com.ssafy.study.board.service.BoardService;
import com.ssafy.study.common.response.CommonResponseDto;
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
    private final BoardService boardService;

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponseDto> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(new CommonResponseDto(boardService.findById(id)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<CommonResponseDto> findAll() {
        return new ResponseEntity<>(
                new CommonResponseDto(boardService.findAll()), HttpStatus.OK);
    }

    @PostMapping("/validtest")
    public ResponseEntity<Void> validTest(@RequestBody @Valid ValidErrorTestDto validErrorTestDto) {
        log.info(validErrorTestDto.toString());
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
