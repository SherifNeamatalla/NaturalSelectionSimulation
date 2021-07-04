package app.natural.selection.view.common.factories;

import app.natural.selection.appcontroller.config.AppInitConfig;
import app.natural.selection.view.common.configuration.ViewConfiguration;
import app.natural.selection.view.common.controller.ViewController;
import app.natural.selection.view.common.interfaces.IMainWindow;
import app.natural.selection.view.viewjavafx.window.MainWindowFx;
import app.natural.selection.view.viewswing.window.MainWindow;

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
