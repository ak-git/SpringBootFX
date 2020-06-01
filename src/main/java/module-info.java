module com.ak.fx.desktop {
  requires jsr305;
  requires javafx.fxml;
  requires javafx.controls;
  requires java.desktop;
  requires spring.boot;
  requires spring.boot.autoconfigure;

  opens com.ak.fx.desktop to spring.core;

  exports com.ak.fx.desktop;
}