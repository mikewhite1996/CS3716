import java.io.Serializable;

public class LectureHall extends Room implements Serializable{
	String name = "Lecture Hall";
	  int capacity = 360;

	  public LectureHall() { }

	  public String getName() {
	    return name;
	  }

	  public int getCapacity() {
	    return capacity;
	  }

	  public String toString() {
	    return name;
	  }
}
