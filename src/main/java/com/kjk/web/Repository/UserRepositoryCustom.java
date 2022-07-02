package com.kjk.web.Repository;

import com.kjk.web.model.user.User;

import java.util.List;

public interface UserRepositoryCustom {
    List<User> findByUsername(String username);
}
