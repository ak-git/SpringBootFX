package com.ak.fx.desktop;

import java.util.logging.Logger;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

import com.ak.fx.core.Service;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

@Named
public final class DefaultFxController extends AbstractFxController {
  @FXML
  private Label title;

  @Inject
  DefaultFxController(@Nonnull Provider<Service> serviceProvider) {
    super(serviceProvider.get());
    Logger.getLogger(getClass().getName()).info(serviceProvider.get().toString());
    Logger.getLogger(getClass().getName()).info(serviceProvider.get().toString());
  }
}
