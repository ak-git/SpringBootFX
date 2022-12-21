package com.ak.fx.desktop.nmi;

import javax.annotation.Nonnull;

import com.ak.fx.core.NmiService;
import com.ak.fx.desktop.AbstractFxController;
import jakarta.inject.Inject;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("nmi")
public final class NmiFxController extends AbstractFxController {
  @FXML
  private Button buttonCenter;

  @Inject
  public NmiFxController(@Nonnull NmiService serviceProvider) {
    super(serviceProvider);
  }
}
