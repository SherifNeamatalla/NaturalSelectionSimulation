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
    this.canvasWidth = canvasWidth;
    this.canvasHeight = canvasHeight;
  }

  public Integer getTickPerSecond() {
    return tickPerSecond;
  }

  public void setTickPerSecond(Integer tickPerSecond) {
    this.tickPerSecond = tickPerSecond;
  }

  public Integer getStartingGenerationCount() {
    return startingGenerationCount;
  }

  public void setStartingGenerationCount(Integer startingGenerationCount) {
    this.startingGenerationCount = startingGenerationCount;
  }

  public Integer getFoodFrequencySeconds() {
    return foodFrequencySeconds;
  }

  public void setFoodFrequencySeconds(Integer foodFrequencySeconds) {
    this.foodFrequencySeconds = foodFrequencySeconds;
  }

  public Integer getFoodCount() {
    return foodCount;
  }

  public void setFoodCount(Integer foodCount) {
    this.foodCount = foodCount;
  }

  public Integer getCreatureStaringEnergy() {
    return creatureStaringEnergy;
  }

  public void setCreatureStaringEnergy(Integer creatureStaringEnergy) {
    this.creatureStaringEnergy = creatureStaringEnergy;
  }

  public Double getMaxXPosition() {
    return maxXPosition;
  }

  public void setMaxXPosition(Double maxXPosition) {
    this.maxXPosition = maxXPosition;
  }

  public Double getMaxYPosition() {
    return maxYPosition;
  }

  public void setMaxYPosition(Double maxYPosition) {
    this.maxYPosition = maxYPosition;
  }

  public Double getMaxFoodNutritionValue() {
    return maxFoodNutritionValue;
  }

  public void setMaxFoodNutritionValue(Double maxFoodNutritionValue) {
    this.maxFoodNutritionValue = maxFoodNutritionValue;
  }

  public Double getMinFoodNutritionValue() {
    return minFoodNutritionValue;
  }

  public void setMinFoodNutritionValue(Double minFoodNutritionValue) {
    this.minFoodNutritionValue = minFoodNutritionValue;
  }

  public Integer getMinVisionPixels() {
    return minVisionPixels;
  }

  public void setMinVisionPixels(Integer minVisionPixels) {
    this.minVisionPixels = minVisionPixels;
  }

  public Integer getMaxVisionPixels() {
    return maxVisionPixels;
  }

  public void setMaxVisionPixels(Integer maxVisionPixels) {
    this.maxVisionPixels = maxVisionPixels;
  }

  public Double getMinEnergyDecayPerTick() {
    return minEnergyDecayPerTick;
  }

  public void setMinEnergyDecayPerTick(Double minEnergyDecayPerTick) {
    this.minEnergyDecayPerTick = minEnergyDecayPerTick;
  }

  public Double getMaxEnergyDecayPerTick() {
    return maxEnergyDecayPerTick;
  }

  public void setMaxEnergyDecayPerTick(Double maxEnergyDecayPerTick) {
    this.maxEnergyDecayPerTick = maxEnergyDecayPerTick;
  }

  public Integer getMinInitialCreatureSize() {
    return minInitialCreatureSize;
  }

  public void setMinInitialCreatureSize(Integer minInitialCreatureSize) {
    this.minInitialCreatureSize = minInitialCreatureSize;
  }

  public Integer getMaxInitialCreatureSize() {
    return maxInitialCreatureSize;
  }

  public void setMaxInitialCreatureSize(Integer maxInitialCreatureSize) {
    this.maxInitialCreatureSize = maxInitialCreatureSize;
  }

  public Double getMinSpeedPixels() {
    return minSpeedPixels;
  }

  public void setMinSpeedPixels(Double minSpeedPixels) {
    this.minSpeedPixels = minSpeedPixels;
  }

  public Double getMaxSpeedPixels() {
    return maxSpeedPixels;
  }

  public void setMaxSpeedPixels(Double maxSpeedPixels) {
    this.maxSpeedPixels = maxSpeedPixels;
  }

  public Integer getCanvasWidth() {
    return canvasWidth;
  }

  public void setCanvasWidth(Integer canvasWidth) {
    this.canvasWidth = canvasWidth;
  }

  public Integer getCanvasHeight() {
    return canvasHeight;
  }

  public void setCanvasHeight(Integer canvasHeight) {
    this.canvasHeight = canvasHeight;
  }
}
