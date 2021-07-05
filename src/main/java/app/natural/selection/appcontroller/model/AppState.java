package app.natural.selection.appcontroller.model;

import app.natural.selection.algorithm.configuration.AlgorithmConfiguration;
import app.natural.selection.algorithm.configuration.AlgorithmParameters;
import app.natural.selection.appcontroller.logger.AppLogger;
import app.natural.selection.common.model.food.FoodHolder;
import app.natural.selection.common.model.population.Population;
import app.natural.selection.view.common.configuration.ViewConfiguration;

public class AppState {

    private final Population population;

    private final FoodHolder foodHolder;

    private final Statistic statistic;

    private final AlgorithmParameters algorithmParameters;

    private final AlgorithmConfiguration algorithmConfiguration;

    private final ViewConfiguration viewConfiguration;

    private Long totalTicks;

    private Long lastTickGeneratingFood;


    public AppState() {
        this.totalTicks = 0L;
        this.lastTickGeneratingFood = 0L;
        this.viewConfiguration = new ViewConfiguration();
        this.algorithmParameters = new AlgorithmParameters(viewConfiguration.getCanvasHeight(), viewConfiguration.getCanvasWidth());
        this.algorithmConfiguration = new AlgorithmConfiguration();
        this.statistic = new Statistic();
        this.population = new Population(this.algorithmParameters);
        this.foodHolder = new FoodHolder(this.algorithmParameters);
    }

    // Generates food only if it's the right time to do so using simulationConfiguration.foodFrequency
    public void generateFood() {
        long durationSinceLastFood = totalTicks - lastTickGeneratingFood;
        if (durationSinceLastFood == algorithmParameters.getFoodFrequencyTicks()) {
            foodHolder.generateFood(algorithmParameters);
            lastTickGeneratingFood = totalTicks;
            AppLogger.logMessage("Generating food for tick: " + totalTicks);
        }

    }

    public Population getPopulation() {
        return population;
    }

    public AlgorithmParameters getAlgorithmParameters() {
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

    public Long getTotalTicks() {
        return totalTicks;
    }

    public void incrementTickCount() {
        this.totalTicks++;
    }

    public Long getCurrentTickCount() {
        return totalTicks;
    }
}
