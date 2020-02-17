package com.demo.account.controller;

import java.util.List;

import javax.security.auth.login.AccountException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.account.domain.Account;
import com.demo.account.domain.Transaction;
import com.demo.account.service.AccountService;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {
  
  private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);
  
  @Autowired
  private AccountService accountService;

  @PostMapping
  public Account createAccount(@RequestHeader(value = "x-client") String client,  @RequestBody Account account) {
    LOGGER.info("Header x-client = " + client);
    return accountService.createAccount(account);
  }

  @GetMapping
  public List<Account> getAllAccounts(@RequestHeader(value = "x-client") String client) {
    LOGGER.info("Header x-client = " + client);
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
