package app.natural.selection.common.model.creature;

import app.natural.selection.common.util.RandomNumberGenerator;
import app.natural.selection.algorithm.configuration.AlgorithmParameters;

public class CreatureProperties {

  private Double pixelsPerTick;

  private Integer sizePixels;

  private Double energyDecayPerTick;

  private Integer visionPixels;

  private Integer reproductionCoolDownTicks;

  private Integer reproductionRequiredFoodCount;

  private Integer reproductionRequiredAgeTicks;

  public CreatureProperties(AlgorithmParameters algorithmParameters) {
    this.pixelsPerTick =
            RandomNumberGenerator.generateRandomDouble(
                    algorithmParameters.getMinSpeedPixels(),
                    algorithmParameters.getMaxSpeedPixels());

    this.sizePixels =
            RandomNumberGenerator.generateRandomInteger(
                    algorithmParameters.getMinInitialCreatureSize(),
                    algorithmParameters.getMaxInitialCreatureSize());

    this.energyDecayPerTick =
            RandomNumberGenerator.generateRandomDouble(
                    algorithmParameters.getMinEnergyDecayPerTick(),
                    algorithmParameters.getMaxEnergyDecayPerTick());

    this.visionPixels =
            RandomNumberGenerator.generateRandomInteger(
                    algorithmParameters.getMinVisionPixels(),
                    algorithmParameters.getMaxVisionPixels());

    this.reproductionCoolDownTicks =
            RandomNumberGenerator.generateRandomInteger(
                    algorithmParameters.getMinReproductionCoolDown(),
                    algorithmParameters.getMaxReproductionCoolDown());

    this.reproductionRequiredFoodCount =
            RandomNumberGenerator.generateRandomInteger(
                    algorithmParameters.getMinRequiredMatingFoodCount(),
                    algorithmParameters.getMaxRequiredMatingFoodCount());

    this.reproductionRequiredAgeTicks =
            RandomNumberGenerator.generateRandomInteger(
                    algorithmParameters.getMinRequiredMatingAgeSeconds(),
                    algorithmParameters.getMaxRequiredMatingAgeSeconds());
  }

  public CreatureProperties(CreatureProperties creatureProperties1, CreatureProperties creatureProperties2) {

    int inheritFromParentRandom = RandomNumberGenerator.generateRandomInteger(1, 2);

    this.pixelsPerTick = inheritFromParentRandom == 1 ? creatureProperties1.getPixelsPerTick() :
            inheritFromParentRandom == 2 ? creatureProperties2.getPixelsPerTick() : null;

    inheritFromParentRandom = RandomNumberGenerator.generateRandomInteger(1, 2);

    this.sizePixels = inheritFromParentRandom == 1 ? creatureProperties1.getSizePixels() :
            inheritFromParentRandom == 2 ? creatureProperties2.getSizePixels() : null;

    inheritFromParentRandom = RandomNumberGenerator.generateRandomInteger(1, 2);

    this.energyDecayPerTick = inheritFromParentRandom == 1 ? creatureProperties1.getEnergyDecayPerTick() :
            inheritFromParentRandom == 2 ? creatureProperties2.getEnergyDecayPerTick() : null;

    inheritFromParentRandom = RandomNumberGenerator.generateRandomInteger(1, 2);

    this.visionPixels = inheritFromParentRandom == 1 ? creatureProperties1.getVisionPixels() :
            inheritFromParentRandom == 2 ? creatureProperties2.getVisionPixels() : null;

    inheritFromParentRandom = RandomNumberGenerator.generateRandomInteger(1, 2);

    this.reproductionCoolDownTicks = inheritFromParentRandom == 1 ? creatureProperties1.getReproductionCoolDownTicks() :
            inheritFromParentRandom == 2 ? creatureProperties2.getReproductionCoolDownTicks() : null;

    inheritFromParentRandom = RandomNumberGenerator.generateRandomInteger(1, 2);

    this.reproductionRequiredFoodCount = inheritFromParentRandom == 1 ? creatureProperties1.getReproductionRequiredFoodCount() :
            inheritFromParentRandom == 2 ? creatureProperties2.getReproductionRequiredFoodCount() : null;

    inheritFromParentRandom = RandomNumberGenerator.generateRandomInteger(1, 2);

    this.reproductionRequiredAgeTicks = inheritFromParentRandom == 1 ? creatureProperties1.getReproductionRequiredAgeTicks() :
            inheritFromParentRandom == 2 ? creatureProperties2.getReproductionRequiredAgeTicks() : null;


  }


