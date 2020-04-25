package com.devmango.spring.security.basic;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebSecurityConfig implements WebMvcConfigurer {

  @Configuration
  protected static class ApplicationSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests()
        // admin is accessible to role ADMIN
        .antMatchers("/admin").hasRole("ADMIN")
        // user is accessible to role USER and ADMIN
        .antMatchers("/user").hasAnyRole("USER", "ADMIN")
        // home is accessible to all users without authentication
        .antMatchers("/").permitAll()
        // Tells application to user Form based login
        .and().formLogin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.inMemoryAuthentication()
        .passwordEncoder(NoOpPasswordEncoder.getInstance())
        .withUser("user1").password("pass1").roles("ADMIN").and()
        .withUser("user2").password("pass2").roles("USER").and()
        .withUser("user3").password("pass3").roles("USER");
    }
  }
}
