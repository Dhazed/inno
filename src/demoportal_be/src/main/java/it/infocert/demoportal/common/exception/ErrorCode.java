package it.infocert.demoportal.common.exception;

public enum ErrorCode {
  VALIDATION,
  GENERIC,
  NOT_FOUND,
  AUTHENTICATION,
  FORBIDDEN,
  PRECONDITION;

  public DemoPortalGenericException exception(String message) {
    return new DemoPortalGenericException(this, message);
  }
}
