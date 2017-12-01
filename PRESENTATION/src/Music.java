import java.io.Serializable;

public class Music extends Room implements Serializable {
  String name = "Music";
  int capacity = 50;

  public Music() { }

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
