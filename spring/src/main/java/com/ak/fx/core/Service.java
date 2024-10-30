package com.ak.fx.core;

public interface Service extends AutoCloseable {
  void serve();

  @Override
  default void close() {
  }
}
