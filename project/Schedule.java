import java.util.ArrayList;

public class Schedule {
  private ArrayList<Request> approvedRequests;
  private ArrayList<Request> pendingRequests;
  private boolean changed = false;

  private ArrayList<Request> sunday;
  private ArrayList<Request> monday;
  private ArrayList<Request> tuesday;
  private ArrayList<Request> wednesday;
  private ArrayList<Request> thursday;
  private ArrayList<Request> friday;
  private ArrayList<Request> saturday;

  public Schedule() {
    approvedRequests = new ArrayList<Request>();
    pendingRequests = new ArrayList<Request>();
    sunday = new ArrayList<Request>();
    monday = new ArrayList<Request>();
    tuesday = new ArrayList<Request>();
    wednesday = new ArrayList<Request>();
    thursday = new ArrayList<Request>();
    friday = new ArrayList<Request>();
    saturday = new ArrayList<Request>();
  }

  public void makeRequest(Request r) {
    Day possibleDay = r.getTheDay();
    Room possibleRoom = r.getTheRoom();
    TimeSlot possibleTime = r.getTheTimeSlot();
    boolean conflict = false;

    for (int i = 0; i < approvedRequests.size(); ++i) {
      if (r.equals(approvedRequests.get(i))) {
        conflict = true;
      }

    }

    if (conflict) {
      pendingRequests.add(r);
      System.out.println("Conflct, Request denied");
    }
    else {
      approvedRequests.add(r);
      System.out.println("Request Approved");
      changed = true;
    }

  }

  public void display() {
    if (changed) {
      for (int i = 0; i < approvedRequests.size(); ++i) {
        if ((approvedRequests.get(i).getDay()).equals("Sunday")) {
          sunday.add(approvedRequests.get(i));
        }
        else if ((approvedRequests.get(i).getDay()).equals("Monday")) {
          monday.add(approvedRequests.get(i));
        }
        else if ((approvedRequests.get(i).getDay()).equals("Tuesday")) {
          tuesday.add(approvedRequests.get(i));
        }
        else if ((approvedRequests.get(i).getDay()).equals("Wednesday")) {
          wednesday.add(approvedRequests.get(i));
        }
        else if ((approvedRequests.get(i).getDay()).equals("Thursday")) {
          thursday.add(approvedRequests.get(i));
        }
        else if ((approvedRequests.get(i).getDay()).equals("Friday")) {
          friday.add(approvedRequests.get(i));
        }
        else if ((approvedRequests.get(i).getDay()).equals("Saturday")) {
          saturday.add(approvedRequests.get(i));
        }
      }
      for (int i = 0; i < monday.size(); ++i) {
        System.out.println(monday.get(i).toString());
      }
    }
  }
}
