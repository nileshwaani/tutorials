package com.demo.bank.client;

import java.util.List;

import javax.security.auth.login.AccountException;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.demo.bank.domain.Account;
import com.demo.bank.domain.Transaction;

@FeignClient(name = "ACCOUNT-SERVICE", url = "http://localhost:8080/accounts")
public interface AccountClient {

  @PostMapping
  public Account createAccount(@RequestBody Account account);

  @GetMapping
  public List<Account> getAllAccounts();

  @GetMapping("/{accountId}")
  public Account getAccount(@PathVariable("accountId") Long accountId) throws AccountException;

  @PostMapping("/{accountId}/deposit")
  public Account deposit(@PathVariable("accountId") Long accountId, @RequestBody Transaction transaction) throws AccountException;

  @PostMapping("/{accountId}/withdraw")
  public Account withdraw(@PathVariable("accountId") Long accountId, @RequestBody Transaction transaction) throws AccountException;
}
