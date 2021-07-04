package app.natural.selection.algorithm.configuration;

import static app.natural.selection.algorithm.configuration.AlgorithmConstants.*;

public class AlgorithmConfiguration {

  private Double mutationRate;

  private AlgorithmMutationControllerType mutationControllerType;

  private AlgorithmReproductionControllerType reproductionControllerType;

  public AlgorithmConfiguration() {
    this.mutationRate = DEFAULT_MUTATION_RATE;
    this.mutationControllerType = DEFAULT_MUTATION_CONTROLLER_TYPE;
    this.reproductionControllerType = DEFAULT_REPRODUCTION_CONTROLLER_TYPE;
  }

  public Double getMutationRate() {
    return mutationRate;
  }

  public AlgorithmMutationControllerType getMutationControllerType() {
    return mutationControllerType;
  }

  public void setMutationControllerType(AlgorithmMutationControllerType mutationControllerType) {
    this.mutationControllerType = mutationControllerType;
  }

  public AlgorithmReproductionControllerType getReproductionControllerType() {
    return reproductionControllerType;
  }

  public void setReproductionControllerType(
      AlgorithmReproductionControllerType reproductionControllerType) {
    this.reproductionControllerType = reproductionControllerType;
  }

  public void setMutationRate(Double mutationRate) {
    this.mutationRate = mutationRate;
  }
}
