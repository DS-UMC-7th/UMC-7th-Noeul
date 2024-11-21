package umc.spring.apiPayload.exception.handler;

import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.exception.GeneralException;

public class MissionNotFoundHandler extends GeneralException {
    public MissionNotFoundHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
