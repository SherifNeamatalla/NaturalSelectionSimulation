package app.natural.selection.algorithm.controllers.interfaces;

import app.natural.selection.common.model.food.FoodHolder;
import app.natural.selection.common.model.creature.Creature;
import app.natural.selection.common.model.creature.CreatureAction;
import app.natural.selection.common.model.generation.Generation;

public interface ICreatureLogicHandler {
  public CreatureAction creatureTick(Creature creature, Generation generation, FoodHolder foodHolder);
}
