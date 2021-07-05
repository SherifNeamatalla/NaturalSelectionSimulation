package app.natural.selection.appcontroller.configuration;

public class AppSettings {

    private Long tickSnapshotCount;

    private Boolean showCreatureData;

    public AppSettings() {

        this.tickSnapshotCount = AppSettingsConstants.DEFAULT_TICK_SNAPSHOT_COUNT;
        this.showCreatureData = AppSettingsConstants.DEFAULT_SHOW_CREATURE_DATA;
    }

    public Long getTickSnapshotCount() {
        return tickSnapshotCount;
    }

    public void setTickSnapshotCount(Long tickSnapshotCount) {
        this.tickSnapshotCount = tickSnapshotCount;
    }

    public Boolean getShowCreatureData() {
        return showCreatureData;
    }

    public void setShowCreatureData(Boolean showCreatureData) {
        this.showCreatureData = showCreatureData;
    }
}
