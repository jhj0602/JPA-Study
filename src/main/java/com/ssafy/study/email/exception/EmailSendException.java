package com.ssafy.study.email.exception;

import com.ssafy.study.common.error.ErrorCode;
import com.ssafy.study.common.error.StudyException;

public class EmailSendException extends StudyException {
    public EmailSendException() {
        super(ErrorCode.EMAIL_SEND_ERROR);
    }
}
