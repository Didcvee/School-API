package ru.didcvee.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.didcvee.security.entity.UserCredential;
import ru.didcvee.security.repository.UserCredentialRepository;

@Service
public class AuthService {
    private final UserCredentialRepository userCredRepository;
    private final PasswordEncoder encoder;
    private final JWTService jwtService;

    @Autowired
    public AuthService(UserCredentialRepository userCredRepository, PasswordEncoder encoder, JWTService jwtService) {
        this.userCredRepository = userCredRepository;
        this.encoder = encoder;
        this.jwtService = jwtService;
    }

    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }
    public void validateToken(String token) {
        jwtService.validateToken(token);
    }

    public String saveUser(UserCredential userCredential){
        userCredential.setPassword(encoder.encode(userCredential.getPassword()));

        userCredRepository.save(userCredential);

        return "user Added to system";
    }
}
