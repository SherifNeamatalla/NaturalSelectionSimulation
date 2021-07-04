package app.natural.selection.appcontroller.model;

import app.natural.selection.common.model.creature.Creature;

public class SingleStatisticEntry<T> {

  private T maxValue;

  private T minValue;

  private T avgValue;

  private Creature maxCreature;
  private Creature minCreature;

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

  public void setMinCreature(Creature minCreature) {
    this.minCreature = minCreature;
  }

  public Creature getMaxCreature() {
    return maxCreature;
  }

  public void setMaxCreature(Creature maxCreature) {
    this.maxCreature = maxCreature;
  }

  public T getMaxValue() {
    return maxValue;
  }

  public void setMaxValue(T maxValue) {
    this.maxValue = maxValue;
  }

  public T getMinValue() {
    return minValue;
  }

  public void setMinValue(T minValue) {
    this.minValue = minValue;
  }

  public T getAvgValue() {
    return avgValue;
  }

  public void setAvgValue(T avgValue) {
    this.avgValue = avgValue;
  }
}
