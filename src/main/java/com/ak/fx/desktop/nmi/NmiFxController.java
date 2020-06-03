package com.ak.fx.desktop.nmi;

import java.util.logging.Logger;

import javax.inject.Named;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.springframework.context.annotation.Profile;

@Named
@Profile("nmi")
public final class NmiFxController {
  @FXML
  private Button buttonCenter;

  public void action(ActionEvent actionEvent) {
    Logger.getLogger(getClass().getName()).info(actionEvent.toString());
  }
}
