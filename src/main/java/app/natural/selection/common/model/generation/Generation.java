package app.natural.selection.common.model.generation;

import app.natural.selection.common.model.creature.Creature;
import app.natural.selection.algorithm.configuration.AlgorithmParameters;

import java.util.ArrayList;
import java.util.List;

public class Generation {
  private List<Creature> creatures;

  public Generation(AlgorithmParameters algorithmParameters) {
    this.creatures = new ArrayList<>();

    for (int i = 0; i < algorithmParameters.getStartingGenerationCount(); i++) {
      this.creatures.add(new Creature(algorithmParameters));
    }
  }

  public Generation(List<Creature> creatures) {
    this.creatures = creatures;
  }

  public List<Creature> getCreatures() {
    return creatures;
  }

  public void setCreatures(List<Creature> creatures) {
    this.creatures = creatures;
  }
}
