package app.natural.selection.appcontroller.model;

import app.natural.selection.algorithm.configuration.AlgorithmConfiguration;
import app.natural.selection.common.model.food.FoodHolder;
import app.natural.selection.common.model.generation.Generation;
import app.natural.selection.simulation.config.SimulationConfiguration;
import app.natural.selection.view.configuration.ViewConfiguration;

import java.time.LocalDateTime;

public class AppState {

  private final LocalDateTime startingDateTime;

  private final Generation generation;

  private final FoodHolder foodHolder;

  private final Statistic statistic;

  private final SimulationConfiguration simulationConfiguration;

  private final AlgorithmConfiguration algorithmConfiguration;

  private final ViewConfiguration viewConfiguration;

  public AppState() {
    this.startingDateTime = LocalDateTime.now();
    this.simulationConfiguration = new SimulationConfiguration();
    this.algorithmConfiguration = new AlgorithmConfiguration();
    this.viewConfiguration = new ViewConfiguration();
    this.statistic = new Statistic();
    this.generation = new Generation(this.simulationConfiguration);
    this.foodHolder = new FoodHolder(this.simulationConfiguration);
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
