package app.natural.selection.view.common.controller;

import app.natural.selection.appcontroller.AppController;
import app.natural.selection.appcontroller.configuration.AppInitialConfiguration;
import app.natural.selection.appcontroller.model.AppState;
import app.natural.selection.view.common.configuration.ViewConfiguration;
import app.natural.selection.view.common.factories.MainWindowFactory;
import app.natural.selection.view.common.interfaces.IMainWindow;

public class ViewController {

  private final AppController appController;
  private final ViewConfiguration viewConfiguration;
  private final IMainWindow mainWindow;

  public ViewController(AppController appController, ViewConfiguration viewConfiguration, AppInitialConfiguration appInitialConfiguration) {
    this.appController = appController;
    this.viewConfiguration = viewConfiguration;
    this.mainWindow = MainWindowFactory.createMainWindow(appInitialConfiguration, this, viewConfiguration);
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

    public void handleShowCreatureData() {
    appController.handleShowCreatureData();
    }
}
