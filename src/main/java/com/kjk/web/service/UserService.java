package com.kjk.web.service;

import com.kjk.web.Repository.UserRepository;
import com.kjk.web.model.Role;
import com.kjk.web.model.User;
import com.kjk.web.type.UserRoleType;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void save(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setActive(true);
        user.setRole(new Role());
        userRepository.save(user);
    }
}
