package app.natural.selection.view.viewjavafx.components;

import app.natural.selection.appcontroller.model.SingleStatisticEntry;
import app.natural.selection.common.model.creature.Creature;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class LSideBarSingleLine extends HBox {

  private Label label;
  private TextField minTextField;
  private TextField avgTextField;
  private TextField maxTextField;

  private Creature minCreature;
  private Creature maxCreature;

  public LSideBarSingleLine(String labelText) {
    setSpacing(25);
    setPrefSize(300, 300);
    createLabel(labelText);
    createTextFields();
  }

  private void createLabel(String labelText) {
    this.label = new Label(labelText);
    this.label.setStyle("-fx-text-fill: white");
    this.label.setPrefSize(100, 10);
    getChildren().add(label);
  }

  private TextField createSingleTextField() {
    TextField textField = new TextField("No Value");
    textField.setStyle("-fx-text-fill: white;-fx-background-color: #20A39E;");
    textField.setPrefSize(100, 10);
    textField.setEditable(false);
    return textField;
  }

  private void createTextFields() {
    minTextField = createSingleTextField();
    avgTextField = createSingleTextField();
    maxTextField = createSingleTextField();

    getChildren().addAll(minTextField, avgTextField, maxTextField);
  }

  public void updateValues(SingleStatisticEntry singleStatisticEntry) {
    minTextField.setText(singleStatisticEntry.getMinValue().toString());
    avgTextField.setText(singleStatisticEntry.getAvgValue().toString());
    maxTextField.setText(singleStatisticEntry.getMaxValue().toString());

    this.minCreature = singleStatisticEntry.getMinCreature();
    this.maxCreature = singleStatisticEntry.getMaxCreature();
  }
}
