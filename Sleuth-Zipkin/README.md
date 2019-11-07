This tutorial demonstrates how we can export the tracing logs to Zipkin server.

This is an extension of existing tutorial [Sleuth](https://github.com/nileshwaani/tutorials/tree/master/Sleuth).

## Starting Zipkin Server

The simplest way to start Zipkin server is by using Docker image _openzipkin/zipkin_.

Open the command prompt. Change to the directory Sleuth-Zipkin and run the command:

```docker-compose up```

## Instrumenting Application

Add the Zipkin starter dependency into the services.

```gradle
implementation 'org.springframework.cloud:spring-cloud-starter-zipkin'
```

Add below properties in application.yml of the services:

```properties
spring:
  zipkin:
    base-url: http://localhost:9411/
  sleuth:
    sampler:
      probability: 1
```

Start the services and start calling the APIs.

You will find that the value of exportable is true in the logs.

```
2019-11-07 19:32:26.146  INFO [bank-service,f80fc28299217415,f80fc28299217415,true] 2084 --- [nio-8081-exec-3] com.demo.bank.service.BankService        : Getting all acccounts
```

## Visualizing Traces in Zipkin UI

Open the URL http://localhost:9411 in browser. Click on Find Traces. You will see the list of traces for the calls you have made.

Click on any trace, you can see call chain and latency details.