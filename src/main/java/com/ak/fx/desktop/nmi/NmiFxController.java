package com.ak.fx.desktop.nmi;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Named;

import com.ak.fx.core.Service;
import com.ak.fx.desktop.AbstractFxController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

@Named
public final class NmiFxController extends AbstractFxController {
  @FXML
  private Button buttonCenter;

  @Inject
  public NmiFxController(@Nonnull Service service) {
    super(service);
  }
}
