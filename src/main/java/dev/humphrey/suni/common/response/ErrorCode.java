package dev.humphrey.suni.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    /*
        TBD: 서비스 영역에서 발생하는 에러는 Business Exception에서 사용하는 별도의 Code Set을 사용하고자 함
     */
    COMMON_SYSTEM_ERROR("일시적인 오류가 발생했습니다. 잠시 후 다시 시도해주세요."), // 장애 상황
    COMMON_INVALID_PARAMETER("요청한 값이 올바르지 않습니다."),

    ;

    private final String errorMsg;
}