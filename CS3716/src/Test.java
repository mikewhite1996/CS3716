public class Test {
  public static void main(String[] args) {
    TimeSlot block = new TimeSlot(Block_Req.A);
    
    System.out.println(Block_Req.A.getBlock());
    
    Room gym = new Gym();


    Day day1 = new Day(DayName.MONDAY);
    
    Group group = new Group("Test");


    Info r1 = new Info(group, day1, gym, block);
    System.out.println(r1.toString());

    Schedule week1 = new Schedule();
    week1.makeRequest(r1);
    week1.makeRequest(r1);

    Day day2 = new Day(DayName.FRIDAY);
    Room r2 = new Gym();
    TimeSlot  t2 = new TimeSlot(Block_Req.F);
    Info rq2 = new Info(group, day2, r2, t2);

    week1.makeRequest(rq2);

    week1.display();
  }
}
