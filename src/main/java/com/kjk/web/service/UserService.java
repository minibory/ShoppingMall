package com.kjk.web.service;

import com.kjk.web.model.user.User;

import java.util.List;

public interface UserService {

    void save(User user);

    Boolean usernameValidate(String username);

    List<User> findByUsername(String username);
}
