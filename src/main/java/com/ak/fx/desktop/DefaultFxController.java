package com.ak.fx.desktop;

import java.util.logging.Logger;

import javax.annotation.Nonnull;

import com.ak.fx.core.Service;
import jakarta.inject.Inject;
import jakarta.inject.Provider;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("default")
public final class DefaultFxController extends AbstractFxController {
  @FXML
  private Label title;

  @Inject
  DefaultFxController(@Nonnull Provider<Service> serviceProvider) {
    super(serviceProvider.get());
    Logger.getLogger(getClass().getName()).info(() -> serviceProvider.get().toString());
    Logger.getLogger(getClass().getName()).info(() -> serviceProvider.get().toString());
  }
}
