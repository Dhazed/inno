package it.infocert.demoportal.common.exception;

import static it.infocert.demoportal.common.exception.ErrorCode.*;
import static it.infocert.demoportal.common.exception.DemoPortalException.*;

public class DemoPortalGenericException extends Exception {

  private static final long serialVersionUID = -8309085138050729873L;

  private ErrorCode code;

  public DemoPortalGenericException(ErrorCode ec, String message) {
    super(message);
    code = ec;
  }

  public ErrorCode getCode() {
    return code;
  }

  public static DemoPortalGenericException fromDemoPortalException(DemoPortalException e) {
    String code = e.getCode();

    if (ERROR_CODE_INVALID_PARAM.equals(code)) {
      return VALIDATION.exception(e.getMessage());
    } else if (ERROR_CODE_NOT_FOUND.equals(code)) {
      return NOT_FOUND.exception(e.getMessage());
    } else if (ERROR_INVALID_DOMAIN.equals(code)
        || ERROR_INVALID_ORGANIZATION.equals(code)
        || ERROR_CODE_INVALID_STATUS.equals(code)) {
      return PRECONDITION.exception(e.getMessage());
    }
    // else if(ERROR_CODE_IMP_CERT.equals(code)){}
    // else if(ERROR_CODE_GEN_P10.equals(code)){}
    // else if(ERROR_CODE_GEN_KEY.equals(code)){}
    // else if(ERROR_CODE_MAIL.equals(code)){}
    // else if(ERROR_CODE_DUPLICATED_KEY.equals(code)){}
    else if (ERROR_CODE_CA_GEN.equals(code)) {
      return GENERIC.exception(e.getMessage());
    }
    // else if(ERROR_CODE_PERSIST.equals(code)){}
    // else if(ERROR_CODE_GEN_SCIC.equals(code)){}
    // else if(ERROR_CODE_GEN_PKCS12.equals(code)){}
    // else if(ERROR_CODE_CONNECTION.equals(code)){}
    else {
      return GENERIC.exception("Generic Error");
    }
  }
}
