package app.natural.selection.view.viewjavafx.sidebars;

import app.natural.selection.appcontroller.model.AppState;
import app.natural.selection.view.common.controller.ViewController;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

import static app.natural.selection.view.viewjavafx.components.ComponentsFactory.createSingleLabel;
import static app.natural.selection.view.viewjavafx.components.ComponentsFactory.createSingleTextField;

public class TopBarFx extends ToolBar {

  private static final String START_TEXT = "Start";

  private static final String STOP_TEXT = "Stop";

  private static final String PAUSE_TEXT = "Pause";

  private static final String SAVE_TEXT = "Save";

  private static final String LOAD_TEXT = "Load";

  private static final String DECREASE_SPEED_TEXT = "Slower";

  private static final String INCREASE_SPEED_TEXT = "Faster";

  private TextField ticksPerSecondTextField;

  private TextField currentTickCountTextField;

  public TopBarFx(ViewController viewController) {
    setBackground(
            new Background(new BackgroundFill(Color.rgb(11, 57, 84), CornerRadii.EMPTY, Insets.EMPTY)));
    addButtons(viewController);
    addLabeledTextFields();
    setVisible(true);
  }

  private void addLabeledTextFields() {
    Label ticksPerSecondLabel = createSingleLabel("Current tick/second");
    ticksPerSecondLabel.setPrefWidth(200);
    getItems().add(ticksPerSecondLabel);

    ticksPerSecondTextField = createSingleTextField();
    getItems().add(ticksPerSecondTextField);


    Label currentTickCountLabel = createSingleLabel("Current tick count");
    currentTickCountLabel.setPrefWidth(200);
    getItems().add(currentTickCountLabel);

    currentTickCountTextField = createSingleTextField();
    getItems().add(currentTickCountTextField);
  }

  private void addButtons(ViewController viewController) {
    getItems().add(startButton(viewController));
    getItems().add(new Separator(Orientation.VERTICAL));
    getItems().add(pauseButton(viewController));
    getItems().add(stopButton(viewController));
    getItems().add(new Separator(Orientation.VERTICAL));
    getItems().add(decreaseSpeedButton(viewController));
    getItems().add(increaseSpeedButton(viewController));
    getItems().add(new Separator(Orientation.VERTICAL));
    getItems().add(new Separator(Orientation.VERTICAL));
    getItems().add(saveButton(viewController));
  }

  private Button initButton(String text, EventHandler<MouseEvent> eventHandler) {
    Button button = new Button(text);

    button.setPrefWidth(100);
    button.setMinWidth(100);
    button.setMaxWidth(100);
    button.setAlignment(Pos.CENTER);

    button.setPrefHeight(50);
    button.setMaxHeight(50);
    button.setMinHeight(50);

    button.setStyle(
        "-fx-text-fill:white; " + "-fx-background-color: #20A39E;-fx-border-color: black");

    button.setOnMouseClicked(eventHandler);

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

  public void draw(AppState appState) {
    currentTickCountTextField.setText(appState.getCurrentTickCount().toString());
    ticksPerSecondTextField.setText(appState.getAlgorithmParameters().getTickPerSecond().toString());
  }
}
