package com.ssafy.study.common.error;

import lombok.Getter;

@Getter
public class StudyException extends RuntimeException {

    private ErrorCode errorCode;

    public StudyException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

}