package com.ak.fx.desktop;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Named;

import com.ak.fx.core.Service;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.springframework.context.annotation.Profile;

@Named
@Profile("default")
public final class DefaultFxController extends AbstractFxController {
  @FXML
  private Label title;

  @Inject
  DefaultFxController(@Nonnull Service service) {
    super(service);
  }
}
