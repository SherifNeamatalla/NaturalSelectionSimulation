package app.natural.selection.simulation.controller;

import app.natural.selection.appcontroller.AppController;
import app.natural.selection.appcontroller.config.AppInitConfig;
import app.natural.selection.algorithm.configuration.AlgorithmParameters;
import app.natural.selection.simulation.controller.factories.SimulationControllerLogicHandlerFactory;
import app.natural.selection.simulation.controller.interfaces.ISimulationControllerLogicHandler;

public class SimulationController {

  private final ISimulationControllerLogicHandler logicHandler;

  public SimulationController(
      AppInitConfig appInitConfig,
      AppController appController,
      AlgorithmParameters algorithmParameters) {
    this.logicHandler =
        SimulationControllerLogicHandlerFactory.createSimulationController(
            appInitConfig, appController, algorithmParameters);
  }

  public void startSimulation() {
    logicHandler.startSimulation();
  }

  public void pauseSimulation() {
    logicHandler.pauseSimulation();
  }

  public void stopSimulation() {
    logicHandler.stopSimulation();
  }

  public void increaseSimulationSpeed() {
    logicHandler.increaseSimulationSpeed();
  }

  public void decreaseSimulationSpeed() {
    logicHandler.decreaseSimulationSpeed();
  }

  public int getCurrentSimulationSpeed() {
    return logicHandler.getCurrentSimulationSpeed();
  }
}
