package app.natural.selection.appcontroller.model;

import app.natural.selection.algorithm.configuration.AlgorithmConfiguration;
import app.natural.selection.common.model.food.FoodHolder;
import app.natural.selection.common.model.generation.Generation;
import app.natural.selection.simulation.config.SimulationConfiguration;
import app.natural.selection.view.common.configuration.ViewConfiguration;

import java.time.Duration;
import java.time.LocalDateTime;

public class AppState {

  private final LocalDateTime startingDateTime;


  private final Generation generation;

  private final FoodHolder foodHolder;

  private final Statistic statistic;

  private final SimulationConfiguration simulationConfiguration;

  private final AlgorithmConfiguration algorithmConfiguration;

  private final ViewConfiguration viewConfiguration;

  private LocalDateTime lastTimeGeneratingFood;


  public AppState() {
    this.startingDateTime = LocalDateTime.now();
    this.lastTimeGeneratingFood = LocalDateTime.now();
    this.viewConfiguration = new ViewConfiguration();
    this.simulationConfiguration = new SimulationConfiguration(viewConfiguration.getCanvasHeight(), viewConfiguration.getCanvasWidth());
    this.algorithmConfiguration = new AlgorithmConfiguration();
    this.statistic = new Statistic();
    this.generation = new Generation(this.simulationConfiguration);
    this.foodHolder = new FoodHolder(this.simulationConfiguration);
  }

  // Generates food only if it's the right time to do so using simulationConfiguration.foodFrequency
  public void generateFood() {
    Long durationSinceLastFood = Math.abs(Duration.between(lastTimeGeneratingFood, LocalDateTime.now()).getSeconds());

    if (durationSinceLastFood > simulationConfiguration.getFoodFrequencySeconds()) {
      foodHolder.generateFood(simulationConfiguration);
      lastTimeGeneratingFood = LocalDateTime.now();
    }

  }

  public Generation getGeneration() {
    return generation;
  }

  public SimulationConfiguration getSimulationConfiguration() {
    return simulationConfiguration;
  }

  public AlgorithmConfiguration getAlgorithmConfiguration() {
    return algorithmConfiguration;
  }

  public ViewConfiguration getViewConfiguration() {
    return viewConfiguration;
  }

  public Statistic getStatistic() {
    return statistic;
  }

  public FoodHolder getFoodHolder() {
    return foodHolder;
  }

  public LocalDateTime getStartingDateTime() {
    return startingDateTime;
  }
}
