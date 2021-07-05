package app.natural.selection.appcontroller.model;

import app.natural.selection.common.model.creature.Creature;

public class SingleStatisticEntry<T> {

    private final T maxValue;

    private final T minValue;

    private final T avgValue;

    private final Creature maxCreature;
    private final Creature minCreature;

    public SingleStatisticEntry(
            T minValue, T maxValue, T avgValue, Creature maxCreature, Creature minCreature) {
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.avgValue = avgValue;
        this.maxCreature = maxCreature;
        this.minCreature = minCreature;
    }

    public Creature getMinCreature() {
        return minCreature;
    }


    public Creature getMaxCreature() {
        return maxCreature;
    }


    public T getMaxValue() {
        return maxValue;
    }


    public T getMinValue() {
        return minValue;
    }


    public T getAvgValue() {
        return avgValue;
    }

}
