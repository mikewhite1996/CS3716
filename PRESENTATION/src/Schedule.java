import java.util.ArrayList;

public class Schedule {
  private ArrayList<Info> approvedRequests;
  private ArrayList<Info> pendingRequests;
  private boolean changed = false;

  private ArrayList<Info> sunday;
  private ArrayList<Info> monday;
  private ArrayList<Info> tuesday;
  private ArrayList<Info> wednesday;
  private ArrayList<Info> thursday;
  private ArrayList<Info> friday;
  private ArrayList<Info> saturday;

  public Schedule() {
    approvedRequests = new ArrayList<Info>();
    pendingRequests = new ArrayList<Info>();
    sunday = new ArrayList<Info>();
    monday = new ArrayList<Info>();
    tuesday = new ArrayList<Info>();
    wednesday = new ArrayList<Info>();
    thursday = new ArrayList<Info>();
    friday = new ArrayList<Info>();
    saturday = new ArrayList<Info>();
  }

  public void makeRequest(Info r) {
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

  public String display() {
	    String info = "";
	    if (changed) {
	      for (int i = 0; i < approvedRequests.size(); ++i) {
	        info = info + approvedRequests.get(i).toString();
	      }
	    }
	    return info;
	  }
  
}
