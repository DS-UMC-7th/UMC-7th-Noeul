package umc.spring.apiPayload.code;

import umc.spring.apiPayload.ErrorReasonDTO;
import org.springframework.http.HttpStatus;

public interface BaseErrorCode {

    // 에러 코드의 HttpStatus를 반환
    HttpStatus getHttpStatus();

    // 에러 메시지를 반환
    String getMessage();

    // 에러 코드를 반환
    String getCode();

    // 에러의 상세 정보를 담은 ErrorReasonDTO를 반환
    ErrorReasonDTO getReason();

    // HttpStatus를 포함한 ErrorReasonDTO를 반환
    ErrorReasonDTO getReasonHttpStatus();
}
