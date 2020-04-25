package com.devmango.spring.security.oauth.google.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devmango.spring.security.oauth.google.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
  Optional<Employee> findByEmail(String email);
}
