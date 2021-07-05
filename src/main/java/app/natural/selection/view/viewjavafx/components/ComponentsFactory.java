package app.natural.selection.view.viewjavafx.components;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ComponentsFactory {

  public static Label createSingleLabel(String text) {
    Label label = new Label(text);
    label.setStyle("-fx-text-fill:white");
    label.setPrefSize(100, 10);
    return label;
  }

  public static TextField createSingleTextField() {
    TextField textField = new TextField("No Value");
    textField.setStyle("-fx-text-fill: white;-fx-background-color: #20A39E;");
    textField.setPrefSize(100, 10);
    textField.setEditable(false);
    return textField;
  }
}
