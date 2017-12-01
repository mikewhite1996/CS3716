import java.io.*;
public class Gym extends Room implements Serializable{
  String name = "Gym";
  int capacity = 360;

  public Gym() { }

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
