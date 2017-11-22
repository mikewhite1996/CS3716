public class Date {
  private  int year;
  private int month;
  private int day;

  public Date(int d, int m, int y) {
    day = d;
    month = m;
    year = y;
  }

  public int getYear() {
    return year;
  }

  public int getMonth() {
    return month;
  }

  public int getDay() {
    return day;
  }

  public boolean equals(Object other) {
    if (!(other instanceof Date)) {
      return false;
    }
    Date check = (Date) other;
    return this.day == check.day
          && this.month == check.month
          && this.year == check.year;
  }

  public String toString() {
    String date = day + " / " + month + " / " + year;
    return date;
  }
}
