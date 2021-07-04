package app.natural.selection.simulation.controller.javafx;

import app.natural.selection.appcontroller.AppController;
import app.natural.selection.simulation.config.SimulationConfiguration;
import app.natural.selection.simulation.controller.interfaces.ISimulationControllerLogicHandler;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class SimulationControllerLogicHandlerFx implements ISimulationControllerLogicHandler {
  private Timeline timeline;

  private final AppController appController;
  private final SimulationConfiguration simulationConfiguration;

  public SimulationControllerLogicHandlerFx(
      AppController appController, SimulationConfiguration simulationConfiguration) {
    this.appController = appController;
    this.simulationConfiguration = simulationConfiguration;
    initKeyframes();
  }

  private void initKeyframes() {
    KeyFrame keyFrame =
        new KeyFrame(
            Duration.millis(simulationConfiguration.getTickPerSecond()),
            actionEvent -> {
              this.appController.onTick();
            });

    this.timeline = new Timeline(keyFrame);
    this.timeline.setCycleCount(Animation.INDEFINITE);
  }

  @Override
  public void startSimulation() {
    this.timeline.play();
  }

  @Override
  public void pauseSimulation() {
    this.timeline.pause();
  }

  @Override
  public void stopSimulation() {
    this.timeline.stop();
  }

  @Override
  public void increaseSimulationSpeed() {
    // TODO
  }

  @Override
  public void decreaseSimulationSpeed() {
    // TODO
  }
}
