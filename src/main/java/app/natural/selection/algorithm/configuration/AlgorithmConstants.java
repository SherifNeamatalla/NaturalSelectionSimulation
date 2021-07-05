package app.natural.selection.algorithm.configuration;

public class AlgorithmConstants {

  public static final Double DEFAULT_MUTATION_RATE = 0.1;

  public static final AlgorithmMutationControllerType DEFAULT_MUTATION_CONTROLLER_TYPE =
          AlgorithmMutationControllerType.DEFAULT;

  public static final AlgorithmReproductionControllerType DEFAULT_REPRODUCTION_CONTROLLER_TYPE =
          AlgorithmReproductionControllerType.DEFAULT;


  public static final Integer DEFAULT_TICKS_PER_SECOND = 60;
  public static final Integer DEFAULT_STARTING_POPULATION_COUNT = 5;

  public static final Integer DEFAULT_FOOD_FREQUENCY_TICKS = 100;
  public static final Integer DEFAULT_FOOD_COUNT = 100;

  public static final Double DEFAULT_MAX_X_POSITION = 1024.0;
  public static final Double DEFAULT_MAX_Y_POSITION = 1024.0;

  public static final Integer DEFAULT_CREATURE_STARTING_ENERGY = 100;

  public static final Double DEFAULT_MIN_FOOD_NUTRITION_VALUE = 1.0;
  public static final Double DEFAULT_MAX_FOOD_NUTRITION_VALUE = 5.0;

  public static final Integer DEFAULT_MIN_VISION_PIXELS = 50;
  public static final Integer DEFAULT_MAX_VISION_PIXELS = 150;
  public static final Double DEFAULT_MIN_ENERGY_DECAY_PER_TICK = 10.0 / 60;
  public static final Double DEFAULT_MAX_ENERGY_DECAY_PER_TICK = 30.0 / 60;
  public static final Integer DEFAULT_MIN_INITIAL_CREATURE_SIZE = 10;
  public static final Integer DEFAULT_MAX_INITIAL_CREATURE_SIZE = 15;
  public static final Double DEFAULT_MIN_SPEED_PIXELS = 10.0;
  public static final Double DEFAULT_MAX_SPEED_PIXELS = 40.0;

  public static final Integer DEFAULT_MIN_REQUIRED_MATING_FOOD_COUNT = 5;
  public static final Integer DEFAULT_MAX_REQUIRED_MATING_FOOD_COUNT = 20;
  public static final Integer DEFAULT_MIN_REQUIRED_MATING_AGE_SECONDS = 5;
  public static final Integer DEFAULT_MAX_REQUIRED_MATING_AGE_SECONDS = 25;
  public static final Integer DEFAULT_MIN_REPRODUCTION_COOL_DOWN_SECONDS = 10;
  public static final Integer DEFAULT_MAX_REPRODUCTION_COOL_DOWN_SECONDS = 45;
}
