public enum DayName {
  SUNDAY("Sunday"),
  MONDAY("Monday"),
  TUESDAY("Tuesday"),
  WEDNESDAY("Wednesday"),
  THURSDAY("Thursday"),
  FRIDAY("Friday"),
  SATURDAY("Saturday");

  private String dayname;

  private DayName(String value) {
    dayname = value;
  }

  public String getDayName() {
    return dayname;
  }
}
