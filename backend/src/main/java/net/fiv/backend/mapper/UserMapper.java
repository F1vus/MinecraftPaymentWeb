package net.fiv.backend.mapper;

import net.fiv.backend.DTO.SignupRequest;
import net.fiv.backend.model.User;

public class UserMapper {

    public static User fromSignupRequest(SignupRequest signupRequest) {
        User user = new User();
        user.setUsername(signupRequest.getUsername());
        user.setPassword(signupRequest.getPassword());
        user.setEmail(signupRequest.getEmail());
        return user;
    }

}
