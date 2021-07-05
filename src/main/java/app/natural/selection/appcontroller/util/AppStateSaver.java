package app.natural.selection.appcontroller.util;

import app.natural.selection.appcontroller.model.AppState;

import static app.natural.selection.filecreators.jfreechart.JFreeChartHistogramCreator.createHistogramForStatisticList;

public class AppStateSaver {
    public static void saveAppState(AppState appState) {
        saveRawText(appState);
    }

    private static void saveRawText(AppState appState) {
        createHistogramForStatisticList(appState.getSnapshotStatistics());

    }
}
