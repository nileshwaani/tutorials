In micro-services architecture, tracing logs is extremely challenging because requests span multiple services running across multiple servers. It would be tedious to trace the logs related to a particular request.

To achieve distributed tracing, we need to correlate the logs of a particular request.

One solution is to create a CORRELATION_ID at the beginning of call chain, set it in MDC (Mapped Diagnostic Context) of logging frameworks and pass this in the header to all downstream services.

Typically, this is done in WebRequestInterceptor, where we will first check if the correlation id exists in the header. If not, we will create new one and set that in MDC.

The logging frameworks include the information from MDC in all the log statements.

In this article, we will see how we can achieve this using Spring Cloud Sleuth.

This demo is just an extension of our standard [Bank-Account](https://github.com/nileshwaani/tutorials/tree/master/Feign) project where we have just added the starter dependency for Spring Cloud Sleuth.

## Spring Cloud Sleuth

Spring Cloud Sleuth does this work of correlating logs and much more.

Let’s see an example by adding tracing in our [banking application](https://github.com/nileshwaani/tutorials/tree/master/Feign).

The only step is to add _spring-cloud-starter-sleuth_ dependency in our services.

```gradle
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.springframework.cloud:spring-cloud-starter-openfeign'
    implementation 'org.springframework.cloud:spring-cloud-starter-sleuth'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
}
```

After restaring the services, whenever you send any request to these services, you will see few details in the logs.

```
2019-11-06 19:48:47.882  INFO [bank-service,eccbf264d5e2ff95,eccbf264d5e2ff95,false] 7496 --- [nio-8081-exec-2] com.demo.bank.service.BankService        : Getting all acccounts
2019-11-06 19:49:31.819  INFO [bank-service,511c4aa53ec16f7c,511c4aa53ec16f7c,false] 7496 --- [nio-8081-exec-3] com.demo.bank.service.BankService        : Creating account for John Williams
```

A brief explanation of the highlighted data is given below:

| Information      | Explanation|
| -----------------|:-------------:|
|bank-service      |The name of the application.|
|04243c345de0e039  |Trace ID. It is attached to the main request. It remains same for all downstream calls.|
|e01dd2854ee0b039  |Span ID. It is attached to a service call. If the main request involves calls to 4 services, then each service call will have its own Span ID.|
|false             |Whether the trace information is being exported to any tracing server like Zipkin.|