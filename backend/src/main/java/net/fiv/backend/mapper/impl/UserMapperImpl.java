package net.fiv.backend.mapper.impl;

import net.fiv.backend.DTO.SignupRequest;
import net.fiv.backend.mapper.Mapper;
import net.fiv.backend.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements Mapper<User, SignupRequest> {
    private final ModelMapper modelMapper;

    public UserMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public SignupRequest mapTo(User user) {
        return modelMapper.map(user, SignupRequest.class);
    }

    @Override
    public User mapFrom(SignupRequest signupRequest) {
        return modelMapper.map(signupRequest, User.class);
    }
}
