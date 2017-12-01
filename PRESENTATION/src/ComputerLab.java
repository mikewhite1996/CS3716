import java.io.Serializable;

public class ComputerLab extends Room implements Serializable  {
	String name = "Computer Lab";
	  int capacity = 360;

	  public ComputerLab() { }

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
