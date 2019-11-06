# Bank Service

**Bank service** is a simple RESTful web service built using Spring Boot.

Feign is a tool that you can use for microservices communication.

The bank service demonstrates the use of Feign client by communicating with [account-service](https://github.com/nileshwaani/tutorials/tree/master/Feign/account-service).

## Running the service

Follow the below instructions to set up and start the bank service on your local machine:

1. Setup the account service by following the steps mentioned [here](https://github.com/nileshwaani/tutorials/blob/master/Feign/account-service/README.md).

2. Make sure that account service is up and running.

3. Clone the bank service repository on your machine.

4. Make sure that you specify the right port in **bank-service/src/main/resources/application.yml**.

5. Open the command prompt and change to the directory bank-service.

6. Start the service using `gradlew bootRun`

## Endpoints Documentation
### GET /bank/accounts

Get all the accounts.

**Response**

List of all accounts with their details.

```
[
  {
    "accountId":1
    "accountHolderName":"John Williams",
    "balance": 5000
  },
  {
    "accountId":2
    "accountHolderName":"Peter Jackson",
    "balance": 7000
  },
]
```
---
### GET /bank/accounts/{accountId}

Get the specific account.

**Request**

_Parameter_

accountId - The ID of the account to fetch.

**Response**

Details about the requested employee.

```
{
  "accountId":1
  "accountHolderName":"John Williams",
  "balance": 5000
}
```
---
### POST /bank/accounts

Create a new account.

**Request**

_Body_

Details of account to be created.
```
{
  "accountHolderName":"John Williams",
  "balance": 5000
},
```

**Response**

Details of newly created account with auto-generated Id.

```
{
  "accountId":1
  "accountHolderName":"John Williams",
  "balance": 5000
}
```
---
### POST /bank/accounts/{accountId}/deposit

Deposits the given amount in the accountId.

**Request**

_Parameters_

accountId - The ID of the account to be updated.

_Body_

Amount to be deposited.
```
{
  "amount": 1000
}
```

**Response**

Details of the updated account.

```
{
  "accountId":1
  "accountHolderName":"John Williams",
  "balance": 6000
}
```
---
### POST /bank/accounts/{accountId}/withdraw

Withdraws the given amount from the accountId.

**Request**

_Parameters_

accountId - The ID of the account to be updated.

_Body_

Amount to be withdrew.
```
{
  "amount": 1000
}
```

**Response**

Details of the updated account.

```
{
  "accountId":1
  "accountHolderName":"John Williams",
  "balance": 4000
}
```
---
### POST /bank/accounts/transfer

Transfers the amount from one account to another account.

**Request**

_Body_

Transaction details containing fromAccount, toAccount and the amount.
```
{
  "fromAccount": {
    "accountId": 5000
  },
  "toAccount": {
    "accountId": 5001
  },
  "amount": 500
}
```

**Response**

Result of the transaction.

```
{
  "fromAccount": {
    "accountId": 5000,
    "accountHolderName":"John Williams",
    "balance": 4000
  },
  "toAccount": {
    "accountId": 5001,
    "accountHolderName":"Peter Jackson",
    "balance": 3000
  },
  "amount": 500
}
```
