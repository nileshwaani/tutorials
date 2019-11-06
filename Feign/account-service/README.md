# Account Service

**Account service** is a simple RESTful web service built using Spring Boot. You can perform basic account operations using this service. The service does not use any persistent storage to save the employees, it just stores the data in-memory.

## Running the service

Follow the below instructions to set up and start the account service on your local machine:

1. Clone the repository on your machine.

2. By default, the service uses the port 8080. You can change the port in **application.yml**.

3. Open the command prompt and change to the directory account-service.

4. Start the service using `gradlew bootRun`

## Endpoints Documentation
### GET /accounts

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
### GET /accounts/{accountId}

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
### POST /accounts

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
### POST /accounts/{accountId}/deposit

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
### POST /accounts/{accountId}/withdraw

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
