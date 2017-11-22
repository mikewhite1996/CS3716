public class Date {
  private  int year;
  private int month;
  private int day;

  public Date(int y, int m, int d) {
    year = y;
    month = m;
    day = d;
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
    return this.year == check.year
          && this.month == check.month
          && this.day == check.day;
  }

  public String toString() {
    String date = year + " / " + month + " / " + day;
    return date;
  }
}
