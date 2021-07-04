package app.natural.selection.algorithm.factories;

import app.natural.selection.algorithm.configuration.AlgorithmReproductionControllerType;
import app.natural.selection.algorithm.controllers.implementations.defaultImpl.DefaultReproductionController;
import app.natural.selection.algorithm.controllers.interfaces.IReproductionController;

public class AlgorithmControllersFactory {


  public static IReproductionController createReproductionController(
      AlgorithmReproductionControllerType reproductionControllerType) {
    switch (reproductionControllerType) {
      case DEFAULT:
        return new DefaultReproductionController();
      default:
        return new DefaultReproductionController();
    }
  }
}
