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
  requires spring.core;
  requires spring.beans;

  opens com.ak.fx.core to spring.core;
  opens com.ak.fx.desktop to spring.core, javafx.fxml;
  opens com.ak.fx.desktop.nmi to javafx.fxml;
  opens com.ak.fx.desktop.aper to javafx.fxml;
  exports com.ak.fx.core to spring.context, spring.beans;
  exports com.ak.fx.desktop.aper to spring.beans, javafx.fxml;
  exports com.ak.fx.desktop.nmi to spring.beans, javafx.fxml;
  exports com.ak.fx.desktop;
}