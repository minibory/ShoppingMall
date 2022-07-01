package com.kjk.web.controller.web;

import com.kjk.web.Repository.UserRepository;
import com.kjk.web.model.User;
import com.kjk.web.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginWebController {

    private final UserService userService;

    // 로그인 페이지
    @GetMapping("/login")
    public String login() {
        // 로그인 여부 체크 후 로그인 상태면 productList
        if(false) {
            return "redirect:/menu/product";
        }
        return "account/login";
    }

    // 회원가입 페이지
    @GetMapping("/join")
    public String join() {
        return "account/join";
    }

    @PostMapping("/join")
    public String register(User user) {
        userService.save(user);
        return"redirect:/";
    }

    // 로그아웃
    @PostMapping("/logout")
    public String logout() {
        // 세션 만료
        return "account/login";
    }
}
