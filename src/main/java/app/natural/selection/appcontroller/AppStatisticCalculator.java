package app.natural.selection.appcontroller;

import app.natural.selection.appcontroller.model.SingleStatisticEntry;
import app.natural.selection.appcontroller.model.Statistic;
import app.natural.selection.common.model.creature.Creature;
import app.natural.selection.common.model.generation.Generation;

import java.util.List;
import java.util.stream.Collectors;

public class AppStatisticCalculator {

  public static void saveAppState() {
  }

  public static void updateStatistic(Generation generation, Statistic statistic) {
    if (generation == null || generation.getCreatures() == null || generation.getCreatures().size() == 0) return;

    SingleStatisticEntry<Double> pixelsPerTickStatisticEntry =
            getSingleStatisticEntryDoubles(generation.getCreatures(),
                    generation.getCreatures().stream().map(creature -> creature.getCreatureProperties().getPixelsPerTick()).collect(Collectors.toList()));

    SingleStatisticEntry<Integer> sizePixelsStatisticEntry =
            getSingleStatisticEntryIntegers(generation.getCreatures(),
                    generation.getCreatures().stream().map(creature -> creature.getCreatureProperties().getSizePixels()).collect(Collectors.toList()));

    SingleStatisticEntry<Double> energyDecayPerTickStatisticEntry =
            getSingleStatisticEntryDoubles(generation.getCreatures(),
                    generation.getCreatures().stream().map(creature -> creature.getCreatureProperties().getEnergyDecayPerTick()).collect(Collectors.toList()));

    SingleStatisticEntry<Integer> visionPixelsStatisticEntry = getSingleStatisticEntryIntegers(generation.getCreatures(),
            generation.getCreatures().stream().map(creature -> creature.getCreatureProperties().getVisionPixels()).collect(Collectors.toList()));

    SingleStatisticEntry<Integer> reproductionCoolDownSecondsStatisticEntry = getSingleStatisticEntryIntegers(generation.getCreatures(),
            generation.getCreatures().stream().map(creature -> creature.getCreatureProperties().getReproductionCoolDownSeconds()).collect(Collectors.toList()));

    SingleStatisticEntry<Integer> reproductionRequiredAgeStatisticEntry = getSingleStatisticEntryIntegers(generation.getCreatures(),
            generation.getCreatures().stream().map(creature -> creature.getCreatureProperties().getReproductionRequiredAge()).collect(Collectors.toList()));

    SingleStatisticEntry<Integer> reproductionRequiredFoodCountStatisticEntry = getSingleStatisticEntryIntegers(generation.getCreatures(),
            generation.getCreatures().stream().map(creature -> creature.getCreatureProperties().getReproductionRequiredFoodCount()).collect(Collectors.toList()));


    statistic.refreshValues(pixelsPerTickStatisticEntry,
            energyDecayPerTickStatisticEntry,
            sizePixelsStatisticEntry,
            visionPixelsStatisticEntry,
            reproductionCoolDownSecondsStatisticEntry,
            reproductionRequiredAgeStatisticEntry,
            reproductionRequiredFoodCountStatisticEntry);
  }


  private static SingleStatisticEntry<Double> getSingleStatisticEntryDoubles(List<Creature> creatureList,
                                                                             List<Double> doubleList) {

    Double maxValue = Double.MIN_VALUE;
    Creature maxCreature = null;

    Double minValue = Double.MAX_VALUE;
    Creature minCreature = null;

    Double sum = 0.0;

    for (int i = 0; i < doubleList.size(); i++) {

      Double val = doubleList.get(i);

      sum += val;

      if (val >= maxValue) {
        maxValue = val;
        maxCreature = creatureList.get(i);
      }

      if (val <= minValue) {
        minValue = val;
        minCreature = creatureList.get(i);
      }
    }

    Double avgValue = sum / creatureList.size();
    return new SingleStatisticEntry<Double>(minValue, maxValue, avgValue, maxCreature, minCreature);
  }

  private static SingleStatisticEntry<Integer> getSingleStatisticEntryIntegers(List<Creature> creatureList,
                                                                               List<Integer> integerList) {

    Integer maxValue = Integer.MIN_VALUE;
    Creature maxCreature = null;

    Integer minValue = Integer.MAX_VALUE;
    Creature minCreature = null;

    Integer sum = 0;

    for (int i = 0; i < integerList.size(); i++) {

      Integer val = integerList.get(i);

      sum += val;

      if (val >= maxValue) {
        maxValue = val;
        maxCreature = creatureList.get(i);
      }

      if (val <= minValue) {
        minValue = val;
        minCreature = creatureList.get(i);
      }
    }

    Integer avgValue = sum / creatureList.size();
    return new SingleStatisticEntry<Integer>(minValue, maxValue, avgValue, maxCreature, minCreature);
  }
}
