package com.ssafy.study.board.exception;

import com.ssafy.study.common.error.ErrorCode;
import com.ssafy.study.common.error.StudyException;

public class NotBoardException extends StudyException {
    public NotBoardException() {
        super(ErrorCode.BOARD_NOT_FOUNT);
    }
}
