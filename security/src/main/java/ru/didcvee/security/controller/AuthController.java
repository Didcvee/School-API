package ru.didcvee.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.didcvee.security.entity.UserCredential;
import ru.didcvee.security.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    public AuthController(AuthService service) {
        this.service = service;
    }
    private final AuthService service;
    @PostMapping("/register")
    public String addNewUser(@RequestBody UserCredential user) {
        return service.saveUser(user);
    }
    @GetMapping("/token")
    public String getToken(UserCredential user) {
        return service.generateToken(user.getName());
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        service.validateToken(token);
        return "Token is valid";
    }



}
