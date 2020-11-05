package com.ak.fx.desktop.aper;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Named;

import com.ak.fx.core.AperService;
import com.ak.fx.desktop.AbstractFxController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.springframework.context.annotation.Profile;

@Named
@Profile("aper")
public final class AperFxController extends AbstractFxController {
  @FXML
  private Button buttonCenter;

  @Inject
  public AperFxController(@Nonnull AperService service) {
    super(service);
  }
}
