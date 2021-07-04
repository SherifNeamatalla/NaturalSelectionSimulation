package app.natural.selection.common.model;

import app.natural.selection.common.util.RandomNumberGenerator;
import app.natural.selection.simulation.config.SimulationConfiguration;

public class Position {

  private Double x;

  private Double y;

  public Position(SimulationConfiguration simulationConfiguration) {
    this.x =
        RandomNumberGenerator.generateRandomDouble(0.0, simulationConfiguration.getMaxXPosition());
    this.y =
        RandomNumberGenerator.generateRandomDouble(0.0, simulationConfiguration.getMaxYPosition());
  }

  public Double getX() {
    return x;
  }

  public void setX(Double x) {
    this.x = x;
  }

  public Double getY() {
    return y;
  }

  public void setY(Double y) {
    this.y = y;
  }
}
