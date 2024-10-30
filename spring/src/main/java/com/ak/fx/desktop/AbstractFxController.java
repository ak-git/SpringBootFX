package com.ak.fx.desktop;

import com.ak.fx.core.Service;
import javafx.event.ActionEvent;

import java.util.logging.Logger;

public abstract class AbstractFxController {
  private final Service service;

  protected AbstractFxController(Service service) {
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
