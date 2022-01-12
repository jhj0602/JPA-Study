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

import static com.ssafy.study.common.message.SuccessMessage.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponseDto> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(CommonResponseDto.of(
                HttpStatus.OK, SUCCESS_GET_BOARD, boardService.findById(id))
        );
    }

    @GetMapping
    public ResponseEntity<CommonResponseDto> findAll(@RequestParam(value = "limit", defaultValue = "1") int limit) {
        return ResponseEntity.ok().body(CommonResponseDto.of(
                HttpStatus.OK, SUCCESS_GET_BOARD_LIST, boardService.findAll(limit))
        );
    }

    @GetMapping("/{userId}")
    public ResponseEntity<CommonResponseDto> findByMemberId(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok().body(CommonResponseDto.of(
                HttpStatus.OK, SUCCESS_GET_BOARD_LIST_USER, boardService.findByMemberId(userId))
        );
    }


    @PostMapping("/validtest")
    public ResponseEntity<Void> validTest(@RequestBody @Valid ValidErrorTestDto validErrorTestDto) {
        log.info(validErrorTestDto.toString());
        return new ResponseEntity(HttpStatus.OK);
    }
}
