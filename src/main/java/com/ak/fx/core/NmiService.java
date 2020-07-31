package com.ak.fx.core;

import java.util.logging.Logger;

import javax.inject.Named;

import org.springframework.context.annotation.Profile;

@Named
@Profile("nmi")
public final class NmiService implements Service {
  @Override
  public void serve() {
    Logger.getLogger(getClass().getName()).info("NmiService.serve");
  }
}
