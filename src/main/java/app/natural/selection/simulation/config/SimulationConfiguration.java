package app.natural.selection.simulation.config;

import static app.natural.selection.simulation.config.SimulationConstants.*;

public class SimulationConfiguration {

  private Integer tickPerSecond;

  private Integer startingGenerationCount;

  private Integer foodFrequencySeconds;

  private Integer foodCount;

  private Integer creatureStaringEnergy;

  private Double maxXPosition;

  private Double maxYPosition;

  private Double maxFoodNutritionValue;

  private Double minFoodNutritionValue;

  private Integer minVisionPixels;

  private Integer maxVisionPixels;

  private Double minEnergyDecayPerTick;

  private Double maxEnergyDecayPerTick;

  private Integer minInitialCreatureSize;

  private Integer maxInitialCreatureSize;

  private Double minSpeedPixels;

  private Double maxSpeedPixels;

  private Integer canvasWidth;

  private Integer canvasHeight;

  private Integer minRequiredMatingFoodCount;

  private Integer maxRequiredMatingFoodCount;

  private Integer minRequiredMatingAgeSeconds;

  private Integer maxRequiredMatingAgeSeconds;

  private Integer minReproductionCoolDown;

  private Integer maxReproductionCoolDown;

  public SimulationConfiguration(Integer canvasHeight, Integer canvasWidth) {
    this.tickPerSecond = DEFAULT_TICKS_PER_SECOND;
    this.startingGenerationCount = DEFAULT_STARTING_GENERATION_COUNT;
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


  public Integer getStartingGenerationCount() {
    return startingGenerationCount;
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
