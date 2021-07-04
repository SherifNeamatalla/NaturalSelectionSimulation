package view.common.factories;

import app.natural.selection.appcontroller.config.AppInitConfig;
import view.common.configuration.ViewConfiguration;
import view.common.controller.ViewController;
import view.common.interfaces.IMainWindow;
import view.viewjavafx.window.MainWindowFx;
import view.viewswing.window.MainWindow;

public class MainWindowFactory {

  public static IMainWindow createMainWindow(
      AppInitConfig appInitConfig,
      ViewController viewController,
      ViewConfiguration viewConfiguration) {
    return switch (appInitConfig.getFrontendFramework()) {
      case SWING -> new MainWindow(viewController, viewConfiguration);
      case JAVAFX -> new MainWindowFx(viewController, viewConfiguration,appInitConfig.getPrimaryStage());
      default -> new MainWindow(viewController, viewConfiguration);
    };
  }
}
