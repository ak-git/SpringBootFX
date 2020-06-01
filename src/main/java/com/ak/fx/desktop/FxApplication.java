package com.ak.fx.desktop;

import javax.annotation.Nonnull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FxApplication {
  public static void main(@Nonnull String[] args) {
    SpringApplication.run(FxApplication.class, args);
  }
}
