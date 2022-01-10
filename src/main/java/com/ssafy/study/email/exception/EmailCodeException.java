package com.ssafy.study.email.exception;

import com.ssafy.study.common.error.ErrorCode;
import com.ssafy.study.common.error.StudyException;

public class EmailCodeException  extends StudyException {
    public EmailCodeException() {
        super(ErrorCode.EMAIL_NOT_CODE);
    }
}
