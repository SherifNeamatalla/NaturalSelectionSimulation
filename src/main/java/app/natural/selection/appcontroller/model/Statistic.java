package app.natural.selection.appcontroller.model;

public class Statistic {

    private SingleStatisticEntry<Double> pixelsPerTickStatisticEntry;
    private SingleStatisticEntry<Integer> sizePixelsStatisticEntry;
    private SingleStatisticEntry<Double> energyDecayPerTickStatisticEntry;
    private SingleStatisticEntry<Integer> visionPixelsStatisticEntry;
    private SingleStatisticEntry<Integer> reproductionCoolDownSecondsStatisticEntry;
    private SingleStatisticEntry<Integer> reproductionRequiredAgeStatisticEntry;
    private SingleStatisticEntry<Integer> reproductionRequiredFoodCountStatisticEntry;

    public Statistic() {
    }

    public void refreshValues(SingleStatisticEntry<Double> pixelsPerTickStatisticEntry,
                              SingleStatisticEntry<Double> energyDecayPerTickStatisticEntry,
                              SingleStatisticEntry<Integer> sizePixelsStatisticEntry,
                              SingleStatisticEntry<Integer> visionPixelsStatisticEntry,
                              SingleStatisticEntry<Integer> reproductionCoolDownSecondsStatisticEntry,
                              SingleStatisticEntry<Integer> reproductionRequiredAgeStatisticEntry,
                              SingleStatisticEntry<Integer> reproductionRequiredFoodCountStatisticEntry) {
        this.pixelsPerTickStatisticEntry = pixelsPerTickStatisticEntry;
        this.sizePixelsStatisticEntry = sizePixelsStatisticEntry;
        this.energyDecayPerTickStatisticEntry = energyDecayPerTickStatisticEntry;
        this.visionPixelsStatisticEntry = visionPixelsStatisticEntry;
        this.reproductionCoolDownSecondsStatisticEntry = reproductionCoolDownSecondsStatisticEntry;
        this.reproductionRequiredAgeStatisticEntry = reproductionRequiredAgeStatisticEntry;
        this.reproductionRequiredFoodCountStatisticEntry = reproductionRequiredFoodCountStatisticEntry;
    }

    public SingleStatisticEntry<Double> getPixelsPerTickStatisticEntry() {
        return pixelsPerTickStatisticEntry;
    }

    public void setPixelsPerTickStatisticEntry(SingleStatisticEntry<Double> pixelsPerTickStatisticEntry) {
        this.pixelsPerTickStatisticEntry = pixelsPerTickStatisticEntry;
    }

    public SingleStatisticEntry<Integer> getSizePixelsStatisticEntry() {
        return sizePixelsStatisticEntry;
    }

    public void setSizePixelsStatisticEntry(SingleStatisticEntry<Integer> sizePixelsStatisticEntry) {
        this.sizePixelsStatisticEntry = sizePixelsStatisticEntry;
    }

    public SingleStatisticEntry<Double> getEnergyDecayPerTickStatisticEntry() {
        return energyDecayPerTickStatisticEntry;
    }

    public void setEnergyDecayPerTickStatisticEntry(SingleStatisticEntry<Double> energyDecayPerTickStatisticEntry) {
        this.energyDecayPerTickStatisticEntry = energyDecayPerTickStatisticEntry;
    }

    public SingleStatisticEntry<Integer> getVisionPixelsStatisticEntry() {
        return visionPixelsStatisticEntry;
    }

    public void setVisionPixelsStatisticEntry(SingleStatisticEntry<Integer> visionPixelsStatisticEntry) {
        this.visionPixelsStatisticEntry = visionPixelsStatisticEntry;
    }

    public SingleStatisticEntry<Integer> getReproductionCoolDownSecondsStatisticEntry() {
        return reproductionCoolDownSecondsStatisticEntry;
    }

    public void setReproductionCoolDownSecondsStatisticEntry(SingleStatisticEntry<Integer> reproductionCoolDownSecondsStatisticEntry) {
        this.reproductionCoolDownSecondsStatisticEntry = reproductionCoolDownSecondsStatisticEntry;
    }

    public SingleStatisticEntry<Integer> getReproductionRequiredAgeStatisticEntry() {
        return reproductionRequiredAgeStatisticEntry;
    }

    public void setReproductionRequiredAgeStatisticEntry(SingleStatisticEntry<Integer> reproductionRequiredAgeStatisticEntry) {
        this.reproductionRequiredAgeStatisticEntry = reproductionRequiredAgeStatisticEntry;
    }

    public SingleStatisticEntry<Integer> getReproductionRequiredFoodCountStatisticEntry() {
        return reproductionRequiredFoodCountStatisticEntry;
    }

    public void setReproductionRequiredFoodCountStatisticEntry(SingleStatisticEntry<Integer> reproductionRequiredFoodCountStatisticEntry) {
        this.reproductionRequiredFoodCountStatisticEntry = reproductionRequiredFoodCountStatisticEntry;
    }
}
