package app.natural.selection.common.model.creature;

import app.natural.selection.common.model.food.Food;

public class CreatureAction {

  private Creature actionTakingCreature;

  private CreatureActionType type;

  private Creature loveInterest;

  private Food ateFood;

  private CreatureAction() {}

  private CreatureAction(
      Creature actionTakingCreature, CreatureActionType type, Creature loveInterest, Food ateFood) {
    this.actionTakingCreature = actionTakingCreature;
    this.type = type;
    this.loveInterest = loveInterest;
    this.ateFood = ateFood;
  }

  public static CreatureAction emptyAction(Creature creature) {
    return new CreatureAction(creature, CreatureActionType.NONE, null, null);
  }

  public static CreatureAction eatFoodAction(Creature creature, Food ateFood) {
    return new CreatureAction(creature, CreatureActionType.ATE_FOOD, null, ateFood);
  }

  public static CreatureAction dead(Creature creature) {
    return new CreatureAction(creature, CreatureActionType.DEAD, null, null);
  }

  public Creature getActionTakingCreature() {
    return actionTakingCreature;
  }

  public void setActionTakingCreature(Creature actionTakingCreature) {
    this.actionTakingCreature = actionTakingCreature;
  }

  public CreatureActionType getType() {
    return type;
  }

  public void setType(CreatureActionType type) {
    this.type = type;
  }

  public Creature getLoveInterest() {
    return loveInterest;
  }

  public void setLoveInterest(Creature loveInterest) {
    this.loveInterest = loveInterest;
  }

  public Food getAteFood() {
    return ateFood;
  }

  public void setAteFood(Food ateFood) {
    this.ateFood = ateFood;
  }
}
