# Paynow Spring Boot Sample Project QuickStart

Want to create a Spring Boot project that uses the latest release of the official [Paynow Java SDK](https://github.com/paynow/Paynow-Java-SDK)? Then this quickstart project is just for you! It is a nice starting point for creating a Paynow Spring Boot project.

## What is in this sample project?

This quickstart has the following to help you get started quickly:
* autoconfiguration of the Paynow integration so you just have to specify details in `application.properties`, and your test properties in `application-test.properties`
* a ready made controller to handle requests from Paynow with payment updates
* example code with detailed comments

## Prerequisites

In order to make use of this project, the following prerequisites must be met for it to work.

1. [Setup your developer account](https://github.com/paynow/Paynow-Java-SDK/wiki/Setting-up-your-developer-account) to obtain a integration ID and key
2. In your project, make use of Java JDK 7 or higher

### Setting properties

Set the properties as follows in application.properties

```properties
paynow.integration.id=1234
paynow.integration.key=01234-56789
paynow.resultUrl=http://yourdomain.com/paymentupdatereceiver
paynow.returnUrl=http://yourdomain.com/return?gateway=paynow&reference=123
```

If you have a test integration as well, set the test integration properties in application-test.properties

## Examples
See `com.yourdomain.examples` package for example code on interfacing with the Paynow API using the Java SDK