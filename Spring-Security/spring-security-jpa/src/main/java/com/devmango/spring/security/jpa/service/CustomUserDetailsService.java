package com.devmango.spring.security.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.devmango.spring.security.jpa.domain.CustomUserDetails;
import com.devmango.spring.security.jpa.domain.Employee;
import com.devmango.spring.security.jpa.repository.EmployeeRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
  
  @Autowired
  private EmployeeRepository employeeRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<Employee> employeeOptional = employeeRepository.findByLogin(username);
    
    employeeOptional.orElseThrow(() -> new UsernameNotFoundException("Not found : " + username));
    
    return employeeOptional.map(CustomUserDetails::new).get();
  }

}
