package net.fiv.backend.service.service;

import net.fiv.backend.exception.AlreadyExistsException;
import net.fiv.backend.service.impl.UserDetailsImpl;
import net.fiv.backend.model.User;
import net.fiv.backend.repository.UserDAO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDetailsService {

    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
                String.format("User %s not found", username)
        ));
        return UserDetailsImpl.build(user);
    }

    @Transactional
    public void register(User user) throws AlreadyExistsException {
        if(userDAO.existsByUsername(user.getUsername())){
            throw new AlreadyExistsException("Username already exists");
        }
        if(userDAO.existsByEmail(user.getEmail())){
            throw new AlreadyExistsException("Email already exists");
        }

        userDAO.save(user);
    }

    public User getUserByUsername(String username) {
        return userDAO.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User %s not found", username)));
    }

}
