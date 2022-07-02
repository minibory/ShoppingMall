package com.kjk.web.service;

import com.kjk.web.Repository.UserRepository;
import com.kjk.web.model.role.Role;
import com.kjk.web.model.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void save(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setActive(true);
        user.setRole(new Role());
        userRepository.save(user);
    }

    @Override
    public Boolean usernameValidate(String username) {
        return (userRepository.usernameValidate(username) == 0);
    }
}
