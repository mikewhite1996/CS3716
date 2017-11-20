public class Request {
  private Day theDay;
  private Room theRoom;
  private TimeSlot theTimeSlot;

  public Request(Day d, Room r, TimeSlot t) {
    theDay = d;
    theRoom = r;
    theTimeSlot = t;
  }

  public Day getTheDay() {
    return theDay;
  }

  public Room getTheRoom() {
    return theRoom;
  }

  public TimeSlot getTheTimeSlot() {
    return theTimeSlot;
  }

  public String getDay() {
    return this.theDay.toString();
  }


  public boolean equals(Object other) {
    if (!(other instanceof Request)) {
      return false;
    }
    Request check = (Request) other;
    return this.theDay.toString().equals(check.theDay.toString())
          && this.theRoom.getName().equals(check.theRoom.getName())
          && this.theTimeSlot.getBlock().equals(check.theTimeSlot.getBlock());
  }

  public String toString() {
    String s = (theDay.toString() + "\n" + theRoom.toString() +"\n" +
                theTimeSlot.toString());
    return s;
  }

}
