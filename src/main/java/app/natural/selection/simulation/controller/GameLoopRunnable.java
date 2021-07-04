package app.natural.selection.simulation.controller;

public class GameLoopRunnable implements Runnable {

  public Boolean isPaused = false;

  private Long lastTime = System.nanoTime();

  private final SimulationTickLambda callbackFn;

  public GameLoopRunnable(SimulationTickLambda callbackFn) {
    this.callbackFn = callbackFn;
  }

  public void pause() {
    this.isPaused = true;
  }

  public void unpause() {
    lastTime = System.nanoTime();
    this.isPaused = false;
  }

  @Override
  public void run() {
    final double ns = 1000000000.0 / 1.0;
    double delta = 0;
    System.out.println("Am running");
    while (true) {
      if (isPaused) continue;
      long now = System.nanoTime();
      delta += (now - lastTime) / ns;
      lastTime = now;
      while (delta >= 1) {
        callbackFn.tick();
        delta--;
      }
    }
  }
}
