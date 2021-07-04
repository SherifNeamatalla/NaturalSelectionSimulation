package app.natural.selection.common.util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberGenerator {

  public static Integer generateRandomInteger(Integer min, Integer max) {
    return ThreadLocalRandom.current().nextInt(min, max);
  }

  public static Double generateRandomDouble(Double min, Double max) {
    return ThreadLocalRandom.current().nextDouble(min, max);
  }
}
