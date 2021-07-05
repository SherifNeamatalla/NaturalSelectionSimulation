package app.natural.selection.algorithm.configuration;

import static app.natural.selection.algorithm.configuration.AlgorithmConstants.*;

public class AlgorithmParameters {

  private final Integer tickPerSecond;

  private final Integer startingPopulationCount;

  private final Integer foodFrequencySeconds;

  private final Integer foodCount;

  private final Integer creatureStaringEnergy;

  private final Double maxXPosition;

  private final Double maxYPosition;

  private final Double maxFoodNutritionValue;

  private final Double minFoodNutritionValue;

  private final Integer minVisionPixels;

  private final Integer maxVisionPixels;

  private final Double minEnergyDecayPerTick;

  private final Double maxEnergyDecayPerTick;

  private final Integer minInitialCreatureSize;

  private final Integer maxInitialCreatureSize;

  private final Double minSpeedPixels;

  private final Double maxSpeedPixels;

  private final Integer canvasWidth;

  private final Integer canvasHeight;

  private final Integer minRequiredMatingFoodCount;

  private final Integer maxRequiredMatingFoodCount;

  private final Integer minRequiredMatingAgeSeconds;

  private final Integer maxRequiredMatingAgeSeconds;

  private final Integer minReproductionCoolDown;

  private final Integer maxReproductionCoolDown;

  public AlgorithmParameters(Integer canvasHeight, Integer canvasWidth) {
    this.tickPerSecond = DEFAULT_TICKS_PER_SECOND;
    this.startingPopulationCount = DEFAULT_STARTING_POPULATION_COUNT;
    this.creatureStaringEnergy = DEFAULT_CREATURE_STARTING_ENERGY;
    this.foodFrequencySeconds = DEFAULT_FOOD_FREQUENCY_SECONDS;
    this.foodCount = DEFAULT_FOOD_COUNT;
    this.maxXPosition = DEFAULT_MAX_X_POSITION;
    this.maxYPosition = DEFAULT_MAX_Y_POSITION;
    this.maxFoodNutritionValue = DEFAULT_MAX_FOOD_NUTRITION_VALUE;
    this.minFoodNutritionValue = DEFAULT_MIN_FOOD_NUTRITION_VALUE;

    this.minVisionPixels = DEFAULT_MIN_VISION_PIXELS;
    this.maxVisionPixels = DEFAULT_MAX_VISION_PIXELS;
    this.minEnergyDecayPerTick = DEFAULT_MIN_ENERGY_DECAY_PER_TICK;
    this.maxEnergyDecayPerTick = DEFAULT_MAX_ENERGY_DECAY_PER_TICK;
    this.minInitialCreatureSize = DEFAULT_MIN_INITIAL_CREATURE_SIZE;
    this.maxInitialCreatureSize = DEFAULT_MAX_INITIAL_CREATURE_SIZE;
    this.minSpeedPixels = DEFAULT_MIN_SPEED_PIXELS;
    this.maxSpeedPixels = DEFAULT_MAX_SPEED_PIXELS;

    this.minRequiredMatingFoodCount = DEFAULT_MIN_REQUIRED_MATING_FOOD_COUNT;
    this.maxRequiredMatingFoodCount = DEFAULT_MAX_REQUIRED_MATING_FOOD_COUNT;
    this.minRequiredMatingAgeSeconds = DEFAULT_MIN_REQUIRED_MATING_AGE_SECONDS;
    this.maxRequiredMatingAgeSeconds = DEFAULT_MAX_REQUIRED_MATING_AGE_SECONDS;
    this.minReproductionCoolDown = DEFAULT_MIN_REPRODUCTION_COOL_DOWN_SECONDS;
    this.maxReproductionCoolDown = DEFAULT_MAX_REPRODUCTION_COOL_DOWN_SECONDS;

    this.canvasWidth = canvasWidth;
    this.canvasHeight = canvasHeight;
  }

  public Integer getMinRequiredMatingFoodCount() {
    return minRequiredMatingFoodCount;
  }

  public Integer getMaxRequiredMatingFoodCount() {
    return maxRequiredMatingFoodCount;
  }

  public Integer getMinRequiredMatingAgeSeconds() {
    return minRequiredMatingAgeSeconds;
  }

  public Integer getMaxRequiredMatingAgeSeconds() {
    return maxRequiredMatingAgeSeconds;
  }

  public Integer getMinReproductionCoolDown() {
    return minReproductionCoolDown;
  }

  public Integer getMaxReproductionCoolDown() {
    return maxReproductionCoolDown;
  }

  public Integer getTickPerSecond() {
    return tickPerSecond;
  }


  public Integer getStartingPopulationCount() {
    return startingPopulationCount;
  }

  public Integer getFoodFrequencySeconds() {
    return foodFrequencySeconds;
  }

  public Integer getFoodCount() {
    return foodCount;
  }


  public Integer getCreatureStaringEnergy() {
    return creatureStaringEnergy;
  }


  public Double getMaxXPosition() {
    return maxXPosition;
  }

  public Double getMaxYPosition() {
    return maxYPosition;
  }


  public Double getMaxFoodNutritionValue() {
    return maxFoodNutritionValue;
  }


  public Double getMinFoodNutritionValue() {
    return minFoodNutritionValue;
  }


  public Integer getMinVisionPixels() {
    return minVisionPixels;
  }


  public Integer getMaxVisionPixels() {
    return maxVisionPixels;
  }


  public Double getMinEnergyDecayPerTick() {
    return minEnergyDecayPerTick;
  }


  public Double getMaxEnergyDecayPerTick() {
    return maxEnergyDecayPerTick;
  }


  public Integer getMinInitialCreatureSize() {
    return minInitialCreatureSize;
  }


  public Integer getMaxInitialCreatureSize() {
    return maxInitialCreatureSize;
  }

  public Double getMinSpeedPixels() {
    return minSpeedPixels;
  }


  public Double getMaxSpeedPixels() {
    return maxSpeedPixels;
  }


  public Integer getCanvasWidth() {
    return canvasWidth;
  }


  public Integer getCanvasHeight() {
    return canvasHeight;
  }


}
