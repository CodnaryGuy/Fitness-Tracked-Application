package com.codna.fitness.controller;

import com.codna.fitness.dto.LoginRequest;
import com.codna.fitness.dto.LoginResponse;
import com.codna.fitness.dto.RegisterRequest;
import com.codna.fitness.dto.UserResponse;
import com.codna.fitness.model.User;
import com.codna.fitness.repository.UserRepository;
import com.codna.fitness.security.JwtUtils;
import com.codna.fitness.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final JwtUtils jwtUtils;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@Valid @RequestBody RegisterRequest registerRequest){
        return ResponseEntity.ok(userService.register(registerRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        try{
            User user = userService.authenticate(loginRequest);
            String token = jwtUtils.generateToken(user.getId(), user.getRole().name());

            return ResponseEntity.ok(new LoginResponse(
                    token, userService.mapToResponse(user)
            ));

        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).build();
        }
    }
}
