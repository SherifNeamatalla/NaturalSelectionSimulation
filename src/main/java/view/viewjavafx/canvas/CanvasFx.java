package view.viewjavafx.canvas;

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

    List<Creature> creatureList = appState.getGeneration().getCreatures();
    List<Food> foodList = appState.getFoodHolder().getFoodList();

    drawCreatures(creatureList);
    System.out.println(foodList.size());
    drawFoods(foodList);
  }

  private void drawFoods(List<Food> foodList) {
    GraphicsContext gc = getGraphicsContext2D();
    foodList.forEach(food -> drawFood(food, gc));
  }

  private void drawFood(Food food, GraphicsContext gc) {
    gc.setFill(BLACK);
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

  private void drawCreatures(List<Creature> creatureList) {
    GraphicsContext gc = getGraphicsContext2D();
    creatureList.forEach(creature -> drawCreature(creature, gc));
    //    System.out.println(creatureList.size());
  }

  private void drawCreature(Creature creature, GraphicsContext gc) {
    if (creature.getEnergy() <= 0) gc.setFill(RED);
    else if (creature.getEnergy() < 10) gc.setFill(YELLOW);
    else if (creature.getEnergy() < 50) gc.setFill(ORANGE);
    else gc.setFill(SILVER);
    gc.fillOval(
        creature.getPosition().getX(),
        creature.getPosition().getY(),
        creature.getCreatureProperties().getSizePixels(),
        creature.getCreatureProperties().getSizePixels());
  }
}
