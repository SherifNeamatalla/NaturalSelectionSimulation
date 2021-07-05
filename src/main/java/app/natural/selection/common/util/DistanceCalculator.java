package app.natural.selection.common.util;

import app.natural.selection.common.model.position.Position;

public class DistanceCalculator {

  public static Double calculateDistance(Position position1, Position position2) {

    double xDiff = position1.getX() - position2.getX();
    double yDiff = position1.getY() - position2.getY();

    return Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));
  }
}
