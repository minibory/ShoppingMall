package com.kjk.web.service;

import com.kjk.web.Repository.UserRepository;
import com.kjk.web.config.CustomUserDetail;
import com.kjk.web.model.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        List<User> user = userRepository.findByUsername(loginId);

        if(user.size() == 0){
            throw new UsernameNotFoundException(loginId);
        }

//        User userDetail = user.get(0);
//
//        return org.springframework.security.core.userdetails.User
//                .builder()
//                .username(userDetail.getLoginId())
//                .password(userDetail.getPassword())
//                .roles("USER")
//                .build();
        return new CustomUserDetail(user.get(0));
    }
}
