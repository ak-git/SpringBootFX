package com.ak.fx.desktop;

import java.io.IOException;
import java.util.Arrays;
import java.util.ResourceBundle;

import javax.annotation.Nonnull;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "com.ak.fx")
public class FxApplication extends Application {
  private static final String KEY_PROPERTIES = "keys";
  private ConfigurableApplicationContext applicationContext;

  public static void main(@Nonnull String[] args) {
    Application.launch(FxApplication.class, args);
  }

  @Override
  public void init() {
    applicationContext = new SpringApplicationBuilder(FxApplication.class).headless(false).run();
  }

  @Override
  public void start(@Nonnull Stage primaryStage) throws IOException {
    String profile = Arrays.stream(applicationContext.getEnvironment().getActiveProfiles()).findFirst().orElse("default");
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(String.join(".", profile, "fxml")),
        ResourceBundle.getBundle(String.join(".", getClass().getPackageName(), KEY_PROPERTIES)));
    fxmlLoader.setControllerFactory(applicationContext::getBean);

    Parent parent = fxmlLoader.load();
    primaryStage.setScene(new Scene(parent, 800, 600));
    primaryStage.show();
    primaryStage.centerOnScreen();
  }

  @Override
  public void stop() {
    applicationContext.stop();
    Platform.exit();
  }
}
