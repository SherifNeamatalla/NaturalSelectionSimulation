package app.natural.selection.view.common.controller;

import app.natural.selection.appcontroller.AppController;
import app.natural.selection.appcontroller.config.AppInitConfig;
import app.natural.selection.appcontroller.model.AppState;
import app.natural.selection.view.common.configuration.ViewConfiguration;
import app.natural.selection.view.common.factories.MainWindowFactory;
import app.natural.selection.view.common.interfaces.IMainWindow;

public class ViewController {

  private AppController appController;
  private ViewConfiguration viewConfiguration;
  private IMainWindow mainWindow;

  public ViewController(AppController appController, ViewConfiguration viewConfiguration, AppInitConfig appInitConfig) {
    this.appController = appController;
    this.viewConfiguration = viewConfiguration;
    initMainWindow(appInitConfig);
  }

  /**
   * Init methods
   *
   * @param appInitConfig
   */
  private void initMainWindow(AppInitConfig appInitConfig) {
    // For now we have just one main window class, in the future using viewConfig we can have
    // multiple types and a factory
    this.mainWindow = MainWindowFactory.createMainWindow(appInitConfig, this, viewConfiguration);
  }

  public void launchWindow() {
    this.mainWindow.display();
  }

  /**
   * Event listeners
   */
  public void handleStartEvent() {
    appController.onStartClicked();
  }

  public void handleDecreaseSpeedEvent() {
    appController.onDecreaseSpeedClicked();
  }

  public void handleIncreaseSpeedEvent() {
    appController.onIncreaseSpeedClicked();
  }

  public void handleSaveEvent() {
    appController.onSaveClicked();
  }

  public void handleStopEvent() {
    appController.onStopCLicked();
  }

  public void handlePauseEvent() {
    appController.onPauseClicked();
  }

  public void draw(AppState appState) {
    this.mainWindow.draw(appState);
  }
}
