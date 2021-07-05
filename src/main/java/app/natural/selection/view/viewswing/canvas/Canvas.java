package app.natural.selection.view.viewswing.canvas;

import app.natural.selection.common.model.creature.Creature;
import app.natural.selection.common.model.food.Food;
import app.natural.selection.common.model.food.FoodHolder;
import app.natural.selection.common.model.population.Population;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {

  private FoodHolder foodHolder;
  private Population population;

  public Canvas() {
    setBorder(BorderFactory.createLineBorder(Color.BLACK));
      setBackground(new Color(75, 127, 82));
    setVisible(true);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    removeAll();
    if (population != null) {
      g.setColor(Color.WHITE);
      for (Creature creature : population.getCreatures()) {
        g.fillOval(
            creature.getPosition().getX().intValue(),
            creature.getPosition().getY().intValue(),
            creature.getCreatureProperties().getSizePixels(),
            creature.getCreatureProperties().getSizePixels());
      }
    }
    if (foodHolder != null) {
      g.setColor(Color.RED);
      for (Food food : foodHolder.getFoodList()) {
        g.fillOval(
            food.getPosition().getX().intValue(),
            food.getPosition().getY().intValue(),
            new Double(food.getNutritionValue() * 2).intValue(),
            new Double(food.getNutritionValue() * 2).intValue());
      }
    }
  }

  public void draw(Population population, FoodHolder foodHolder) {
    this.population = population;
    this.foodHolder = foodHolder;
    repaint();
  }
}
