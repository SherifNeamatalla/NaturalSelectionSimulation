package app.natural.selection.common.model.creature;

import app.natural.selection.common.model.food.Food;

public class CreatureAction {

    private Creature actionTakingCreature;

    private CreatureActionType type;

    private Creature loveInterest;

    private Food ateFood;

    private CreatureAction() {
    }

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

    public static CreatureAction reproduction(Creature creature, Creature loveInterest) {
        return new CreatureAction(creature, CreatureActionType.REPRODUCTION, loveInterest, null);
    }

    public Creature getActionTakingCreature() {
        return actionTakingCreature;
    }


    public CreatureActionType getType() {
        return type;
    }


    public Creature getLoveInterest() {
        return loveInterest;
    }


    public Food getAteFood() {
        return ateFood;
    }
}
