public class Gym extends Room {
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
