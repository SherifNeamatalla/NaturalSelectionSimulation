package app.natural.selection.algorithm.controllers.implementations.defaultImpl;

import app.natural.selection.algorithm.controllers.interfaces.IReproductionController;
import app.natural.selection.common.model.creature.Creature;

import java.util.ArrayList;
import java.util.List;

public class DefaultReproductionController implements IReproductionController {
  @Override
  public List<Creature> reproduceNewCreatures(Creature parent1, Creature parent2) {
    List<Creature> offSpring = new ArrayList<>();

    offSpring.add(new Creature(parent1, parent2));
    offSpring.add(new Creature(parent2, parent1));

    return offSpring;
  }
}
