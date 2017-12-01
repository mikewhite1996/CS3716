public class InfoReq {
  private Info fo;
  private String name;
  private String priority;
  private String semester;

  public InfoReq(Info i, String n, String p, String s) {
    fo = i;
    name = n;
    priority = p;
    semester = s;
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
