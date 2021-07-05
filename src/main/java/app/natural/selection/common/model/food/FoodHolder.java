package app.natural.selection.common.model.food;

import app.natural.selection.algorithm.configuration.AlgorithmParameters;

import java.util.ArrayList;
import java.util.List;

public class FoodHolder {

    private final List<Food> foodList;

    public FoodHolder(AlgorithmParameters algorithmParameters) {
        this.foodList = new ArrayList<>();
        generateFood(algorithmParameters);
    }

    public void generateFood(AlgorithmParameters algorithmParameters) {
        for (int i = 0; i < algorithmParameters.getFoodCount(); i++) {
            this.foodList.add(new Food(algorithmParameters));
        }
    }

    public List<Food> getFoodList() {
        return foodList;
    }
}
