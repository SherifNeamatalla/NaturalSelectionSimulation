package app.natural.selection.appcontroller.model;

import app.natural.selection.algorithm.configuration.AlgorithmConfiguration;
import app.natural.selection.algorithm.configuration.AlgorithmParameters;
import app.natural.selection.appcontroller.configuration.AppSettings;
import app.natural.selection.appcontroller.logger.AppLogger;
import app.natural.selection.common.model.food.FoodHolder;
import app.natural.selection.common.model.population.Population;
import app.natural.selection.view.common.configuration.ViewConfiguration;

import java.util.ArrayList;
import java.util.List;

public class AppState {

    private final Population population;

    private final FoodHolder foodHolder;

    private final Statistic statistic;

    private final AlgorithmParameters algorithmParameters;

    private final AlgorithmConfiguration algorithmConfiguration;

    private final ViewConfiguration viewConfiguration;

    private final List<Statistic> snapshotStatistics;

    private Long totalTicks;

    private Long lastTickGeneratingFood;

    private AppSettings appSettings;


    public AppState() {
        this.totalTicks = 0L;
        this.lastTickGeneratingFood = 0L;
        this.viewConfiguration = new ViewConfiguration();
        this.algorithmParameters = new AlgorithmParameters(viewConfiguration.getCanvasHeight(), viewConfiguration.getCanvasWidth());
        this.algorithmConfiguration = new AlgorithmConfiguration();
        this.appSettings = new AppSettings();
        this.statistic = new Statistic();
        this.population = new Population(this.algorithmParameters);
        this.foodHolder = new FoodHolder(this.algorithmParameters);
        this.snapshotStatistics = new ArrayList<>();
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

    public void tick() {
        this.totalTicks++;

        if (totalTicks % appSettings.getTickSnapshotCount() == 0) {
            AppLogger.logMessage("Taking snapshot at tick: " + totalTicks);
            this.snapshotStatistics.add(statistic.createCopy());
        }
    }

    public Long getCurrentTickCount() {
        return totalTicks;
    }

    public AppSettings getAppSettings() {
        return appSettings;
    }

    public List<Statistic> getSnapshotStatistics() {
        return snapshotStatistics;
    }
}
