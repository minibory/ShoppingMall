package com.kjk.web.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DashboardWebController {

    @GetMapping
    public String getDashboard() {
        // 로그인 상태 시 상품목록화면으로
        if(false) {
            return "redirect:/itemList";
        }
        return "login";
    }
}
