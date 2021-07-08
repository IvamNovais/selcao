package com.trabalho.pratico.back.config;

import com.trabalho.pratico.back.services.AuthService;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import lombok.RequiredArgsConstructor;
@EnableWebSecurity
@EnableAuthorizationServer
@EnableResourceServer
@RequiredArgsConstructor
public class segurancaConfig extends WebSecurityConfigurerAdapter{
    private final AuthService authService;
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable()
        .authorizeRequests()
        .antMatchers("/enfermeiro/**").hasRole("ADMIN")
        .anyRequest()
        .authenticated()
        .and().cors()
        .and()
        .formLogin()
        .and()
        .httpBasic();
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.userDetailsService(authService).passwordEncoder(passwordEncoder);
    }
}
