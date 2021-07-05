package app.natural.selection.appcontroller.configuration;

import javafx.stage.Stage;

public class AppInitialConfiguration {
    private final FrontendFramework frontendFramework;

    // relevant in case of javafx
    private final Stage primaryStage;

    public AppInitialConfiguration(FrontendFramework frontendFramework, Stage primaryStage) {
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
