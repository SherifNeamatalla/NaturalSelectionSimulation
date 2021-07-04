package app.natural.selection.common.model.creature;

import app.natural.selection.algorithm.controllers.implementations.defaultImpl.DefaultCreatureLogicHandler;
import app.natural.selection.algorithm.controllers.interfaces.ICreatureLogicHandler;
import app.natural.selection.common.model.Position;
import app.natural.selection.common.model.food.Food;
import app.natural.selection.common.model.food.FoodHolder;
import app.natural.selection.common.model.generation.Generation;
import app.natural.selection.simulation.config.SimulationConfiguration;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Creature {

  private final UUID id;

  private Double energy;

  private MovingDirection horizontalMovingDirection;

  private MovingDirection verticalMovingDirection;

  private final Position position;

  private final CreatureProperties creatureProperties;

  private final List<CreatureAction> takenActions;

  private final ICreatureLogicHandler creatureLogicHandler;

  private final Integer maxX;

  private final Integer maxY;

  private final Creature parent1;

  private final Creature parent2;

  private final SimulationConfiguration simulationConfiguration;

  private Integer foodCount;

  private LocalDateTime birthDate;

  private LocalDateTime lastReproductionActionDate;

  private final Integer generation;

  public Creature(Creature parent1, Creature parent2) {
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
    this.simulationConfiguration = parent1.getSimulationConfiguration();
    this.parent1 = parent1;
    this.parent2 = parent2;
    this.foodCount = 0;
    this.birthDate = LocalDateTime.now();
    this.lastReproductionActionDate = null;
    this.generation = Math.max(parent1.getGeneration(), parent2.getGeneration()) + 1;
  }

  public Creature(SimulationConfiguration simulationConfiguration) {
    this.id = UUID.randomUUID();
    this.position = new Position(simulationConfiguration);
    this.creatureProperties = new CreatureProperties(simulationConfiguration);
    this.takenActions = new ArrayList<>();
    this.creatureLogicHandler = new DefaultCreatureLogicHandler();
    this.energy = simulationConfiguration.getCreatureStaringEnergy().doubleValue();
    this.horizontalMovingDirection = MovingDirection.STAY;
    this.verticalMovingDirection = MovingDirection.STAY;
    this.maxX = simulationConfiguration.getCanvasWidth();
    this.maxY = simulationConfiguration.getCanvasHeight();
    this.simulationConfiguration = simulationConfiguration;
    this.parent1 = null;
    this.parent2 = null;
    this.foodCount = 0;
    this.birthDate = LocalDateTime.now();
    this.lastReproductionActionDate = null;
    this.generation = 0;
  }

  public SimulationConfiguration getSimulationConfiguration() {
    return simulationConfiguration;
  }


  public CreatureAction tick(Generation generation, FoodHolder foodHolder) {
    return creatureLogicHandler.creatureTick(this, generation, foodHolder);
  }

  public Boolean isReadyToMate() {
    Boolean ageConstraintValid = Math.abs(Duration.between(birthDate, LocalDateTime.now()).getSeconds())
            >= creatureProperties.getReproductionRequiredAge();

    Boolean foodConstraintValid = foodCount >= creatureProperties.getReproductionRequiredFoodCount();

    Boolean coolDownConstraintValid = lastReproductionActionDate == null || Math.abs(Duration.between(lastReproductionActionDate,
            LocalDateTime.now()).getSeconds()) >= creatureProperties.getReproductionCoolDownSeconds();

    return ageConstraintValid && foodConstraintValid && coolDownConstraintValid;
  }

  public void move(
          MovingDirection horizontalMovingDirection, MovingDirection verticalMovingDirection) {
    this.horizontalMovingDirection = horizontalMovingDirection;
    this.verticalMovingDirection = verticalMovingDirection;

    move();
  }

  public void eatFood(Food food) {
    energy = Math.min(energy + food.getNutritionValue(), 100);
    foodCount++;
  }

  public void move() {
    this.position.setX(
            this.position.getX()
                    + this.horizontalMovingDirection.intValue()
                    * this.creatureProperties.getPixelsPerTick());
    this.position.setY(
            this.position.getY()
                    + this.verticalMovingDirection.intValue()
                    * this.creatureProperties.getPixelsPerTick());

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
    creatureProperties.mutate(mutationRate, simulationConfiguration);
  }

  public void mated() {
    lastReproductionActionDate = LocalDateTime.now();
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
