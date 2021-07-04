package app.natural.selection.view.window;

import app.natural.selection.appcontroller.model.Statistic;
import app.natural.selection.common.model.food.FoodHolder;
import app.natural.selection.common.model.generation.Generation;
import app.natural.selection.view.canvas.Canvas;
import app.natural.selection.view.configuration.ViewConfiguration;
import app.natural.selection.view.controller.ViewController;
import app.natural.selection.view.sidebars.BottomBar;
import app.natural.selection.view.sidebars.LSideBar;
import app.natural.selection.view.sidebars.RSideBar;
import app.natural.selection.view.sidebars.TopBar;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

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

  public void draw(Generation generation, FoodHolder foodHolder, Statistic statistic) {
    canvas.draw(generation, foodHolder);
  }
}
