package com.ak.fx.core;

import javax.annotation.Nonnull;

public final class AperService extends AbstractService {
  @Nonnull
  private final String msg;

  public AperService(@Nonnull String msg) {
    this.msg = msg;
  }
}
