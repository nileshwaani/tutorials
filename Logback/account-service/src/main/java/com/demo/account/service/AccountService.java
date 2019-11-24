package com.demo.account.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.security.auth.login.AccountException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.demo.account.domain.Account;
import com.demo.account.domain.Transaction;

@Service
public class AccountService {
  
  private static final Logger LOGGER = LoggerFactory.getLogger(AccountService.class);
  
  private Map<Long, Account> accountMap = new HashMap<>();
  private long accountIdGenerator = 5000L;

  public Account createAccount(Account account) {
    LOGGER.info("Creating account for {}", account.getAccountHolderName());
    account.setAccountId(accountIdGenerator++);
    accountMap.put(account.getAccountId(), account);
    return account;
  }

  public List<Account> getAllAccounts() {
    LOGGER.info("Getting all acccounts");
    return accountMap.values().stream().collect(Collectors.toList());
  }

  public Account getAccount(Long accountId) throws AccountException {
    LOGGER.info("Getting account for {}", accountId);
    if(accountMap.containsKey(accountId)) {
      return accountMap.get(accountId);      
    }
    LOGGER.error("Account {} does not exist.", accountId);
    throw new AccountException("Account does not exist.");
  }

  public Account deposit(Long accountId, Transaction transaction) throws AccountException {
    LOGGER.info("Depositing {} into account {}", transaction.getAmount(), accountId);
    if(accountMap.containsKey(accountId)) {
      Account account = accountMap.get(accountId);
      account.setBalance(account.getBalance().add(transaction.getAmount()));
      return account;
    }
    LOGGER.error("Account {} does not exist.", accountId);
    throw new AccountException("Account does not exist.");
  }

  public Account withdraw(Long accountId, Transaction transaction) throws AccountException {
    LOGGER.info("Withdrawing {} from account {}", transaction.getAmount(), accountId);
    if(accountMap.containsKey(accountId)) {
      Account account = accountMap.get(accountId);
      
      if(account.getBalance().compareTo(transaction.getAmount()) < 0) {
        LOGGER.error("Insufficient balance in account {}", accountId);
        throw new AccountException("Insufficient balance.");
      }
      
      account.setBalance(account.getBalance().subtract(transaction.getAmount()));
      return account;
    }
    LOGGER.error("Account {} does not exist.", accountId);
    throw new AccountException("Account does not exists.");
  }

}
