package com.ak.fx.desktop;

import javax.annotation.Nonnull;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FxApplication extends Application {
  private ConfigurableApplicationContext applicationContext;

  public static void main(@Nonnull String[] args) {
    Application.launch(FxApplication.class, args);
  }

  @Override
  public void init() {
    applicationContext = new SpringApplicationBuilder(FxApplication.class).run();
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.show();
    primaryStage.centerOnScreen();
  }

  @Override
  public void stop() {
    applicationContext.stop();
    Platform.exit();
  }
}
