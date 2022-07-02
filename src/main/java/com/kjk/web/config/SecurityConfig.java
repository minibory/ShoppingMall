package com.kjk.web.config;

import com.kjk.web.Handler.AuthenticationSuccessHandler;
import com.kjk.web.security.CustomAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/css/**", "/js/**"); // resource 에 대해 Spring Security FilterChain 제외
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                // nginx 띄우면 context path 처리 ("/" -> "/product")
                .antMatchers("/").permitAll()
                .antMatchers("/sale").permitAll()
//                .antMatchers("/product").permitAll()
//                .antMatchers("/product/sale").permitAll()
                .antMatchers("/join").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/login-form").permitAll()
                .antMatchers("/join-form").permitAll()
                .antMatchers("/product-management/**").permitAll()
                .antMatchers("/user-management/**").permitAll()
                .anyRequest().authenticated()

                .and()
                .formLogin()
                .loginPage("/login")
//                .defaultSuccessUrl("/")     // SuccessHandler 내부에서 "/"로 redirect
                .successHandler(authenticationSuccessHandler())
                .failureForwardUrl("/login-fail")
                .permitAll()

                .and()
                .logout()
                .logoutUrl("/logout")
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/")
                .permitAll();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(customAuthenticationProvider());
    }

    @Bean
    public CustomAuthenticationProvider customAuthenticationProvider() {
        return new CustomAuthenticationProvider(userDetailsService, passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new AuthenticationSuccessHandler();
    }
}
