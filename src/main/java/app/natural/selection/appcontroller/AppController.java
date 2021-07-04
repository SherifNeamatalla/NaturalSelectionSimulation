package app.natural.selection.appcontroller;

import app.natural.selection.algorithm.AlgorithmController;
import app.natural.selection.appcontroller.config.AppInitConfig;
import app.natural.selection.appcontroller.model.AppState;
import app.natural.selection.simulation.controller.SimulationController;
import view.common.controller.ViewController;

public class AppController {

  private final ViewController viewController;

  private final SimulationController simulationController;

  private final AlgorithmController algorithmController;

  private final AppState appState;

  public AppController(AppInitConfig appInitConfig) {
    this.appState = new AppState();
    this.viewController = new ViewController(this, this.appState.getViewConfiguration(), appInitConfig);
    this.simulationController =
            new SimulationController(appInitConfig, this, appState.getSimulationConfiguration());
    this.algorithmController = new AlgorithmController(this.appState.getAlgorithmConfiguration());
  }

  /** Functions for handling user events */
  public void onStartClicked() {
    simulationController.startSimulation();
  }

  public void onStopCLicked() {
    simulationController.stopSimulation();
  }

  public void onPauseClicked() {
    simulationController.pauseSimulation();
  }

  public void onIncreaseSpeedClicked() {
    simulationController.increaseSimulationSpeed();
  }

  public void onDecreaseSpeedClicked() {
    simulationController.decreaseSimulationSpeed();
  }

  public void onSaveClicked() {
    AppUtilFunctions.saveAppState();
  }

  public void onTick() {
    algorithmController.tick(appState.getGeneration(), appState.getFoodHolder());
    AppUtilFunctions.updateStatistic(appState.getGeneration(), appState.getStatistic());
    viewController.draw(
            appState);
  }

  public void launch() {
    this.viewController.launchWindow();
  }
}
