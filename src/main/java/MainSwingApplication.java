import app.natural.selection.appcontroller.AppController;
import app.natural.selection.appcontroller.configuration.AppInitialConfiguration;
import app.natural.selection.appcontroller.configuration.FrontendFramework;

public class MainSwingApplication {

  public static void main(String[] args) {

    AppController appController = new AppController(new AppInitialConfiguration(FrontendFramework.SWING, null));
    appController.launch();
  }
}
