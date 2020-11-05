package com.ak.fx.core;

import java.util.logging.Logger;

import javax.inject.Named;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

@Named
@Profile("nmi")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public final class NmiService implements Service {
  @Override
  public void serve() {
    Logger.getLogger(getClass().getName()).info("NmiService.serve");
  }
}
