package ru.didcvee.analyserwebsocketservice.web.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.didcvee.analyserwebsocketservice.exc.GroupNotFoundException;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(GroupNotFoundException.class)
    public String groupNotFound(GroupNotFoundException e) {
        return "Group not found";
    }
    @ExceptionHandler
    public String server(Exception e) {
        e.printStackTrace();
        return "Something happened.";
    }
}
