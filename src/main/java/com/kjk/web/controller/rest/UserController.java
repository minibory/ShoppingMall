package com.kjk.web.controller.rest;

import com.kjk.web.model.generic.ResultEntity;
import com.kjk.web.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-management/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/validation")
    public ResultEntity usernameValidate(String username) {
        if(userService.usernameValidate(username)) {
            return new ResultEntity<>("1");
        }
        return new ResultEntity<>("0");
    }
}
