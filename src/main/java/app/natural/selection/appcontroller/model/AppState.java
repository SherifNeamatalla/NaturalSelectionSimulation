package app.natural.selection.appcontroller.model;

import app.natural.selection.algorithm.configuration.AlgorithmConfiguration;
import app.natural.selection.algorithm.configuration.AlgorithmParameters;
import app.natural.selection.common.model.food.FoodHolder;
import app.natural.selection.common.model.population.Population;
import app.natural.selection.view.common.configuration.ViewConfiguration;

import java.time.Duration;
import java.time.LocalDateTime;

public class AppState {

    private final LocalDateTime startingDateTime;


    private final Population population;

    private final FoodHolder foodHolder;

    private final Statistic statistic;

    private final AlgorithmParameters algorithmParameters;

    private final AlgorithmConfiguration algorithmConfiguration;

    private final ViewConfiguration viewConfiguration;

    private LocalDateTime lastTimeGeneratingFood;


    public AppState() {
        this.startingDateTime = LocalDateTime.now();
        this.lastTimeGeneratingFood = LocalDateTime.now();
        this.viewConfiguration = new ViewConfiguration();
        this.algorithmParameters = new AlgorithmParameters(viewConfiguration.getCanvasHeight(), viewConfiguration.getCanvasWidth());
        this.algorithmConfiguration = new AlgorithmConfiguration();
        this.statistic = new Statistic();
        this.population = new Population(this.algorithmParameters);
        this.foodHolder = new FoodHolder(this.algorithmParameters);
    }

    // Generates food only if it's the right time to do so using simulationConfiguration.foodFrequency
    public void generateFood() {
        long durationSinceLastFood = Math.abs(Duration.between(lastTimeGeneratingFood, LocalDateTime.now()).getSeconds());

        if (durationSinceLastFood > algorithmParameters.getFoodFrequencySeconds()) {
            foodHolder.generateFood(algorithmParameters);
            lastTimeGeneratingFood = LocalDateTime.now();
        }

    }

    public Population getPopulation() {
        return population;
    }

    public AlgorithmParameters getSimulationConfiguration() {
        return algorithmParameters;
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
