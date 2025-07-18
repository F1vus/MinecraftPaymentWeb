package net.fiv.backend.service.service;

import net.fiv.backend.DTO.SignupRequest;
import net.fiv.backend.mapper.UserMapper;
import net.fiv.backend.service.impl.UserDetailsImpl;
import net.fiv.backend.model.User;
import net.fiv.backend.repository.UserDAO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDetailsService {

    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserDAO userDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
                String.format("User %s not found", username)
        ));
        return UserDetailsImpl.build(user);
    }

    public void register(SignupRequest request) {
        if(userDAO.existsByUsername(request.getUsername())){
            throw new RuntimeException("Username already exists");
        }
        if(userDAO.existsByEmail(request.getEmail())){
            throw new RuntimeException("Email already exists");
        }

        User user = UserMapper.fromSignupRequest(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDAO.save(user);
    }

}
