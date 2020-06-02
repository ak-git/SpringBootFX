package com.ak.fx.desktop.nmi;

import javax.inject.Named;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

@Named("NMI")
public final class NmiApplicationRunner implements ApplicationRunner {
  @Override
  public void run(ApplicationArguments args) {
    System.out.println("NmiApplicationRunner.run");
  }
}