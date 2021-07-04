package app.natural.selection.view.configuration;

public class ViewConfiguration {

  private Integer screenWidth;

  private Integer screenHeight;

  public ViewConfiguration(Integer screenWidth, Integer screenHeight) {
    this.screenWidth = screenWidth;
    this.screenHeight = screenHeight;
  }

  public ViewConfiguration() {
    screenWidth = ViewConstants.DEFAULT_SCREEN_WIDTH;
    screenHeight = ViewConstants.DEFAULT_SCREEN_HEIGHT;
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
}
