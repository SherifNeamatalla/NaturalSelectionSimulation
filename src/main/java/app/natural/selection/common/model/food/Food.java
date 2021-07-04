package app.natural.selection.common.model.food;

import app.natural.selection.common.model.Position;
import app.natural.selection.common.util.RandomNumberGenerator;
import app.natural.selection.simulation.config.SimulationConfiguration;

import java.util.UUID;

public class Food {

  private final UUID id;

  private final Position position;

  private final Double nutritionValue;

  public Food(SimulationConfiguration simulationConfiguration) {
    this.id = UUID.randomUUID();
    this.position = new Position(simulationConfiguration);
    this.nutritionValue =
        RandomNumberGenerator.generateRandomDouble(
            simulationConfiguration.getMinFoodNutritionValue(),
            simulationConfiguration.getMaxFoodNutritionValue());
  }

  public UUID getId() {
    return id;
  }

  public Position getPosition() {
    return position;
  }

  public Double getNutritionValue() {
    return nutritionValue;
  }
}
