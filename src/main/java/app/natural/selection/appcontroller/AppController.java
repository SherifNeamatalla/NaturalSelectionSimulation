package app.natural.selection.appcontroller;

import app.natural.selection.algorithm.AlgorithmController;
import app.natural.selection.appcontroller.configuration.AppInitialConfiguration;
import app.natural.selection.appcontroller.model.AppState;
import app.natural.selection.common.model.creature.CreatureAction;
import app.natural.selection.simulation.controller.SimulationController;
import app.natural.selection.view.common.controller.ViewController;

import java.util.List;

public class AppController {

    private final ViewController viewController;

    private final SimulationController simulationController;

    private final AlgorithmController algorithmController;

    private final AppState appState;

    public AppController(AppInitialConfiguration appInitialConfiguration) {
        this.appState = new AppState();
        this.viewController = new ViewController(this, this.appState.getViewConfiguration(), appInitialConfiguration);
        this.simulationController =
                new SimulationController(appInitialConfiguration, this, appState.getSimulationConfiguration());
        this.algorithmController = new AlgorithmController(this.appState.getAlgorithmConfiguration());
    }

    /**
     * Functions for handling user events
     */
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
        AppStatisticCalculator.saveAppState();
    }

    public void onTick() {
        List<CreatureAction> creatureActionList = algorithmController.tick(appState);
        AppStatisticCalculator.updateStatistic(appState.getPopulation(), appState.getStatistic());
        viewController.draw(
                appState);
    }

    public void launch() {
        this.viewController.launchWindow();
    }
}
