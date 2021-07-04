package app.natural.selection.algorithm.controllers.interfaces;

import app.natural.selection.common.model.creature.Creature;

public interface IMutationController {
  void mutateCreature(Creature creature, Double mutationRate);
}
