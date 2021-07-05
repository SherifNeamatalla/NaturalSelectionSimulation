import app.natural.selection.appcontroller.AppController;
import app.natural.selection.appcontroller.configuration.AppInitialConfiguration;
import app.natural.selection.appcontroller.configuration.FrontendFramework;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainJavaFxApplication extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    AppController appController =
        new AppController(new AppInitialConfiguration(FrontendFramework.JAVAFX, primaryStage));

    appController.launch();
  }
}
