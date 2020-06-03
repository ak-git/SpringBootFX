package com.ak.fx.desktop.aper;

import java.util.logging.Logger;

import javax.annotation.Nonnull;
import javax.inject.Named;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;

@Named
@Profile("aper")
public final class AperApplicationRunner implements ApplicationRunner {
  @Override
  public void run(@Nonnull ApplicationArguments args) {
    Logger.getLogger(getClass().getName()).info("AperApplicationRunner.run");
  }
}