package app.natural.selection.view.viewjavafx.canvas;

import app.natural.selection.appcontroller.model.AppState;
import app.natural.selection.common.model.creature.Creature;
import app.natural.selection.common.model.food.Food;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;

import static javafx.scene.paint.Color.*;

public class CanvasFx extends javafx.scene.canvas.Canvas {

  public CanvasFx(double width, double height) {
    super(width, height);
    this.getGraphicsContext2D().setFill(Color.rgb(75, 127, 82));
    this.getGraphicsContext2D().fillRect(0, 0, this.getWidth(), this.getHeight());
  }

  public void draw(AppState appState) {
    clearOldState();

    List<Creature> creatureList = appState.getPopulation().getCreatures();
    List<Food> foodList = appState.getFoodHolder().getFoodList();

    Boolean showCreatureData = appState.getAppSettings().getShowCreatureData();

    drawCreatures(creatureList, showCreatureData);
    drawFoods(foodList);
  }

  private void drawFoods(List<Food> foodList) {
    GraphicsContext gc = getGraphicsContext2D();
    foodList.forEach(food -> drawFood(food, gc));
  }

  private void drawFood(Food food, GraphicsContext gc) {
    gc.setFill(RED);
    gc.fillOval(
        food.getPosition().getX(),
        food.getPosition().getY(),
        food.getNutritionValue() * 2,
        food.getNutritionValue() * 2);
  }

  private void clearOldState() {
    GraphicsContext gc = getGraphicsContext2D();
    gc.clearRect(0, 0, this.getWidth(), this.getHeight());
    getGraphicsContext2D().setFill(Color.rgb(75, 127, 82));
    getGraphicsContext2D().fillRect(0, 0, this.getWidth(), this.getHeight());
  }

  private void drawCreatures(List<Creature> creatureList, Boolean showCreatureData) {
    GraphicsContext gc = getGraphicsContext2D();
    creatureList.forEach(creature -> drawCreature(creature, gc, showCreatureData));
  }

  private void drawCreature(Creature creature, GraphicsContext gc, Boolean showCreatureData) {
    if (creature.getEnergy() <= 0) gc.setFill(BLACK);
    else if (creature.getEnergy() < 10) gc.setFill(YELLOW);
    else if (creature.getEnergy() < 50) gc.setFill(ORANGE);
    else gc.setFill(SILVER);
    if (showCreatureData) {
      drawCreatureData(creature, gc);
    }

    gc.fillOval(
            creature.getPosition().getX(),
            creature.getPosition().getY(),
            creature.getCreatureProperties().getSizePixels(),
            creature.getCreatureProperties().getSizePixels());

  }

  private void drawCreatureData(Creature creature, GraphicsContext gc) {
    gc.fillText(
            ""
                    + String.format("%.2f", creature.getEnergy())
                    + " "
                    + String.format("%d", creature.getCreatureProperties().getSizePixels())
                    + " "
                    + String.format("%d", creature.getCreatureProperties().getVisionPixels())
                    + " "
                    + String.format("%.2f", creature.getCreatureProperties().getEnergyDecayPerTick()),
            creature.getPosition().getX() - 10,
            creature.getPosition().getY());
    gc.fillText(
            creature.getId().toString(),
            creature.getPosition().getX(),
            creature.getPosition().getY() + 40);
  }
}
