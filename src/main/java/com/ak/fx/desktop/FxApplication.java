package com.ak.fx.desktop;

import java.io.IOException;

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

@SpringBootApplication
public class FxApplication extends Application {
  private static final String SCENE_XML = "scene.fxml";
  private ConfigurableApplicationContext applicationContext;

  public static void main(@Nonnull String[] args) {
    Application.launch(FxApplication.class, args);
  }

  @Override
  public void init() {
    applicationContext = new SpringApplicationBuilder(FxApplication.class).run();
  }

  @Override
  public void start(Stage primaryStage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(SCENE_XML));
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
