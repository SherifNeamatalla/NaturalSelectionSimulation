import app.natural.selection.appcontroller.AppController;
import app.natural.selection.appcontroller.config.AppInitConfig;
import app.natural.selection.appcontroller.config.FrontendFramework;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MainJavaFxApplication extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    AppController appController =
        new AppController(new AppInitConfig(FrontendFramework.JAVAFX, primaryStage));


  }
}
