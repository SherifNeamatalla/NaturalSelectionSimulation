package app.natural.selection.common.model.generation;

import app.natural.selection.common.model.creature.Creature;
import app.natural.selection.simulation.config.SimulationConfiguration;

import java.util.ArrayList;
import java.util.List;

public class Generation {
  private List<Creature> creatures;

  public Generation(SimulationConfiguration simulationConfiguration) {
    this.creatures = new ArrayList<>();

    for (int i = 0; i < simulationConfiguration.getStartingGenerationCount(); i++) {
      this.creatures.add(new Creature(simulationConfiguration));
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
