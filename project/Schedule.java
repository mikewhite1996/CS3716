import java.util.ArrayList;

public class Schedule {
  private ArrayList<Request> approvedRequests;
  private ArrayList<Request> pendingRequests;
  private boolean changed = false;


  public Schedule() {
    approvedRequests = new ArrayList<Request>();
    pendingRequests = new ArrayList<Request>();

  }

  public void makeRequest(Request r) {

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
}
