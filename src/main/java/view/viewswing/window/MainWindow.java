package view.viewswing.window;

import app.natural.selection.appcontroller.model.AppState;
import view.common.configuration.ViewConfiguration;
import view.common.controller.ViewController;
import view.common.interfaces.IMainWindow;
import view.viewswing.canvas.Canvas;
import view.viewswing.sidebars.BottomBar;
import view.viewswing.sidebars.LSideBar;
import view.viewswing.sidebars.RSideBar;
import view.viewswing.sidebars.TopBar;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame implements IMainWindow {

  private BorderLayout borderLayout;

  private TopBar topBar;

  private BottomBar bottomBar;

  private RSideBar rSideBar;

  private LSideBar lSideBar;

  private Canvas canvas;

  private final ViewConfiguration viewConfiguration;

  private final ViewController viewController;

  public MainWindow(ViewController viewController, ViewConfiguration viewConfiguration)
      throws HeadlessException {
    this.viewConfiguration = viewConfiguration;
    this.viewController = viewController;
    init();
  }

  public void display() {
    setVisible(true);
  }

  private void init() {
    initCanvas();
    initToolbars();
    initLayout();
    setLayout(borderLayout);
    setSize(viewConfiguration.getScreenWidth(), viewConfiguration.getScreenHeight());
  }

  private void initCanvas() {
    canvas = new Canvas();
  }

  private void initLayout() {
    borderLayout = new BorderLayout();
    borderLayout.addLayoutComponent(bottomBar, BorderLayout.SOUTH);
    borderLayout.addLayoutComponent(topBar, BorderLayout.NORTH);
    borderLayout.addLayoutComponent(lSideBar, BorderLayout.WEST);
    borderLayout.addLayoutComponent(rSideBar, BorderLayout.EAST);
    borderLayout.addLayoutComponent(canvas, BorderLayout.CENTER);

    add(topBar);
    add(bottomBar);
    add(lSideBar);
    add(rSideBar);
    add(canvas);
  }

  private void initToolbars() {
    topBar = new TopBar(viewController);
    bottomBar = new BottomBar();
    rSideBar = new RSideBar();
    lSideBar = new LSideBar();
  }

  public void draw(AppState appState) {
//    canvas.draw(null, null);
  }
}
