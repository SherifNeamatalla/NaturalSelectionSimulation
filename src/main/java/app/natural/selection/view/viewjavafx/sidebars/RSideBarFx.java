package app.natural.selection.view.viewjavafx.sidebars;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class RSideBarFx extends VBox {

    public RSideBarFx() {
        setBackground(
                new Background(new BackgroundFill(Color.rgb(11, 57, 84), CornerRadii.EMPTY, Insets.EMPTY)));
        setVisible(true);
    }
}
