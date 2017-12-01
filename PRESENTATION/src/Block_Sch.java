public enum Block_Sch {
		  A("9am"),
		  B("10am"),
		  C("11am"),
		  D("12pm"),
		  E("1pm"),
		  F("2pm"),
		  G("3pm"),
		  H("4pm"),
		  I("5pm"),
		  J("6pm"),
		  K("7pm"),
		  L("8pm"),
		  M("9pm"),
		  N("10pm"),
		  O("Not Available");
		  

			  private String block;

			  private Block_Sch(String value) {
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
