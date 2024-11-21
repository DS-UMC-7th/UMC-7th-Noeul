package umc.spring.apiPayload.exception.handler;

import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.exception.GeneralException;

public class LocationNotFoundHandler extends GeneralException {
    public LocationNotFoundHandler(BaseErrorCode errorCode) {
      super(errorCode);
    }
}
