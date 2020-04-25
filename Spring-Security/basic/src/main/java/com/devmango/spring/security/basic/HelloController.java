package com.devmango.spring.security.basic;

import java.security.Principal;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping("/hello")
  public String hello(@RequestParam(name = "name") String name) {
    return "Hello " + name;
  }

  @GetMapping("/check")
  public String check(Principal principal) {
    return "<p>The currently logged in user is <b>" + principal.getName() + "</b></p>";
  }

  @GetMapping("/check2")
  public String check() {
    String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
    return "<p>The currently logged in user is <b>" + currentUser + "</b></p>";
  }

  @GetMapping("/")
  public String home() {
    return "<h1>Welcome</h1>";
  }

  @GetMapping("/user")
  public String user() {
    return "<h1>Welcome User</h1>";
  }

  @GetMapping("/admin")
  public String admin() {
    return "<h1>Welcome Admin</h1>";
  }
}
