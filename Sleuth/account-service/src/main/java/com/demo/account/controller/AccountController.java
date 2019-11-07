package com.demo.account.controller;

import java.util.List;

import javax.security.auth.login.AccountException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.account.domain.Account;
import com.demo.account.domain.Transaction;
import com.demo.account.service.AccountService;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {
  
  @Autowired
  private AccountService accountService;

  @PostMapping
  public Account createAccount(@RequestBody Account account) {
    return accountService.createAccount(account);
  }

  @GetMapping
  public List<Account> getAllAccounts() {
    return accountService.getAllAccounts();
  }

  @GetMapping("/{accountId}")
  public Account getAccount(@PathVariable("accountId") Long accountId) throws AccountException {
    return accountService.getAccount(accountId);
  }

  @PostMapping("/{accountId}/deposit")
  public Account deposit(@PathVariable("accountId") Long accountId, @RequestBody Transaction transaction) throws AccountException {
    return accountService.deposit(accountId, transaction);
  }

  @PostMapping("/{accountId}/withdraw")
  public Account withdraw(@PathVariable("accountId") Long accountId, @RequestBody Transaction transaction) throws AccountException {
    return accountService.withdraw(accountId, transaction);
  }

}
