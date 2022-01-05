package com.ssafy.study.common.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum ErrorCode {

    INVALID_INPUT_VALUE(400, "Invalid input value."),
    EMAIL_TOO_LONG(400, "Email too long."),
    REQUEST_FAIL_TO_OTHER_SERVER(400, "Request fail to other server."),
    BOARD_NOT_FOUNT(404, "Board not found."),
    USER_NOT_FOUND(404, "User not found.");

    private final int status;
    private final String message;

}
