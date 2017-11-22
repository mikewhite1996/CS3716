public class Test {
  public static void main(String[] args) {
    TimeSlot time1 = new TimeSlot("Steve", Block.values()[7]);

    Room gym = new Gym();


    Date date1 = new Date(2017,11,22);
    Date date2 = new Date(2017,11,20);


    Request r1 = new Request(date1, gym, time1);
    System.out.println(r1.toString());

    Schedule week1 = new Schedule();
    week1.makeRequest(r1);
    week1.makeRequest(r1);

    Room r2 = new Gym();
    TimeSlot  t2 = new TimeSlot("Joan", Block.F);
    Request rq2 = new Request(date2, r2, t2);
    System.out.println(rq2.toString());

    week1.makeRequest(rq2);

  }
}
