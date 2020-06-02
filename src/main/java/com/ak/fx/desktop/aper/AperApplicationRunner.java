package com.ak.fx.desktop.aper;

import java.util.logging.Logger;

import javax.inject.Named;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

@Named("Aper")
public final class AperApplicationRunner implements ApplicationRunner {
  @Override
  public void run(ApplicationArguments args) {
    Logger.getLogger(getClass().getName()).info("AperApplicationRunner.run");
  }
}