import java.io.*;
public class Day implements Serializable {
  private DayName day;

  public Day(DayName day) {
    this.day = day;
  }



  public String toString() {
    return day.getDayName();
  }

/*  public void getDay() {
    switch (day) {
      case SUNDAY:
      System.out.println("Sunday");
      break;

      case MONDAY:
      System.out.println("Monday");
      break;

      case TUESDAY:
      System.out.println("Tuesday");
      break;

      case WEDNESDAY:
      System.out.println("Wednesday");
      break;

      case THURSDAY:
      System.out.println("Thursday");
      break;

      case FRIDAY:
      System.out.println("Friday");
      break;

      case SATURDAY:
      System.out.println("Saturday");
      break;
    }
  }*/
}
