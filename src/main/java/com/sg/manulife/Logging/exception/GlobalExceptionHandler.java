package com.sg.manulife.Logging.exception;

import com.sg.manulife.Logging.constant.CommonConstant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = NoSuchEmployeeExistsException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public @ResponseBody ResponseEntity<ErrorResponse> handleException(NoSuchEmployeeExistsException ex) {
    ErrorResponse errorResponse = new ErrorResponse();
    errorResponse.setStatusCode(HttpStatus.NOT_FOUND.toString());
    errorResponse.setMessage(CommonConstant.ERROR_MESSAGE);
    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
  }
}
