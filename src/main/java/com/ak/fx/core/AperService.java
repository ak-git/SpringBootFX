package com.ak.fx.core;

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
    Logger.getLogger(getClass().getName()).info("AperService.serve " + msg);
  }
}
