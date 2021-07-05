package app.natural.selection.common.model.food;

import app.natural.selection.common.model.position.Position;
import app.natural.selection.common.util.RandomNumberGenerator;
import app.natural.selection.algorithm.configuration.AlgorithmParameters;

import java.util.UUID;

public class Food {

  private final UUID id;

  private final Position position;

  private final Double nutritionValue;

  public Food(AlgorithmParameters algorithmParameters) {
    this.id = UUID.randomUUID();
    this.position = new Position(algorithmParameters);
    this.nutritionValue =
        RandomNumberGenerator.generateRandomDouble(
            algorithmParameters.getMinFoodNutritionValue(),
            algorithmParameters.getMaxFoodNutritionValue());
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
