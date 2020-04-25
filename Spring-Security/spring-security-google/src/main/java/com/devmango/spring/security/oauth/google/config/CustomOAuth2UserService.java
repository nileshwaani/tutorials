package com.devmango.spring.security.oauth.google.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import com.devmango.spring.security.oauth.google.domain.Employee;
import com.devmango.spring.security.oauth.google.repository.EmployeeRepository;

@Service
public class CustomOAuth2UserService extends OidcUserService {
  
  @Autowired
  private EmployeeRepository employeeRepository;
  private Optional<Employee> employeeOptional;
  
  @Override
  public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
    OidcUser oidcUser = super.loadUser(userRequest);
    System.out.println("Registration :" + userRequest.getClientRegistration().getRegistrationId());
    System.out.println("Token :" + userRequest.getAccessToken().getTokenValue());
    System.out.println("Email :" + oidcUser.getEmail());
    System.out.println("Full Name :" + oidcUser.getFullName());
    System.out.println("Attributes :" + oidcUser.getAttributes());

    employeeOptional = employeeRepository.findByEmail(oidcUser.getEmail());
    
    employeeOptional.orElseThrow(() -> new UsernameNotFoundException("Not found : " + oidcUser.getEmail()));
    
    Employee employee = employeeOptional.get();
    
    System.out.println("Employee :" + employee);

    return oidcUser;
  }
}
