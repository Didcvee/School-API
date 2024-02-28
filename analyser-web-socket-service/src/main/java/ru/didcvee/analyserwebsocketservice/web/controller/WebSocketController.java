package ru.didcvee.analyserwebsocketservice.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.didcvee.analyserwebsocketservice.config.WebSocketHandler;

@RequiredArgsConstructor
@RestController
public class WebSocketController {

    private final WebSocketHandler webSocketHandler;
    @GetMapping
    public void processMessage() {
        int i = 0;
        i++;
        webSocketHandler.sendMessageToAll("hello" + i);
    }
}
