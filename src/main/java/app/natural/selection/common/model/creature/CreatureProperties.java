package app.natural.selection.common.model.creature;

import app.natural.selection.common.util.RandomNumberGenerator;
import app.natural.selection.simulation.config.SimulationConfiguration;

public class CreatureProperties {

  private Double pixelsPerTick;

  private Integer sizePixels;

  private Double energyDecayPerTick;

  private Integer visionPixels;

  public CreatureProperties(SimulationConfiguration simulationConfiguration) {
    this.pixelsPerTick =
        RandomNumberGenerator.generateRandomDouble(
            simulationConfiguration.getMinSpeedPixels(),
            simulationConfiguration.getMaxSpeedPixels());

    this.sizePixels =
        RandomNumberGenerator.generateRandomInteger(
            simulationConfiguration.getMinInitialCreatureSize(),
            simulationConfiguration.getMaxInitialCreatureSize());

    this.energyDecayPerTick =
        RandomNumberGenerator.generateRandomDouble(
            simulationConfiguration.getMinEnergyDecayPerTick(),
            simulationConfiguration.getMaxEnergyDecayPerTick());

    this.visionPixels =
        RandomNumberGenerator.generateRandomInteger(
            simulationConfiguration.getMinVisionPixels(),
            simulationConfiguration.getMaxVisionPixels());
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
}
