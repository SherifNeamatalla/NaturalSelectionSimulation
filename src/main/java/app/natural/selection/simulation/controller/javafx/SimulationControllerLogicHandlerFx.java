package app.natural.selection.simulation.controller.javafx;

import app.natural.selection.appcontroller.AppController;
import app.natural.selection.algorithm.configuration.AlgorithmParameters;
import app.natural.selection.simulation.controller.interfaces.ISimulationControllerLogicHandler;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class SimulationControllerLogicHandlerFx implements ISimulationControllerLogicHandler {
  private Timeline timeline;

  private final AppController appController;
  private final AlgorithmParameters algorithmParameters;
  private Integer currentSpeed = 1;

  public SimulationControllerLogicHandlerFx(
      AppController appController, AlgorithmParameters algorithmParameters) {
    this.appController = appController;
    this.algorithmParameters = algorithmParameters;
    initKeyframes();
  }

  private void initKeyframes() {
    KeyFrame keyFrame =
            createKeyFrame();

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
    this.timeline.stop();
    currentSpeed *= 2;
    initKeyframes();
    startSimulation();
  }

  @Override
  public void decreaseSimulationSpeed() {
    if (currentSpeed != 1) {
      this.timeline.stop();
      currentSpeed /= 2;
      initKeyframes();
      startSimulation();
    }
  }

  @Override
  public int getCurrentSimulationSpeed() {
    return currentSpeed;
  }

  private KeyFrame createKeyFrame() {
    return
            new KeyFrame(
                    Duration.millis(algorithmParameters.getTickPerSecond() / currentSpeed),
                    actionEvent -> {
                      this.appController.onTick();
                    });
  }
}
