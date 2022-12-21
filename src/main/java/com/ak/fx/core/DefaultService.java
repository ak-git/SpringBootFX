package com.ak.fx.core;

import java.util.logging.Logger;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Profile("default")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Primary
public final class DefaultService implements Service {
  @Override
  public void serve() {
    Logger.getLogger(getClass().getName()).info("DefaultService.serve");
  }
}
