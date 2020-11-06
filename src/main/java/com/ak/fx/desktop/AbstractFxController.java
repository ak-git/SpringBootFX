package com.ak.fx.desktop;

import java.util.logging.Logger;

import javax.annotation.Nonnull;

import com.ak.fx.core.Service;
import javafx.event.ActionEvent;

public abstract class AbstractFxController {
  private final Service service;

  protected AbstractFxController(@Nonnull Service service) {
    this.service = service;
  }

  public void action(ActionEvent actionEvent) {
    Logger.getLogger(getClass().getName()).info(actionEvent::toString);
    service.serve();
  }

  public void close(ActionEvent actionEvent) {
    Logger.getLogger(getClass().getName()).info(actionEvent::toString);
    service.close();
  }
}
