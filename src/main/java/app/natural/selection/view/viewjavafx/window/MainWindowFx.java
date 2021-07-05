package app.natural.selection.view.viewjavafx.window;

import app.natural.selection.appcontroller.model.AppState;
import app.natural.selection.view.common.configuration.ViewConfiguration;
import app.natural.selection.view.common.controller.ViewController;
import app.natural.selection.view.common.interfaces.IMainWindow;
import app.natural.selection.view.viewjavafx.canvas.CanvasFx;
import app.natural.selection.view.viewjavafx.sidebars.BottomBarFx;
import app.natural.selection.view.viewjavafx.sidebars.LSideBarFx;
import app.natural.selection.view.viewjavafx.sidebars.RSideBarFx;
import app.natural.selection.view.viewjavafx.sidebars.TopBarFx;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainWindowFx extends BorderPane implements IMainWindow {

  private final ViewConfiguration viewConfiguration;

  private final ViewController viewController;

  private final Stage primaryStage;

  private TopBarFx topBar;

  private BottomBarFx bottomBar;

  private RSideBarFx rSideBar;

  private LSideBarFx lSideBar;

  private CanvasFx canvas;

  public MainWindowFx(
      ViewController viewController, ViewConfiguration viewConfiguration, Stage primaryStage) {
    this.viewConfiguration = viewConfiguration;
    this.viewController = viewController;
    this.primaryStage = primaryStage;

    primaryStage.setWidth(viewConfiguration.getScreenWidth());
    primaryStage.setHeight(viewConfiguration.getScreenHeight());

    primaryStage.setTitle("Genetic Evolution");
    primaryStage.setScene(new Scene(this, 300, 275));
    init();
  }

  private void init() {
    initCanvas();
    initToolbars();
  }

  private void initCanvas() {
    canvas = new CanvasFx(viewConfiguration.getCanvasWidth(), viewConfiguration.getCanvasHeight());
    setCenter(canvas);
  }

  private void initToolbars() {
    topBar = new TopBarFx(viewController);
    bottomBar = new BottomBarFx();
    rSideBar = new RSideBarFx();
    lSideBar = new LSideBarFx();

    setTop(topBar);
    setBottom(bottomBar);
    setRight(rSideBar);
    setLeft(lSideBar);
  }

  @Override
  public void draw(AppState appState) {
    canvas.draw(appState);
    lSideBar.draw(appState);
    bottomBar.draw(appState);
    topBar.draw(appState);
    rSideBar.draw(appState);

  }

  @Override
  public void display() {
    primaryStage.show();
  }
}
