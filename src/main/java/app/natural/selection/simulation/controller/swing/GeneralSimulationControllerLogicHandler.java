package app.natural.selection.simulation.controller.swing;

import app.natural.selection.appcontroller.AppController;
import app.natural.selection.appcontroller.logger.AppLogger;
import app.natural.selection.simulation.controller.interfaces.ISimulationControllerLogicHandler;

public class GeneralSimulationControllerLogicHandler implements ISimulationControllerLogicHandler {

  private final AppController appController;
  private final Thread gameLoopThread;
  private final GameLoopRunnable gameLoopRunnable;

  public GeneralSimulationControllerLogicHandler(AppController appController) {
    this.appController = appController;
    this.gameLoopRunnable = new GameLoopRunnable(this::tick);
    this.gameLoopThread = new Thread(this.gameLoopRunnable);
  }

  /** Listeners to outside events */
  public void startSimulation() {
    if (gameLoopRunnable.isPaused) {
      gameLoopRunnable.unpause();
      System.out.println("Unpausing");
    } else if (!gameLoopThread.isAlive()) {
      gameLoopThread.start();
    } else {
      AppLogger.logMessage("Ignoring double start");
    }
  }

  public void pauseSimulation() {
    AppLogger.logMessage("Pausing");
    gameLoopRunnable.pause();
  }

  public void stopSimulation() {
    gameLoopRunnable.pause();
  }

  public void increaseSimulationSpeed() {}

  public void decreaseSimulationSpeed() {}

  /** Event emitters */
  private void tick() {
    appController.onTick();
  }
}
