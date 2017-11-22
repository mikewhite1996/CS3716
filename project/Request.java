public class Request {
  private Date theDate;
  private Room theRoom;
  private TimeSlot theTimeSlot;

  public Request(Date d, Room r, TimeSlot t) {
    theDate = d;
    theRoom = r;
    theTimeSlot = t;
  }

  public Date getTheDate() {
    return theDate;
  }

  public Room getTheRoom() {
    return theRoom;
  }

  public TimeSlot getTheTimeSlot() {
    return theTimeSlot;
  }



  public boolean equals(Object other) {
    if (!(other instanceof Request)) {
      return false;
    }
    Request check = (Request) other;
    return this.theDate.equals(check.getTheDate())
          && this.theRoom.getName().equals(check.theRoom.getName())
          && this.theTimeSlot.getBlock().equals(check.theTimeSlot.getBlock());
  }

  public String toString() {
    String s = (theDate.toString() + "\n" + theRoom.toString() +"\n" +
                theTimeSlot.toString());
    return s;
  }

}
