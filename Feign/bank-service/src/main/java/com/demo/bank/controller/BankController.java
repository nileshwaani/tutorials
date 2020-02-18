package com.demo.bank.controller;

import java.util.List;

import javax.security.auth.login.AccountException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bank.domain.Account;
import com.demo.bank.domain.Transaction;
import com.demo.bank.service.BankService;

@RestController
@RequestMapping(value = "/bank")
public class BankController {

  @Autowired
  private BankService bankService;
  
  @PostMapping("/accounts")
  public Account createAccount(@RequestBody Account account) {
    return bankService.createAccount(account);
  }

  @GetMapping("/accounts")
  public List<Account> getAllAccounts() {
    return bankService.getAllAccounts();
  }

  @GetMapping("/accounts/{accountId:[0-9]\\d*}")
  public Account getAccount(@PathVariable("accountId") Long accountId) throws AccountException {
    return bankService.getAccount(accountId);
  }

  @PostMapping("/accounts/{accountId:[0-9]\\d*}/deposit")
  public Account deposit(@PathVariable("accountId") Long accountId, @RequestBody Transaction transaction) throws AccountException {
    return bankService.deposit(accountId, transaction);
  }

  @PostMapping("/accounts/{accountId:[0-9]\\d*}/withdraw")
  public Account withdraw(@PathVariable("accountId") Long accountId, @RequestBody Transaction transaction) throws AccountException {
    return bankService.withdraw(accountId, transaction);
  }
  
  @PostMapping("/accounts/transfer")
  public Transaction transfer(@RequestBody Transaction transaction) throws AccountException {
    return bankService.transfer(transaction);
  }
}
