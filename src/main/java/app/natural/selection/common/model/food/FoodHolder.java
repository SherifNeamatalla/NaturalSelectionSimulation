package app.natural.selection.common.model.food;

import app.natural.selection.simulation.config.SimulationConfiguration;

import java.util.ArrayList;
import java.util.List;

public class FoodHolder {

  private List<Food> foodList;

  public FoodHolder(SimulationConfiguration simulationConfiguration) {
    this.foodList = new ArrayList<>();
    for (int i = 0; i < simulationConfiguration.getFoodCount(); i++) {

      this.foodList.add(new Food(simulationConfiguration));
    }
  }

  public List<Food> getFoodList() {
    return foodList;
  }

  public void setFoodList(List<Food> foodList) {
    this.foodList = foodList;
  }
}
