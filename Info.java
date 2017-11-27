public class Info {
  private Day theDay;
  private Room theRoom;
  private TimeSlot theBlock;
  private Group theGroup;

  public Info(Group g, Day d, Room r, TimeSlot b) {
	theGroup = g;
    theDay = d;
    theRoom = r;
    theBlock = b;
  }

  public Day getTheDay() {
    return theDay;
  }

  public Room getTheRoom() {
    return theRoom;
  }

  public TimeSlot getTheTimeSlot() {
    return theBlock;
  }

  public Group getTheGroup(){
	  return theGroup;
  }

  public String getDay() {
    return this.theDay.toString();
  }


  /*public boolean equals(Object other) {
    if (!(other instanceof Info)) {
      return false;
    }
    Info check = (Info) other;

    boolean conflict = false;

    if ()
    return this.theDay.toString().equals(check.theDay.toString())
          && this.theRoom.getName().equals(check.theRoom.getName())
          && this.theBlock.getStartBlock().equals(check.theBlock.getEndBlock());
  }*/

  public String toString() {
    String s = (theDay.toString() + "\n" + theRoom.toString() +"\n" +
                theBlock.getStartBlock().getBlock() + " || " + theBlock.getEndBlock().getBlock());
    return s;
  }

}
