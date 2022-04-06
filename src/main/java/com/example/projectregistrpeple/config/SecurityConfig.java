package com.example.projectregistrpeple.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // Класс в котором мы настраиваем конфигурацию нашего спринга

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
           .authorizeRequests()
            .antMatchers("/registration","/main").permitAll()
              .and()
              .formLogin().loginPage("/modelstart").permitAll()
               .and()
               .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll();

    }




}
