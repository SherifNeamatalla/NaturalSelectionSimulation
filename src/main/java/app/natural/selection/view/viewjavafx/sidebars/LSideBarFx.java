package app.natural.selection.view.viewjavafx.sidebars;

import app.natural.selection.appcontroller.model.AppState;
import app.natural.selection.view.viewjavafx.components.LSideBarSingleLine;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import static app.natural.selection.view.viewjavafx.components.ComponentsFactory.createSingleLabel;

public class LSideBarFx extends VBox {

    private LSideBarSingleLine pixelsPerTickStatisticEntry;
    private LSideBarSingleLine sizePixelsStatisticEntry;
    private LSideBarSingleLine energyDecayPerTickStatisticEntry;
    private LSideBarSingleLine visionPixelsStatisticEntry;
    private LSideBarSingleLine reproductionCoolDownSecondsStatisticEntry;
    private LSideBarSingleLine reproductionRequiredAgeStatisticEntry;
    private LSideBarSingleLine reproductionRequiredFoodCountStatisticEntry;


    public LSideBarFx() {
        setBackground(
                new Background(new BackgroundFill(Color.rgb(11, 57, 84), CornerRadii.EMPTY, Insets.EMPTY)));
        setPrefSize(500, 300);
        addTitleLabels();
        addLines();
        setVisible(true);
    }

    private void addLines() {
        pixelsPerTickStatisticEntry = new LSideBarSingleLine("Speed(P/S)");
        sizePixelsStatisticEntry = new LSideBarSingleLine("Size(P)");
        energyDecayPerTickStatisticEntry = new LSideBarSingleLine("EnergyDec(U/S)");
        visionPixelsStatisticEntry = new LSideBarSingleLine("Vision(P)");
        reproductionCoolDownSecondsStatisticEntry = new LSideBarSingleLine("Rep.CD(S)");
        reproductionRequiredAgeStatisticEntry = new LSideBarSingleLine("Rep.Age(S)");
        reproductionRequiredFoodCountStatisticEntry = new LSideBarSingleLine("Rep.Food(U)");

        getChildren().addAll(pixelsPerTickStatisticEntry, sizePixelsStatisticEntry, energyDecayPerTickStatisticEntry,
                visionPixelsStatisticEntry, reproductionCoolDownSecondsStatisticEntry, reproductionRequiredAgeStatisticEntry,
                reproductionRequiredFoodCountStatisticEntry);

    }


    private void addTitleLabels() {
        HBox horizontalTitleBox = new HBox();

        horizontalTitleBox.setSpacing(25);

        Label paddingLabel = createSingleLabel("");
        Label minLabel = createSingleLabel("Min");
        Label avgLabel = createSingleLabel("Avg");
        Label maxLabel = createSingleLabel("Max");

        horizontalTitleBox.getChildren().addAll(paddingLabel, minLabel, avgLabel, maxLabel);

        getChildren().add(horizontalTitleBox);
    }

    public void draw(AppState appState) {
        if (appState == null) return;

        pixelsPerTickStatisticEntry.updateValues(appState.getStatistic().getPixelsPerTickStatisticEntry());
        sizePixelsStatisticEntry.updateValues(appState.getStatistic().getSizePixelsStatisticEntry());
        energyDecayPerTickStatisticEntry.updateValues(appState.getStatistic().getEnergyDecayPerTickStatisticEntry());
        visionPixelsStatisticEntry.updateValues(appState.getStatistic().getVisionPixelsStatisticEntry());
        reproductionCoolDownSecondsStatisticEntry.updateValues(appState.getStatistic().getReproductionCoolDownSecondsStatisticEntry());
        reproductionRequiredAgeStatisticEntry.updateValues(appState.getStatistic().getReproductionRequiredAgeStatisticEntry());
        reproductionRequiredFoodCountStatisticEntry.updateValues(appState.getStatistic().getReproductionRequiredFoodCountStatisticEntry());


    }
}
