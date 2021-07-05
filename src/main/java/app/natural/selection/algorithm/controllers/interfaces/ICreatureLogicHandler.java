package app.natural.selection.algorithm.controllers.interfaces;

import app.natural.selection.common.model.creature.Creature;
import app.natural.selection.common.model.creature.CreatureAction;
import app.natural.selection.common.model.food.FoodHolder;
import app.natural.selection.common.model.population.Population;


/**
 * This is the creature's brain, in the future this interface could be implemented by a neural network to take action
 */
public interface ICreatureLogicHandler {
    CreatureAction creatureTick(Creature creature, Population population, FoodHolder foodHolder);
}
