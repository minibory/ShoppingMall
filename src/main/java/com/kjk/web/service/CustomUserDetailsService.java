package com.kjk.web.service;

import com.kjk.web.Repository.UserRepository;
import com.kjk.web.config.CustomUserDetail;
import com.kjk.web.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        List<User> user = userRepository.findById(loginId);

        if(user.size() == 0){
            throw new UsernameNotFoundException(loginId);
        }
        return new CustomUserDetail(user.get(0));
    }
}
