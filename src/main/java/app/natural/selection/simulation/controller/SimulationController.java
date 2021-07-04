package app.natural.selection.simulation.controller;

import app.natural.selection.appcontroller.AppController;
import app.natural.selection.appcontroller.config.AppInitConfig;
import app.natural.selection.simulation.config.SimulationConfiguration;
import app.natural.selection.simulation.controller.factories.SimulationControllerLogicHandlerFactory;
import app.natural.selection.simulation.controller.interfaces.ISimulationControllerLogicHandler;

public class SimulationController {

  private ISimulationControllerLogicHandler logicHandler;

  public SimulationController(
      AppInitConfig appInitConfig,
      AppController appController,
      SimulationConfiguration simulationConfiguration) {
    this.logicHandler =
        SimulationControllerLogicHandlerFactory.createSimulationController(
            appInitConfig, appController, simulationConfiguration);
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
}
