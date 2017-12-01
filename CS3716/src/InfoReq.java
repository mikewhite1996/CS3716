public class InfoReq {
  private Info fo;
  private String name;
  private String priority;
  private String semester;
  private String room;

  public InfoReq(Info i, String n, String p, String s, String r) {
    fo = i;
    name = n;
    priority = p;
    semester = s;
    room = r;
  }


  public Info getReqInfo() {
    return fo;
  }

  public String getReqName() {
    return name;
  }

  public String getReqPriority() {
    return priority;
  }

  public String getReqSemester() {
    return semester;
  }

}
