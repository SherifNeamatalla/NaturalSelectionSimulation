package app.natural.selection.view.viewjavafx.sidebars;

import app.natural.selection.appcontroller.model.AppState;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import static app.natural.selection.view.viewjavafx.components.ComponentsFactory.createSingleLabel;
import static app.natural.selection.view.viewjavafx.components.ComponentsFactory.createSingleTextField;

public class BottomBarFx extends HBox {

  private TextField currentCreaturesCountTextField;

  public BottomBarFx() {
    setBackground(
            new Background(new BackgroundFill(Color.rgb(11, 57, 84), CornerRadii.EMPTY, Insets.EMPTY)));
    addLabeledTextFields();
    setVisible(true);
  }


  private void addLabeledTextFields() {
    setSpacing(25);
    setAlignment(Pos.CENTER);
    Label currentCreaturesCountLabel = createSingleLabel("Population");
    currentCreaturesCountTextField = createSingleTextField();
    getChildren().addAll(currentCreaturesCountLabel, currentCreaturesCountTextField);
  }

  public void draw(AppState appState) {
    currentCreaturesCountTextField.setText(Integer.toString(appState.getGeneration().getCreatures().size()));
  }
}
