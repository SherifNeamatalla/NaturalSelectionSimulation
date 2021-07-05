package app.natural.selection.common.model.population;

import app.natural.selection.common.model.creature.Creature;
import app.natural.selection.algorithm.configuration.AlgorithmParameters;

import java.util.ArrayList;
import java.util.List;

public class Population {
  private List<Creature> creatures;

  public Population(AlgorithmParameters algorithmParameters) {
    this.creatures = new ArrayList<>();

    for (int i = 0; i < algorithmParameters.getStartingPopulationCount(); i++) {
      this.creatures.add(new Creature(algorithmParameters));
    }
  }

  public Population(List<Creature> creatures) {
    this.creatures = creatures;
  }

  public List<Creature> getCreatures() {
    return creatures;
  }

  public void setCreatures(List<Creature> creatures) {
    this.creatures = creatures;
  }
}
