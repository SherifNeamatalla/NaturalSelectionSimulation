package app.natural.selection.view.controller;

import app.natural.selection.appcontroller.AppController;
import app.natural.selection.appcontroller.model.Statistic;
import app.natural.selection.common.model.food.FoodHolder;
import app.natural.selection.common.model.generation.Generation;
import app.natural.selection.view.configuration.ViewConfiguration;
import app.natural.selection.view.window.MainWindow;

public class ViewController {

  private AppController appController;
  private ViewConfiguration viewConfiguration;
  private MainWindow mainWindow;
  private int count = 0;

  public ViewController(AppController appController, ViewConfiguration viewConfiguration) {
    this.appController = appController;
    this.viewConfiguration = viewConfiguration;
    initMainWindow();
  }

  /** Init methods */
  private void initMainWindow() {
    // For now we have just one main window class, in the future using viewConfig we can have
    // multiple types and a factory
    this.mainWindow = new MainWindow(this, viewConfiguration);
  }

  public void launchWindow() {
    this.mainWindow.display();
  }

  /** Event listeners */
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

  public void draw(Generation generation, FoodHolder foodHolder, Statistic statistic) {
    count++;
    this.mainWindow.draw(generation, foodHolder, statistic);
  }
}
