package app.natural.selection.common.model.position;

import app.natural.selection.common.util.RandomNumberGenerator;
import app.natural.selection.algorithm.configuration.AlgorithmParameters;

public class Position {

  private Double x;

  private Double y;

  public Position(Position position) {
    this.x = position.getX();
    this.y = position.getY();
  }

  public Position(AlgorithmParameters algorithmParameters) {
    this.x =
            RandomNumberGenerator.generateRandomDouble(0.0, algorithmParameters.getCanvasWidth().doubleValue());
    this.y =
            RandomNumberGenerator.generateRandomDouble(0.0, algorithmParameters.getCanvasHeight().doubleValue());
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
