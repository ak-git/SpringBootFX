package com.ak.fx.desktop;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.annotation.Nonnull;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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
  public final void start(@Nonnull Stage mainStage) throws IOException {
    ResourceBundle resourceBundle = ResourceBundle.getBundle(String.join(".", getClass().getPackageName(), KEY_PROPERTIES));
    List<FXMLLoader> fxmlLoaders = getFXMLLoader(resourceBundle);
    List<Stage> stages = Stream
        .concat(
            Stream.of(mainStage),
            IntStream.range(1, fxmlLoaders.size()).mapToObj(i -> new Stage(StageStyle.DECORATED))
        )
        .collect(Collectors.toUnmodifiableList());

    for (int i = 0; i < stages.size(); i++) {
      Stage stage = stages.get(i);
      stage.setScene(fxmlLoaders.get(i).load());
      stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
      stage.show();
      stage.centerOnScreen();
    }
  }

  @Override
  public void stop() {
    applicationContext.close();
    Platform.exit();
  }

  private List<FXMLLoader> getFXMLLoader(@Nonnull ResourceBundle resourceBundle) {
    String[] profiles = applicationContext.getEnvironment().getActiveProfiles();
    if (profiles.length == 0) {
      profiles = applicationContext.getEnvironment().getDefaultProfiles();
    }
    FXMLLoader defaultFxmlLoader = new FXMLLoader(getClass().getResource(String.join(".", "default", "fxml")),
        resourceBundle);
    List<FXMLLoader> fxmlLoaders = Arrays.stream(profiles)
        .map(profile -> getClass().getResource(String.join(".", profile, "fxml")))
        .map(fxml -> {
          if (fxml == null) {
            return defaultFxmlLoader;
          }
          else {
            return new FXMLLoader(fxml, resourceBundle);
          }
        })
        .collect(Collectors.toUnmodifiableList());
    fxmlLoaders.forEach(fxmlLoader -> fxmlLoader.setControllerFactory(applicationContext::getBean));
    return fxmlLoaders;
  }
}
