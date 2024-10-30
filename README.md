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

You can switch active profile to **aper** at a startup using
  ```
  -Dspring.profiles.active=aper
  ```

Output zip with single JAR appears after Gradle build task:
  ```
  build/distributions/SpringBootFX-boot
  ```

## Run using Gradle

```shell
./gradlew run -t
```

## [Semantic versioning](https://zoltanaltfatter.com/2020/04/10/semantic-versioning-with-jgitver/)

### Plugin [fr.brouillard.oss.gradle.jgitver](https://github.com/jgitver/gradle-jgitver-plugin)

```shell
./gradlew version
```

```shell
./gradlew version | grep Version | awk '{ print $2 }'
```

### Update version and add git tag

```shell
git tag 2024.11.1
```

## Update dependencies

### Plugin [com.github.ben-manes.versions](https://github.com/ben-manes/gradle-versions-plugin)

```shell
./gradlew dependencyUpdates
```

## Check dependencies

### Plugin [dependency-analysis-gradle-plugin](https://github.com/autonomousapps/dependency-analysis-gradle-plugin)

```shell
./gradlew buildHealth
```