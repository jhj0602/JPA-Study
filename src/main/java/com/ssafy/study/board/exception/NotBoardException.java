package com.ssafy.study.board.exception;

import com.ssafy.study.board.common.error.ErrorCode;
import com.ssafy.study.board.common.error.StudyException;

public class NotBoardException extends StudyException {
    public NotBoardException() {
        super(ErrorCode.NOT_YOUR_BOARD);
    }
}
