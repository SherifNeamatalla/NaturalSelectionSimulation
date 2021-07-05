package app.natural.selection.common.model.creature;

import app.natural.selection.algorithm.configuration.AlgorithmParameters;
import app.natural.selection.algorithm.controllers.implementations.defaultImpl.DefaultCreatureLogicHandler;
import app.natural.selection.algorithm.controllers.interfaces.ICreatureLogicHandler;
import app.natural.selection.common.model.food.Food;
import app.natural.selection.common.model.food.FoodHolder;
import app.natural.selection.common.model.population.Population;
import app.natural.selection.common.model.position.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Creature {

    private final UUID id;

    private final Position position;

    private final CreatureProperties creatureProperties;

    private final List<CreatureAction> takenActions;

    private final ICreatureLogicHandler creatureLogicHandler;

    private final Integer maxX;

    private final Integer maxY;

    private final Creature parent1;

    private final Creature parent2;

    private final AlgorithmParameters algorithmParameters;

    private final Long tickBirthDate;

    private final Integer generation;

    private Double energy;

    private MovingDirection horizontalMovingDirection;

    private MovingDirection verticalMovingDirection;

    private Integer foodCount;

    private Long lastReproductionActionTick;


    public Creature(Creature parent1, Creature parent2, Long currentTick) {
        this.id = UUID.randomUUID();
        this.position = new Position(parent1.getPosition());
        this.creatureProperties = new CreatureProperties(parent1.getCreatureProperties(), parent2.getCreatureProperties());
        this.takenActions = new ArrayList<>();
        this.creatureLogicHandler = new DefaultCreatureLogicHandler();
        this.energy = parent1.getSimulationConfiguration().getCreatureStaringEnergy().doubleValue();
        this.horizontalMovingDirection = MovingDirection.STAY;
        this.verticalMovingDirection = MovingDirection.STAY;
        this.maxX = parent1.getMaxX();
        this.maxY = parent1.getMaxY();
        this.algorithmParameters = parent1.getSimulationConfiguration();
        this.parent1 = parent1;
        this.parent2 = parent2;
        this.foodCount = 0;
        this.tickBirthDate = currentTick;
        this.lastReproductionActionTick = null;
        this.generation = Math.max(parent1.getGeneration(), parent2.getGeneration()) + 1;
    }

    public Creature(AlgorithmParameters algorithmParameters) {
        this.id = UUID.randomUUID();
        this.position = new Position(algorithmParameters);
        this.creatureProperties = new CreatureProperties(algorithmParameters);
        this.takenActions = new ArrayList<>();
        this.creatureLogicHandler = new DefaultCreatureLogicHandler();
        this.energy = algorithmParameters.getCreatureStaringEnergy().doubleValue();
        this.horizontalMovingDirection = MovingDirection.STAY;
        this.verticalMovingDirection = MovingDirection.STAY;
        this.maxX = algorithmParameters.getCanvasWidth();
        this.maxY = algorithmParameters.getCanvasHeight();
        this.algorithmParameters = algorithmParameters;
        this.parent1 = null;
        this.parent2 = null;
        this.foodCount = 0;
        this.tickBirthDate = 0L;
        this.lastReproductionActionTick = null;
        this.generation = 0;
    }

    public AlgorithmParameters getSimulationConfiguration() {
        return algorithmParameters;
    }


    public CreatureAction tick(Population population, FoodHolder foodHolder, Long currentTick) {
        return creatureLogicHandler.creatureTick(this, population, foodHolder, currentTick);
    }

    public Boolean isReadyToMate(Long currentTick) {
        Boolean ageConstraintValid = currentTick - tickBirthDate
                >= (long) creatureProperties.getReproductionRequiredAge() * algorithmParameters.getTickPerSecond();

        Boolean foodConstraintValid = foodCount >= creatureProperties.getReproductionRequiredFoodCount();

        Boolean coolDownConstraintValid = lastReproductionActionTick == null || currentTick - lastReproductionActionTick
                >= (long) creatureProperties.getReproductionCoolDownSeconds() * algorithmParameters.getTickPerSecond();

        return ageConstraintValid && foodConstraintValid && coolDownConstraintValid;
    }

    public void move(
            MovingDirection horizontalMovingDirection, MovingDirection verticalMovingDirection,
            Position wantedPosition) {
        this.horizontalMovingDirection = horizontalMovingDirection;
        this.verticalMovingDirection = verticalMovingDirection;

        move(wantedPosition);
    }

    public void eatFood(Food food) {
        energy = Math.min(energy + food.getNutritionValue(), 100);
        foodCount++;
    }

    public void move(Position wantedPosition) {

        // Without this there is a bug where the creature will keep trying to get closer to the food without ever
        // doing it
        // an actual example got from debugging the bug: creature is at 73,305, food is at 57,294 and creature
        // has speed of 25, if the creature tries to move with his speed towards the food he will end up at 48,277 as
        // his speed is 25, then he repeats it again going back to the older position etc.. .
        if (wantedPosition != null && wantedPosition.getX() - position.getX() <= creatureProperties.getPixelsPerTick() &&
                wantedPosition.getY() - position.getY() <= creatureProperties.getPixelsPerTick()) {
            this.position.setX(wantedPosition.getX());
            this.position.setY(wantedPosition.getY());
        } else {
            this.position.setX(
                    this.position.getX()
                            + this.horizontalMovingDirection.intValue()
                            * this.creatureProperties.getPixelsPerTick());
            this.position.setY(
                    this.position.getY()
                            + this.verticalMovingDirection.intValue()
                            * this.creatureProperties.getPixelsPerTick());

        }

        // To ensure the creature never gets out of the world, am your god now creature
        if (position.getX() >= this.maxX - 100 || position.getX() <= 0) {
            position.setX(Math.min(Math.max(0, position.getX()), this.maxX));
            horizontalMovingDirection = MovingDirection.fromIntValue(-1 * horizontalMovingDirection.intValue());
        }

        if (position.getY() >= this.maxY - 100 || position.getY() <= 0) {
            position.setY(Math.min(Math.max(0, position.getY()), this.maxY));

            verticalMovingDirection = MovingDirection.fromIntValue(-1 * verticalMovingDirection.intValue());
        }

    }


    public void mutate(Double mutationRate) {
        creatureProperties.mutate(mutationRate, algorithmParameters);
    }

    public void mated(Long currentTick) {
        lastReproductionActionTick = currentTick;
    }

    public void decayEnergy() {
        energy -= creatureProperties.getEnergyDecayPerTick();
    }

    public UUID getId() {
        return id;
    }

    public Position getPosition() {
        return position;
    }

    public CreatureProperties getCreatureProperties() {
        return creatureProperties;
    }

    public List<CreatureAction> getTakenActions() {
        return takenActions;
    }

    public Double getEnergy() {
        return energy;
    }

    public Integer getMaxX() {
        return maxX;
    }

    public Integer getMaxY() {
        return maxY;
    }

    public Creature getParent1() {
        return parent1;
    }

    public Creature getParent2() {
        return parent2;
    }

    public Integer getFoodCount() {
        return foodCount;
    }

    public Integer getGeneration() {
        return generation;
    }

}
