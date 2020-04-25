package com.devmango.spring.security.jdbc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

  /**
   * No authentication required. 
   */
  @GetMapping("/")
  public String home() {
    return "Welcome";
  }

  /**
   * Accessible to user and admin 
   */
  @GetMapping("/user")
  public String user() {
    return "Welcome User";
  }

  /**
   * Accessible to admin 
   */
  @GetMapping("/admin")
  public String admin() {
    return "Welcome Admin";
  }
}
