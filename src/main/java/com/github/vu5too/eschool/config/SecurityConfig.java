package com.github.vu5too.eschool.config;


import org.apache.catalina.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}user").roles("USER")
                .and()
                .withUser("admin").password("{noop}admin").roles("USER", "ADMIN");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                //HTTP Basic authentication
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/students/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/students").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/students/**").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin();
    }
}
