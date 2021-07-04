package app.natural.selection.algorithm.factories;

import app.natural.selection.algorithm.configuration.AlgorithmMutationControllerType;
import app.natural.selection.algorithm.configuration.AlgorithmReproductionControllerType;
import app.natural.selection.algorithm.controllers.implementations.defaultImpl.DefaultMutationController;
import app.natural.selection.algorithm.controllers.implementations.defaultImpl.DefaultReproductionController;
import app.natural.selection.algorithm.controllers.interfaces.IMutationController;
import app.natural.selection.algorithm.controllers.interfaces.IReproductionController;

public class AlgorithmControllersFactory {

  public static IMutationController createMutationController(
      AlgorithmMutationControllerType mutationControllerType) {
    switch (mutationControllerType) {
      case DEFAULT:
        return new DefaultMutationController();
      default:
        return new DefaultMutationController();
    }
  }

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
