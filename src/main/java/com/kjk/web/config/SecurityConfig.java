package com.kjk.web.config;

import com.kjk.web.Handler.AuthenticationFailureHandler;
import com.kjk.web.Handler.AuthenticationSuccessHandler;
import com.kjk.web.security.CustomAuthenticationProvider;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    CustomAuthenticationProvider customAuthenticationProvider;

    public SecurityConfig(CustomAuthenticationProvider customAuthenticationProvider) {
        this.customAuthenticationProvider = customAuthenticationProvider;
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/css/**", "/js/**"); // resource 에 대해 Spring Security FilterChain 제외
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/menu/product", "/menu/product/all", "/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/menu/product")
                .successHandler(new AuthenticationSuccessHandler())
                .failureHandler(new AuthenticationFailureHandler())
                .permitAll();

//        http.mvcMatcher("/**")
//                .formLogin()
//                .usernameParameter("myUsername")
//                .passwordParameter("myPassword")
//                .successHandler(new AuthenticationSuccessHandler())
//                .failureHandler(new AuthenticationFailureHandler())
//            .and()
//                .authorizeRequests()
//                .mvcMatchers("/**").hasRole("USER");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(customAuthenticationProvider);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
