package app.natural.selection.simulation.controller.factories;

import app.natural.selection.appcontroller.AppController;
import app.natural.selection.appcontroller.config.AppInitConfig;
import app.natural.selection.algorithm.configuration.AlgorithmParameters;
import app.natural.selection.simulation.controller.interfaces.ISimulationControllerLogicHandler;
import app.natural.selection.simulation.controller.javafx.SimulationControllerLogicHandlerFx;
import app.natural.selection.simulation.controller.swing.GeneralSimulationControllerLogicHandler;

public class SimulationControllerLogicHandlerFactory {

    public static ISimulationControllerLogicHandler createSimulationController(AppInitConfig appInitConfig, AppController appController,
                                                                               AlgorithmParameters algorithmParameters){
        return switch (appInitConfig.getFrontendFramework()) {
            case SWING -> new GeneralSimulationControllerLogicHandler(appController);
            case JAVAFX -> new SimulationControllerLogicHandlerFx(appController, algorithmParameters);
            default -> new GeneralSimulationControllerLogicHandler(appController);
        };
    }
}
