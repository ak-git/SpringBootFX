package com.ak.fx.core;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Nonnull;

public final class AperService implements Service {
  @Nonnull
  private final String msg;

  public AperService(@Nonnull String msg) {
    this.msg = msg;
  }

  @Override
  public void serve() {
    Logger.getLogger(getClass().getName()).log(Level.INFO, () -> "AperService.serve %s".formatted(msg));
  }
}
