package app.natural.selection.common.model.creature;

public enum MovingDirection {
  POSITIVE,
  NEGATIVE,
  STAY;

  public int intValue() {
    return this == POSITIVE ? 1 : this == NEGATIVE ? -1 : 0;
  }

  public static MovingDirection fromIntValue(Integer integer) {
    return integer > 0 ? POSITIVE : integer < 0 ? NEGATIVE : STAY;
  }
}
