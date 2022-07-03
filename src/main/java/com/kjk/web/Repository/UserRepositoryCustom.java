package com.kjk.web.Repository;

import com.kjk.web.model.user.User;

import java.util.List;

public interface UserRepositoryCustom {
    // Security 로그인 데이터 비교용
    List<User> findByUsername(String username);

    Long usernameValidate(String username);

    Long getUserId(String username);
}
