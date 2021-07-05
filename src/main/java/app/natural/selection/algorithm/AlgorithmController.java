package app.natural.selection.algorithm;

import app.natural.selection.algorithm.configuration.AlgorithmConfiguration;
import app.natural.selection.algorithm.controllers.interfaces.IReproductionController;
import app.natural.selection.algorithm.factories.AlgorithmControllersFactory;
import app.natural.selection.appcontroller.model.AppState;
import app.natural.selection.common.model.creature.CreatureAction;
import app.natural.selection.common.model.food.FoodHolder;
import app.natural.selection.common.model.population.Population;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static app.natural.selection.algorithm.actionhandler.CreatureActionHandler.handleCreatureActions;

public class AlgorithmController {

    private IReproductionController reproductionController;

    private final AlgorithmConfiguration configuration;


    public AlgorithmController(AlgorithmConfiguration configuration) {
        this.configuration = configuration;
        this.reproductionController =
                AlgorithmControllersFactory.createReproductionController(configuration.getReproductionControllerType());
    }

    public List<CreatureAction> tick(AppState appState) {
        Population population = appState.getPopulation();
        FoodHolder foodHolder = appState.getFoodHolder();
        List<CreatureAction> creatureActions = Collections.synchronizedList(new
                ArrayList<>());
        population.getCreatures()
                .forEach(
                        creature -> {
                            creatureActions.add(creature.tick(population, foodHolder));
                        });

        handleCreatureActions(population, foodHolder, creatureActions, reproductionController, configuration);
        appState.generateFood();

        return creatureActions;
    }
}
