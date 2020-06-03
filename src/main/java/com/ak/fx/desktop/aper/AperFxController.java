package com.ak.fx.desktop.aper;

import java.util.logging.Logger;

import javax.inject.Named;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.springframework.context.annotation.Profile;

@Named
@Profile("aper")
public final class AperFxController {
  @FXML
  private Button buttonCenter;

  public void action(ActionEvent actionEvent) {
    Logger.getLogger(getClass().getName()).info(actionEvent.toString());
  }
}
