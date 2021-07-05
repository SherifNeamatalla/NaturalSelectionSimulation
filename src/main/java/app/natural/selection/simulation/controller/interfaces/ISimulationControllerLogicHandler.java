package app.natural.selection.simulation.controller.interfaces;

public interface ISimulationControllerLogicHandler {

  void startSimulation();

  void pauseSimulation();

  void stopSimulation();

  void increaseSimulationSpeed();

  void decreaseSimulationSpeed();

  int getCurrentSimulationSpeed();
}
