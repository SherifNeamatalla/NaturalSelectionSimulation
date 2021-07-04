package app.natural.selection.appcontroller;

import app.natural.selection.algorithm.AlgorithmController;
import app.natural.selection.appcontroller.model.AppState;
import app.natural.selection.simulation.controller.SimulationController;
import app.natural.selection.view.controller.ViewController;

public class AppController {

  private final ViewController viewController;

  private final SimulationController simulationController;

  private final AlgorithmController algorithmController;

  private final AppState appState;

  public AppController() {
    this.appState = new AppState();
    this.viewController = new ViewController(this, this.appState.getViewConfiguration());
    this.simulationController =
        new SimulationController(this);
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
        appState.getGeneration(), appState.getFoodHolder(), appState.getStatistic());
  }

  public void launch() {
    this.viewController.launchWindow();
  }
}