  public Integer getReproductionRequiredFoodCount() {
    return reproductionRequiredFoodCount;
  }

  public Integer getReproductionRequiredAgeTicks() {
    return reproductionRequiredAgeTicks;
  }

  public Double getPixelsPerTick() {
    return pixelsPerTick;
  }

  public Integer getSizePixels() {
    return sizePixels;
  }

  public Double getEnergyDecayPerTick() {
    return energyDecayPerTick;
  }

  public Integer getVisionPixels() {
    return visionPixels;
  }

  public Integer getReproductionCoolDownTicks() {
    return reproductionCoolDownTicks;
  }

  public void mutate(Double mutationRate, AlgorithmParameters algorithmParameters) {
    Double probability = RandomNumberGenerator.generateRandomDouble(0.0, 1.0);

    if (probability <= mutationRate) {
      this.pixelsPerTick = RandomNumberGenerator.generateRandomDouble(algorithmParameters.getMinSpeedPixels(),
              algorithmParameters.getMaxSpeedPixels()) + RandomNumberGenerator.generateRandomDouble(-5.0, 5.0);

    }

    probability = RandomNumberGenerator.generateRandomDouble(0.0, 1.0);

    if (probability <= mutationRate) {
      this.energyDecayPerTick = RandomNumberGenerator.generateRandomDouble(algorithmParameters.getMinEnergyDecayPerTick(),
              algorithmParameters.getMaxEnergyDecayPerTick()) + RandomNumberGenerator.generateRandomDouble(-0.1, 0.1);

      if (energyDecayPerTick <= 0) {
        energyDecayPerTick = algorithmParameters.getMinEnergyDecayPerTick();
      }
    }

    probability = RandomNumberGenerator.generateRandomDouble(0.0, 1.0);

    if (probability <= mutationRate) {
      this.sizePixels = RandomNumberGenerator.generateRandomInteger(algorithmParameters.getMinInitialCreatureSize(),
              algorithmParameters.getMaxInitialCreatureSize()) + RandomNumberGenerator.generateRandomInteger(-3, 3);
    }

    probability = RandomNumberGenerator.generateRandomDouble(0.0, 1.0);

    if (probability <= mutationRate) {
      this.visionPixels = RandomNumberGenerator.generateRandomInteger(algorithmParameters.getMinVisionPixels(),
              algorithmParameters.getMaxVisionPixels()) + RandomNumberGenerator.generateRandomInteger(-15, 15);
    }

    probability = RandomNumberGenerator.generateRandomDouble(0.0, 1.0);

    if (probability <= mutationRate) {
      this.reproductionCoolDownTicks = RandomNumberGenerator.generateRandomInteger(algorithmParameters.getMinReproductionCoolDown(),
              algorithmParameters.getMaxReproductionCoolDown()) + RandomNumberGenerator.generateRandomInteger(-5, 5);
    }

    probability = RandomNumberGenerator.generateRandomDouble(0.0, 1.0);

    if (probability <= mutationRate) {
      this.reproductionRequiredFoodCount = RandomNumberGenerator.generateRandomInteger(algorithmParameters.getMinRequiredMatingFoodCount(),
              algorithmParameters.getMaxRequiredMatingFoodCount()) + RandomNumberGenerator.generateRandomInteger(-3, 3);
    }

    probability = RandomNumberGenerator.generateRandomDouble(0.0, 1.0);

    if (probability <= mutationRate) {
      this.reproductionRequiredAgeTicks = RandomNumberGenerator.generateRandomInteger(algorithmParameters.getMinRequiredMatingAgeSeconds(),
              algorithmParameters.getMaxRequiredMatingAgeSeconds()) + RandomNumberGenerator.generateRandomInteger(-5, 5);
    }
  }
}
