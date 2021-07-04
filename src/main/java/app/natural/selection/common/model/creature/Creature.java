package app.natural.selection.common.model.creature;

import app.natural.selection.algorithm.controllers.implementations.defaultImpl.DefaultCreatureLogicHandler;
import app.natural.selection.algorithm.controllers.interfaces.ICreatureLogicHandler;
import app.natural.selection.common.model.Position;
import app.natural.selection.common.model.food.FoodHolder;
import app.natural.selection.common.model.generation.Generation;
import app.natural.selection.simulation.config.SimulationConfiguration;

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

  public Creature(SimulationConfiguration simulationConfiguration) {
    this.id = UUID.randomUUID();
    this.position = new Position(simulationConfiguration);
    this.creatureProperties = new CreatureProperties(simulationConfiguration);
    this.takenActions = new ArrayList<>();
    this.creatureLogicHandler = new DefaultCreatureLogicHandler();
    this.energy = simulationConfiguration.getCreatureStaringEnergy().doubleValue();
    this.horizontalMovingDirection = MovingDirection.STAY;
    this.verticalMovingDirection = MovingDirection.STAY;
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

  public void setEnergy(Double energy) {
    this.energy = energy;
  }

  public CreatureAction tick(Generation generation, FoodHolder foodHolder) {
    return creatureLogicHandler.creatureTick(this, generation, foodHolder);
  }

  public void move(
      MovingDirection horizontalMovingDirection, MovingDirection verticalMovingDirection) {
    this.horizontalMovingDirection = horizontalMovingDirection;
    this.verticalMovingDirection = verticalMovingDirection;

    move();
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
  }
}
