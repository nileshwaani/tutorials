package com.demo.bank.client;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.login.AccountException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.demo.bank.domain.Account;
import com.demo.bank.domain.Transaction;

@Component
public class AccountRestTemplate {

  private RestTemplate restTemplate = new RestTemplate();

  private final String URI = "http://localhost:8080/accounts";

  public Account createAccount(Account account) {
    return restTemplate.postForObject(URI, account, Account.class);
  }

  public List<Account> getAllAccounts() {
    ResponseEntity<Account[]> accountEntity = restTemplate.getForEntity(URI, Account[].class);
    return Arrays.asList(accountEntity.getBody());
  }

  public Account getAccount(Long accountId) {
    String uri = URI + "/{accountId}";

    Map<String, String> params = new HashMap<String, String>();
    params.put("accountId", String.valueOf(accountId));

    return restTemplate.getForEntity(uri, Account.class, params).getBody();
  }

  public Account deposit(Long accountId, Transaction transaction) throws AccountException {
    String uri = URI + "/{accountId}/deposit";

    Map<String, String> params = new HashMap<String, String>();
    params.put("accountId", String.valueOf(accountId));

    return restTemplate.postForObject(uri, transaction, Account.class, params);
  }

  public Account withdraw(@PathVariable("accountId") Long accountId, @RequestBody Transaction transaction) throws AccountException {
    String uri = URI + "/{accountId}/withdraw";

    Map<String, String> params = new HashMap<String, String>();
    params.put("accountId", String.valueOf(accountId));

    return restTemplate.postForObject(uri, transaction, Account.class, params);
  }

  public Transaction transfer(@RequestBody Transaction transaction) throws AccountException {
    String uri = URI + "/transfer";

    return restTemplate.postForObject(uri, transaction, Transaction.class);
  }
}
