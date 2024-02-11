package ru.didcvee.mainservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.didcvee.mainservice.dto.OrderResponseDTO;
import ru.didcvee.mainservice.service.SwiggyAppService;

@RestController
@RequestMapping("/swiggy")
public class SwiggyAppController {

    @Autowired
    private SwiggyAppService service;

    @GetMapping("/home")
    public String greetingMessage() {
        return service.greeting();
    }

    @GetMapping("/{orderId}")
    public OrderResponseDTO checkOrderStatus(@PathVariable String orderId, @RequestHeader("loggedInUser") String username) {
        System.out.println("logged in user details: "+username);
        return service.checkOrderStatus(orderId);
    }
}
