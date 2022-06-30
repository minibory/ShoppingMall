package com.kjk.web.config;

import com.kjk.web.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserDetail implements UserDetails {
    private static final long serialVersionUID = -1696163413845167163L;
    private User user;

    public CustomUserDetail(User user) {
        this.user = user;
    }
    /*
     * 권한목록
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getAuth()));
        return authorities;
    }

    /*
     * 비밀번호
     */
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    /*
     * PK값
     */
    @Override
    public String getUsername() {
        return user.getLoginId();
    }

    /*
     * 계정 만료 여부
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /*
     * 계정 잠김 여부
     */
    @Override
    public boolean isAccountNonLocked() {
        return !user.isActive();
    }

    /*
     * 비밀번호 만료 여부
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /*
     * 사용자 활성화 여부
     */
    @Override
    public boolean isEnabled() {
        return user.isActive();
    }
}
