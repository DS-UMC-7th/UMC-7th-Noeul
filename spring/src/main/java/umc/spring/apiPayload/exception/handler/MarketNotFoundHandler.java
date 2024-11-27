package umc.spring.apiPayload.exception.handler;

import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.exception.GeneralException;

public class MarketNotFoundHandler extends GeneralException {
  public MarketNotFoundHandler(BaseErrorCode errorCode) {
    super(errorCode);
  }
}
