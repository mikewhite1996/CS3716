import java.util.ArrayList;
import java.io.*;


public class Info implements Serializable {
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


  public boolean equals(Object other) {
    if (!(other instanceof Info)) {
      return false;
    }
    Info check = (Info) other;

    boolean timeConflict = false;

    Block_Sch a = this.theBlock.getStartBlock();
    Block_Sch b = this.theBlock.getEndBlock();
    ArrayList<Block_Sch> rA = check.getTheTimeSlot().getRange();

    for (int i = 0; i < rA.size(); ++i) {
      if (rA.get(i).equals(a)) {
        timeConflict = true;
        }
      else if (rA.get(i).equals(b)) {
        timeConflict = true;
        }
      }




    return this.theDay.toString().equals(check.theDay.toString())
          && this.theRoom.getName().equals(check.theRoom.getName())
          && timeConflict;
  }

  public String toString() {
    String s = (theDay.toString() + "\n" + theRoom.toString() +"\n" +
                theBlock.getStartBlock().toString() + " || " + theBlock.getEndBlock().toString());
    return s;
  }

}
