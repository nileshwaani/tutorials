package com.demo.bank.service;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.AccountException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.bank.client.AccountClient;
import com.demo.bank.domain.Account;
import com.demo.bank.domain.Transaction;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class BankService {

  private static final Logger LOGGER = LoggerFactory.getLogger(BankService.class);

  @Autowired
  private AccountClient accountClient;

  public Account createAccount(Account account) {
    LOGGER.info("Creating account for {}", account.getAccountHolderName());
    return accountClient.createAccount(account);
  }

  @HystrixCommand(fallbackMethod = "getDefaultAccounts")
  public List<Account> getAllAccounts() {
    LOGGER.info("Getting all acccounts");
    return accountClient.getAllAccounts();
  }
  
  public List<Account> getDefaultAccounts() {
    LOGGER.info("Getting default acccounts");
    return new ArrayList<>();
  }
  
  public Account getAccount(Long accountId) throws AccountException {
    LOGGER.info("Getting account for {}", accountId);
    return accountClient.getAccount(accountId);
  }

  public Account deposit(Long accountId, Transaction transaction) throws AccountException {
    LOGGER.info("Depositing {} into account {}", transaction.getAmount(), accountId);
    return accountClient.deposit(accountId, transaction);
  }

  public Account withdraw(Long accountId, Transaction transaction) throws AccountException {
    LOGGER.info("Withdrawing {} from account {}", transaction.getAmount(), accountId);
    return accountClient.withdraw(accountId, transaction);
  }

  public Transaction transfer(Transaction transaction) throws AccountException {
    LOGGER.info("Transferring {} from {} to account {}", transaction.getAmount(), transaction.getFromAccount().getAccountId(), transaction.getToAccount().getAccountId());
    Account fromAccount = accountClient.withdraw(transaction.getFromAccount().getAccountId(), transaction);
    Account toAccount = accountClient.deposit(transaction.getToAccount().getAccountId(), transaction);
    transaction.setFromAccount(fromAccount);
    transaction.setToAccount(toAccount);
    return transaction;
  }

}
