package umc.spring.apiPayload.exception.handler;

import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.exception.GeneralException;

public class UserNotFoundException extends GeneralException {
    public UserNotFoundException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
