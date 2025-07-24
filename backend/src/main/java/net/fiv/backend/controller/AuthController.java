package net.fiv.backend.controller;

import net.fiv.backend.DTO.LoginRequest;
import net.fiv.backend.DTO.SignupRequest;
import net.fiv.backend.config.jwtConfig.JwtCore;
import net.fiv.backend.mapper.impl.UserMapperImpl;
import net.fiv.backend.model.User;
import net.fiv.backend.service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtCore jwtCore;
    private final UserService userService;
    private final UserMapperImpl userMapper;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserService userService, AuthenticationManager authenticationManager, JwtCore jwtCore, UserMapperImpl userMapper, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtCore = jwtCore;
        this.userService = userService;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication;

        authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        String jwt = jwtCore.generateToken(authentication);

        return ResponseEntity.ok(jwt);
    }

    @PostMapping("/register")
    public ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest){
        User user = userMapper.mapFrom(signupRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.register(user);

        return ResponseEntity.status(HttpStatus.CREATED).body("Created user successfully");
    }

}
