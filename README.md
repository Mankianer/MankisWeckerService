# Mankis Wecker Service

Simple REST-Service for doing some Action at given Time.   

## Description

A Microservice for my SmartHome.


### Prerequisites

What things you need to run the software and how to install them

```
Java >= 14
```

### Installing

A step by step series of examples that tell you how to get a development env running

#### Run
1. Run Gradle with the Task bootRun.

```
gradlew bootRun
```
#### Build
1. Run Gradle with the Task bootJar.

```
gradlew bootJar
```

Runnable Jar: build/libs/mankisweckerservice-VERSION.jar

## Deployment

Add additional notes about how to deploy this on a live system.

1. application.properties
```
spring.datasource.url=jdbc:h2:~/databaseFile
spring.datasource.username=sa
spring.datasource.password=1234
spring.h2.console.enabled=false
```

2. Run with Java
```
java -jar PATH_TO_JAR.jar
```

## Built With

* [Official Gradle documentation](https://docs.gradle.org) - Dependency Management
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/gradle-plugin/reference/html/)  - The web framework used
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications) - The web framework used
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/reference/htmlsingle/#boot-features-jpa-and-spring-data) - The web framework used

## Versioning

Dev-Version

## Docs

Swagger: /swagger-ui.html

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc

