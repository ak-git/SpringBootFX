module com.ak.fx.desktop {
  requires javax.inject;
  requires java.logging;
  requires jsr305;
  requires javafx.fxml;
  requires javafx.controls;
  requires java.desktop;
  requires spring.boot;
  requires spring.boot.autoconfigure;
  requires spring.context;

  opens com.ak.fx.desktop to spring.core;
  exports com.ak.fx.desktop.aper to spring.beans;
  exports com.ak.fx.desktop.nmi to spring.beans;
  exports com.ak.fx.desktop;
}