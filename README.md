# SpringBootFX

Simple example for Spring Boot and JavaFX application

Contains profiles: **default**, **nmi** and **aper**

Active profile **nmi** sets in *application.properties*

```properties
spring.profiles.active=default
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

### Plugin [axion-release-plugin](https://github.com/allegro/axion-release-plugin)

```shell
gradle currentVersion -q -Prelease.quiet
```

### Update version

```shell
gradle release
```

### Add git tag

```shell
git tag 2026.04
```

## Update dependencies

### Plugin [io.github.ben-manes.versions](https://github.com/ben-manes/gradle-versions-plugin)

```shell
./gradlew dependencyUpdates
```

## Check dependencies

### Plugin [dependency-analysis-gradle-plugin](https://github.com/autonomousapps/dependency-analysis-gradle-plugin)

```shell
./gradlew buildHealth
```