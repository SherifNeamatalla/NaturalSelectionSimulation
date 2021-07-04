package app.natural.selection.appcontroller.config;

import javafx.stage.Stage;

public class AppInitConfig {
  private FrontendFramework frontendFramework;

  // relevant in case of javafx
  private Stage primaryStage;

  public AppInitConfig(FrontendFramework frontendFramework, Stage primaryStage) {
    this.frontendFramework = frontendFramework;
    this.primaryStage = primaryStage;
  }

  public FrontendFramework getFrontendFramework() {
    return frontendFramework;
  }

  public Stage getPrimaryStage() {
    return primaryStage;
  }
}
