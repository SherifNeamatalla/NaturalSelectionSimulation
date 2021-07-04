package app.natural.selection.algorithm;

import app.natural.selection.algorithm.configuration.AlgorithmConfiguration;
import app.natural.selection.algorithm.controllers.interfaces.IMutationController;
import app.natural.selection.algorithm.controllers.interfaces.IReproductionController;
import app.natural.selection.algorithm.factories.AlgorithmControllersFactory;
import app.natural.selection.common.model.creature.Creature;
import app.natural.selection.common.model.creature.CreatureAction;
import app.natural.selection.common.model.food.Food;
import app.natural.selection.common.model.food.FoodHolder;
import app.natural.selection.common.model.generation.Generation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AlgorithmController {

  private IMutationController mutationController;
  private IReproductionController reproductionController;

  private final AlgorithmConfiguration configuration;

  private int count = 0;

  public AlgorithmController(AlgorithmConfiguration configuration) {
    this.configuration = configuration;
    this.initControllers();
  }

  private void initControllers() {
    mutationController = AlgorithmControllersFactory.createMutationController(configuration.getMutationControllerType());
    reproductionController = AlgorithmControllersFactory.createReproductionController(configuration.getReproductionControllerType());
  }


  private void handleCreatureActions(
          Generation generation, FoodHolder foodHolder,List<CreatureAction> creatureActions) {
    for (CreatureAction creatureAction : creatureActions) {
      switch (creatureAction.getType()){
        case REPRODUCTION->
                onReproduction(generation, creatureAction.getActionTakingCreature(), creatureAction.getLoveInterest());

        case DEAD -> onCreatureDead(generation,creatureAction.getActionTakingCreature());

        case ATE_FOOD -> onCreatureAteFood(creatureAction.getActionTakingCreature(),foodHolder,creatureAction.getAteFood());

      }
    }
  }

  private void onCreatureAteFood(Creature actionTakingCreature,FoodHolder foodHolder, Food ateFood) {
    Optional<Food> ateFoodOptional = foodHolder.getFoodList().stream().filter(food -> !food.getId().equals(ateFood.getId())).findFirst();

    ateFoodOptional.ifPresentOrElse((foundFood)->{
      actionTakingCreature.setEnergy(actionTakingCreature.getEnergy()+foundFood.getNutritionValue());
      foodHolder.setFoodList(foodHolder.getFoodList().stream().filter(food -> !food.getId().equals(foundFood.getId())).collect(Collectors.toList()));
    },()->{System.out.println("Missed!");
        });
  }

  private void onCreatureDead(Generation generation,Creature actionTakingCreature) {
    generation.setCreatures(generation.getCreatures().stream().filter(creature ->
            !creature.getId().equals(actionTakingCreature.getId())).collect(Collectors.toList()));
  }

  private void onReproduction(Generation generation,Creature actionTakingCreature, Creature loveInterest) {
    List<Creature> offSpring = reproductionController.reproduceNewCreatures(actionTakingCreature,loveInterest);
    offSpring.forEach(creature -> mutationController.mutateCreature(creature,configuration.getMutationRate()));
    generation.getCreatures().addAll(offSpring);
  }

  public void tick(Generation generation, FoodHolder foodHolder) {
    count++;
              List<CreatureAction> creatureActions = Collections.synchronizedList(new
                      ArrayList<>());
              generation.getCreatures()
                  .forEach(
                      creature -> {
                        creatureActions.add(creature.tick(generation, foodHolder));
                      });

              handleCreatureActions(generation,foodHolder,creatureActions);

  }
}
