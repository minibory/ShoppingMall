package com.kjk.web.controller.web;

import com.kjk.web.model.user.User;
import com.kjk.web.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class LoginWebController {

    private final UserService userService;


    /**
     * 로그인 페이지로 이동
     */
    @GetMapping("/login-form")
    public String loginForm() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(!(auth instanceof AnonymousAuthenticationToken)) {
            return "redirect:/";
        }
        return "account/login";
    }
    
    /**
     * 회원가입 페이지로 이동
     */
    // 회원가입 페이지
    @GetMapping("/join-form")
    public String joinForm() {
        return "account/join";
    }

    /**
     * 가입 성공
     */
    @PostMapping("/join")
    public String register(User user) throws IOException {
        userService.save(user);

        return "handler/joinSuccess";
    }

    /**
     * 로그인 실패
     */
    @PostMapping("/login-fail")
    public String loginFail() {
        return "handler/loginFail";
    }
}
