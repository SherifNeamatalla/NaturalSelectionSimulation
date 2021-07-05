package app.natural.selection.view.common.configuration;

public class ViewConfiguration {

  private final Integer screenWidth;

  private final Integer screenHeight;

  private final Integer canvasHeight;

  private final Integer canvasWidth;

  public ViewConfiguration() {
    screenWidth = ViewConstants.DEFAULT_SCREEN_WIDTH;
    screenHeight = ViewConstants.DEFAULT_SCREEN_HEIGHT;
    canvasHeight = ViewConstants.DEFAULT_CANVAS_HEIGHT;
    canvasWidth = ViewConstants.DEFAULT_CANVAS_WIDTH;
  }

  public Integer getScreenWidth() {
    return screenWidth;
  }


  public Integer getScreenHeight() {
    return screenHeight;
  }


  public Integer getCanvasHeight() {
    return canvasHeight;
  }


  public Integer getCanvasWidth() {
    return canvasWidth;
  }

}
