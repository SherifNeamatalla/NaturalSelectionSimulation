package app.natural.selection.algorithm.controllers.interfaces;

import app.natural.selection.common.model.creature.Creature;

import java.util.List;

public interface IReproductionController {

  List<Creature> reproduceNewCreatures(Creature parent1, Creature parent2, Long currentTick);
}
