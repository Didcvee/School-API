package ru.didcvee.scheduleservice.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.didcvee.scheduleservice.exception.response.ResponseError;

@Slf4j
@RestControllerAdvice
public class ControllerException {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseError handle(RuntimeException runtimeException) {
        log.error(runtimeException.getMessage(), runtimeException);
        return new ResponseError(runtimeException.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
