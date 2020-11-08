# SpringBootFX
Simple example for Spring Boot and JavaFX application

Contains profiles: **default**, **nmi** and **aper**

Active profile **nmi** sets in *application.yml*
```
spring:
  main:
    web-application-type: none
    banner-mode: off
  profiles:
    active: nmi
logging:
  level:
    org:
      springframework: info
  ```
  
  You can switch active profile to **aper** at startup using 
  ```
  -Dspring.profiles.active=aper
  ```
  
  Output zip with single JAR appers after Gradle build task:
  ```
  build/distributions/SpringBootFX-boot
  ```
[Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-documentation)

[Spring guides](https://spring-projects.ru/guides/lessons/lesson-2/)
