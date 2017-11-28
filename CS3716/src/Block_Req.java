public enum Block_Req implements Block {
  A("9am - 10am"),
  B("10am - 11am"),
  C("11am - 12pm"),
  D("12pm - 1pm"),
  E("1pm - 2pm"),
  F("2pm - 3pm"),
  G("3pm - 4pm"),
  H("4pm - 5pm"),
  I("5pm - 6pm"),
  J("6pm - 7pm"),
  K("7pm - 8pm"),
  L("8pm - 9pm"),
  M("9pm - 10pm");

  private String block;

  private Block_Req(String value) {
    block = value;
  }

  public String getBlock() {
    return block;
  }

  public String toString() {
    return this.block;
  }

  public boolean equals(Block other) {
    if (!(other instanceof Block)) {
        return false;
      }
    Block check = (Block) other;
    return this.block.equals(other.getBlock());
  }


}
