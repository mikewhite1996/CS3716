import java.io.Serializable;

public class Auditorium extends Room implements Serializable{
  String name = "Auditorium";
  int capacity = 500;

  public Auditorium() { }

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
