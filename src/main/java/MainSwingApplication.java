import app.natural.selection.appcontroller.AppController;
import app.natural.selection.appcontroller.config.AppInitConfig;
import app.natural.selection.appcontroller.config.FrontendFramework;

public class MainSwingApplication {

  public static void main(String[] args) {

    AppController appController = new AppController(new AppInitConfig(FrontendFramework.SWING, null));
    appController.launch();
  }
}
