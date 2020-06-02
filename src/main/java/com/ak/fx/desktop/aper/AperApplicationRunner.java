package com.ak.fx.desktop.aper;

import javax.inject.Named;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

@Named("Aper")
public final class AperApplicationRunner implements ApplicationRunner {
  @Override
  public void run(ApplicationArguments args) {
    System.out.println("AperApplicationRunner.run");
  }
}