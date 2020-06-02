package com.ak.fx.desktop.nmi;

import java.util.logging.Logger;

import javax.inject.Named;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;

@Named
@Profile("nmi")
public final class NmiApplicationRunner implements ApplicationRunner {
  @Override
  public void run(ApplicationArguments args) {
    Logger.getLogger(getClass().getName()).info("NmiApplicationRunner.run");
  }
}