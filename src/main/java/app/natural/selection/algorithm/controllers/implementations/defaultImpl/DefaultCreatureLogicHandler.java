package app.natural.selection.algorithm.controllers.implementations.defaultImpl;

import app.natural.selection.algorithm.controllers.interfaces.ICreatureLogicHandler;
import app.natural.selection.algorithm.util.DistanceCalculator;
import app.natural.selection.common.model.creature.Creature;
import app.natural.selection.common.model.creature.CreatureAction;
import app.natural.selection.common.model.creature.CreatureActionType;
import app.natural.selection.common.model.creature.MovingDirection;
import app.natural.selection.common.model.food.Food;
import app.natural.selection.common.model.food.FoodHolder;
import app.natural.selection.common.model.generation.Generation;

public class DefaultCreatureLogicHandler implements ICreatureLogicHandler {

  public CreatureAction creatureTick(
          Creature creature, Generation generation, FoodHolder foodHolder) {

    creature.decayEnergy();

    if (creature.getEnergy() <= 0) return CreatureAction.dead(creature);


    // if energy > half, try to reproduce before finding food
    if (creature.isReadyToMate()) {
      CreatureAction matingTry = tryMating(creature, generation);


      if (matingTry.getType() == CreatureActionType.REPRODUCTION) {
        return matingTry;
      }
    }

    Double minDistance = Double.MAX_VALUE;
    Food nearestFood = null;
    for (Food food : foodHolder.getFoodList()) {
      Double distance =
              DistanceCalculator.calculateDistance(creature.getPosition(), food.getPosition());

      // Outside vision range
      if (distance > creature.getCreatureProperties().getVisionPixels()) continue;

      // Inside the creature, creature eats it
      if (distance <= creature.getCreatureProperties().getSizePixels()) {
        return CreatureAction.eatFoodAction(creature, food);
      }
      if (distance < minDistance) {
        minDistance = distance;
        nearestFood = food;
      }
    }

    if (nearestFood == null) {
      creature.move();
      return CreatureAction.emptyAction(creature);
    }

    Integer verticalDirection =
            nearestFood.getPosition().getY().compareTo(creature.getPosition().getY());

    Integer horizontalDirection =
            nearestFood.getPosition().getX().compareTo(creature.getPosition().getX());

    creature.move(
            MovingDirection.fromIntValue(horizontalDirection),
            MovingDirection.fromIntValue(verticalDirection));

    return CreatureAction.emptyAction(creature);
  }

  private CreatureAction tryMating(Creature creature, Generation generation) {
    for (Creature possibleLoveInterest : generation.getCreatures()) {
      // Don't "fuck" yourself, lol
      if (creature.getId().equals(possibleLoveInterest.getId())) continue;
      Double distance =
              DistanceCalculator.calculateDistance(creature.getPosition(), possibleLoveInterest.getPosition());

      // Outside vision range
      if (distance > creature.getCreatureProperties().getVisionPixels()) continue;

      // Inside the creature, creature eats it
      if (distance <= creature.getCreatureProperties().getSizePixels() && possibleLoveInterest.isReadyToMate() &&
              distance <= creature.getCreatureProperties().getSizePixels()) {
        return CreatureAction.reproduction(creature, possibleLoveInterest);
      }
    }
    return CreatureAction.emptyAction(creature);
  }
}
