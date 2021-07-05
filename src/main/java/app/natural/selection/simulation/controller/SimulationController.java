package app.natural.selection.simulation.controller;

import app.natural.selection.algorithm.configuration.AlgorithmParameters;
import app.natural.selection.appcontroller.AppController;
import app.natural.selection.appcontroller.configuration.AppInitialConfiguration;
import app.natural.selection.simulation.controller.factories.SimulationControllerLogicHandlerFactory;
import app.natural.selection.simulation.controller.interfaces.ISimulationControllerLogicHandler;

public class SimulationController {

    private final ISimulationControllerLogicHandler logicHandler;

    public SimulationController(
            AppInitialConfiguration appInitialConfiguration,
            AppController appController,
            AlgorithmParameters algorithmParameters) {
        this.logicHandler =
                SimulationControllerLogicHandlerFactory.createSimulationController(
                        appInitialConfiguration, appController, algorithmParameters);
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

    public void onSpeedChanged() {
        logicHandler.refreshSimulation();
    }

}
