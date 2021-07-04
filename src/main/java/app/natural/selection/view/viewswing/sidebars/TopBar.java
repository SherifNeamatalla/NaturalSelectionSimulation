package app.natural.selection.view.viewswing.sidebars;

import app.natural.selection.view.common.controller.ViewController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TopBar extends JToolBar {
  private static final String START_TEXT = "Start";

  private static final String STOP_TEXT = "Stop";

  private static final String PAUSE_TEXT = "Pause";

  private static final String SAVE_TEXT = "Save";

  private static final String LOAD_TEXT = "Load";

  private static final String DECREASE_SPEED_TEXT = "Slower";

  private static final String INCREASE_SPEED_TEXT = "Faster";

  public TopBar(ViewController viewController) {
    setBackground(new Color(11, 57, 84));
    addButtons(viewController);
    setVisible(true);
  }

  private void addButtons(ViewController viewController) {
    add(startButton(viewController));
    addSeparator();
    add(pauseButton(viewController));
    add(stopButton(viewController));
    addSeparator();
    add(decreaseSpeedButton(viewController));
    add(increaseSpeedButton(viewController));
    addSeparator();
    addSeparator();
    add(saveButton(viewController));
  }

  private Button initButton(String text, ActionListener actionListener) {
    Button button = new Button(text);

    button.setSize(250, 250);

    button.setForeground(Color.WHITE);

    button.addActionListener(actionListener);

    return button;
  }

  private Button startButton(ViewController viewController) {
    return initButton(
        START_TEXT,
        (actionEvent) -> {
          viewController.handleStartEvent();
        });
  }

  private Button pauseButton(ViewController viewController) {
    return initButton(
        PAUSE_TEXT,
        (actionEvent) -> {
          viewController.handlePauseEvent();
        });
  }

  private Button stopButton(ViewController viewController) {
    return initButton(
        STOP_TEXT,
        (actionEvent) -> {
          viewController.handleStopEvent();
        });
  }

  private Button saveButton(ViewController viewController) {
    return initButton(
        SAVE_TEXT,
        (actionEvent) -> {
          viewController.handleSaveEvent();
        });
  }

  private Button increaseSpeedButton(ViewController viewController) {
    return initButton(
        INCREASE_SPEED_TEXT,
        (actionEvent) -> {
          viewController.handleIncreaseSpeedEvent();
        });
  }

  private Button decreaseSpeedButton(ViewController viewController) {
    return initButton(
        DECREASE_SPEED_TEXT,
        (actionEvent) -> {
          viewController.handleDecreaseSpeedEvent();
        });
  }
}
