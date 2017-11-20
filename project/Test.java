public class Test {
  public static void main(String[] args) {
    TimeSlot time1 = new TimeSlot("Steve", Block.values()[7]);

    Room gym = new Gym();


    Day day1 = new Day(DayName.MONDAY);


    Request r1 = new Request(day1, gym, time1);
    System.out.println(r1.toString());

    Schedule week1 = new Schedule();
    week1.makeRequest(r1);
    week1.makeRequest(r1);

    Day day2 = new Day(DayName.FRIDAY);
    Room r2 = new Gym();
    TimeSlot  t2 = new TimeSlot("Joan", Block.F);
    Request rq2 = new Request(day2, r2, t2);

    week1.makeRequest(rq2);

    week1.display();
  }
}
