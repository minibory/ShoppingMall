package com.kjk.web.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginWebController {

    // 로그인 페이지
    @GetMapping("/login")
    public String login() {
        // 로그인 여부 체크 후 로그인 상태면 productList
        if(false) {
            return "redirect:/menu/product";
        }
        return "login";
    }

    // 회원가입 페이지
    @GetMapping("/join")
    public String join() {
        return "join";
    }

    // 로그아웃
    @PostMapping("/logout")
    public String logout() {
        // 세션 만료
        return "/login";
    }
}
