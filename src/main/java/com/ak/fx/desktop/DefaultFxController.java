package com.ak.fx.desktop;

import javax.inject.Named;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.springframework.context.annotation.Profile;

@Named
@Profile("default")
public final class DefaultFxController {
  @FXML
  public Label title;
}
