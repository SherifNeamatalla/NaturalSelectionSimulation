package app.natural.selection.algorithm.util;

import app.natural.selection.common.model.Position;

public class DistanceCalculator {

  public static Double calculateDistance(Position position1, Position position2) {

    Double xDiff = position1.getX() - position2.getX();
    Double yDiff = position1.getY() - position2.getY();

    return Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));
  }
}
