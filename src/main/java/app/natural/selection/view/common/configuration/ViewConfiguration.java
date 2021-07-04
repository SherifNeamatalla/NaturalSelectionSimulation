package app.natural.selection.view.common.configuration;

public class ViewConfiguration {

  private Integer screenWidth;

  private Integer screenHeight;

  private Integer canvasHeight;

  private Integer canvasWidth;

  public ViewConfiguration(Integer screenWidth, Integer screenHeight, Integer canvasHeight, Integer canvasWidth) {
    this.screenWidth = screenWidth;
    this.screenHeight = screenHeight;
    this.canvasHeight = canvasHeight;
    this.canvasWidth = canvasWidth;
  }

  public ViewConfiguration() {
    screenWidth = ViewConstants.DEFAULT_SCREEN_WIDTH;
    screenHeight = ViewConstants.DEFAULT_SCREEN_HEIGHT;
    canvasHeight = ViewConstants.DEFAULT_CANVAS_HEIGHT;
    canvasWidth = ViewConstants.DEFAULT_CANVAS_WIDTH;
  }

  public Integer getScreenWidth() {
    return screenWidth;
  }

  public void setScreenWidth(Integer screenWidth) {
    this.screenWidth = screenWidth;
  }

  public Integer getScreenHeight() {
    return screenHeight;
  }

  public void setScreenHeight(Integer screenHeight) {
    this.screenHeight = screenHeight;
  }

  public Integer getCanvasHeight() {
    return canvasHeight;
  }

  public void setCanvasHeight(Integer canvasHeight) {
    this.canvasHeight = canvasHeight;
  }

  public Integer getCanvasWidth() {
    return canvasWidth;
  }

  public void setCanvasWidth(Integer canvasWidth) {
    this.canvasWidth = canvasWidth;
  }
}
