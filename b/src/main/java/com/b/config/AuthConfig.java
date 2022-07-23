package com.b.config;

import com.b.filter.WebFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author zhangfx
 * extends WebSecurityConfigurerAdapter
 * @Override
 * protected void configure(HttpSecurity http) throws Exception {
 * http.csrf().disable()
 * .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
 * .and()
 * .authorizeRequests()
 * .antMatchers("/user/login").anonymous()
 * .anyRequest().authenticated();
 * @date 2022/7/22
 */
@Configuration
@EnableWebSecurity
public class AuthConfig {
    @Autowired
    AuthenticationConfiguration authenticationConfiguration;

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/user/login").anonymous()
                .anyRequest().authenticated()
                .and()
                // 将自定义过滤器添加到security的过滤器链中
                .addFilterBefore(new WebFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

}
