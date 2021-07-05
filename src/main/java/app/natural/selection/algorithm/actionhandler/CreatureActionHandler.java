package app.natural.selection.algorithm.actionhandler;

import app.natural.selection.algorithm.configuration.AlgorithmConfiguration;
import app.natural.selection.algorithm.controllers.interfaces.IReproductionController;
import app.natural.selection.appcontroller.logger.AppLogger;
import app.natural.selection.common.model.creature.Creature;
import app.natural.selection.common.model.creature.CreatureAction;
import app.natural.selection.common.model.food.Food;
import app.natural.selection.common.model.food.FoodHolder;
import app.natural.selection.common.model.population.Population;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CreatureActionHandler {

    public static void handleCreatureActions(
            Population population, FoodHolder foodHolder, List<CreatureAction> creatureActions,
            IReproductionController reproductionController, AlgorithmConfiguration configuration,
            Long currentTick) {
        for (CreatureAction creatureAction : creatureActions) {
            switch (creatureAction.getType()) {
                case REPRODUCTION -> onReproduction(population, creatureAction.getActionTakingCreature(), creatureAction.getLoveInterest(),
                        reproductionController, configuration, currentTick);

                case DEAD -> onCreatureDead(population, creatureAction.getActionTakingCreature());

                case ATE_FOOD -> onCreatureAteFood(creatureAction.getActionTakingCreature(), foodHolder, creatureAction.getAteFood());

            }
        }
    }

    private static void onCreatureAteFood(Creature actionTakingCreature, FoodHolder foodHolder, Food ateFood) {
        Optional<Food> ateFoodOptional = foodHolder.getFoodList().stream().filter(food -> food.getId().equals(ateFood.getId())).findFirst();

        ateFoodOptional.ifPresent((foundFood) -> {
            foodHolder.getFoodList().remove(foundFood);
            actionTakingCreature.eatFood(foundFood);
        });
    }

    private static void onCreatureDead(Population population, Creature actionTakingCreature) {
        population.setCreatures(population.getCreatures().stream().filter(creature ->
                !creature.getId().equals(actionTakingCreature.getId())).collect(Collectors.toList()));
    }

    private static void onReproduction(Population population, Creature actionTakingCreature, Creature loveInterest,
                                       IReproductionController reproductionController, AlgorithmConfiguration configuration,
                                       Long currentTick) {
        List<Creature> offSpring = reproductionController.reproduceNewCreatures(actionTakingCreature, loveInterest, currentTick);
        offSpring.forEach(creature -> creature.mutate(configuration.getMutationRate()));
        population.getCreatures().addAll(offSpring);
        actionTakingCreature.mated(currentTick);
        loveInterest.mated(currentTick);
        AppLogger.logMessage("Mated!!");

    }
}
