package com.devmango.spring.security.oauth.google.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoogleController {

  @GetMapping("/")
  public String home() {
    return "Welcome";
  }
  
}
