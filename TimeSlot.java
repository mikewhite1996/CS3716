import java.util.ArrayList;

public class TimeSlot {
  private Block startBlock;
  private Block endBlock;
  private ArrayList<Block> range = new ArrayList<Block>();


  public TimeSlot(Block start, Block end) {
    startBlock = start;
    endBlock = end;
    int startIndex = startBlock.ordinal();
    int endIndex = endBlock.ordinal();


    for (Block b: Block.values()) {
      if (b.ordinal() >= startIndex && b.ordinal() <= endIndex)
      range.add(b);
    }
  }

  public void getByString() {
    for (Block b: Block.values()) {
      if (b.equals("9am - 10am")) {
        System.out.println("found match for '9am - 10am'");
      }
    }
  }

  /*public boolean equals(Object other) {
    (!(other instanceof TimeSlot)) {
      return false;
    }
    TimeSlot check = (TimeSlot) other;
    return this.startBlock
  }*/
//unfinished
  public void printBlocks() {
    for(int i = 0; i < range.size(); ++i) {
      String letter = range.get(i).toString();
      System.out.println(range.get(i).toString());
    }
  }

  public ArrayList<Block> getRange() {
    return range;
  }





  public Block getStartBlock() {
    return startBlock;
  }

  public Block getEndBlock() {
    return endBlock;
  }

  /*public void getBlockTime() {
    switch (block) {
      case A:
      System.out.println(stakeholder + ": 9am-10am");
      break;

      case B:
      System.out.println(stakeholder +": 10am-11am");
      break;

      case C:
      System.out.println(stakeholder + ": 11am-12pm");
      break;

      case D:
      System.out.println(stakeholder + ": 12pm-1pm");
      break;

      case E:
      System.out.println(stakeholder + ": 1pm-2pm");
      break;

      case F:
      System.out.println(stakeholder + ": 2pm-3pm");
      break;

      case G:
      System.out.println(stakeholder + ": 3pm-4pm");
      break;

      case H:
      System.out.println(stakeholder + ": 4pm-5pm");
      break;

      case I:
      System.out.println(stakeholder + ": 5pm-6pm");
      break;

      case J:
      System.out.println(stakeholder + ": 6pm-7pm");
      break;

      case K:
      System.out.println(stakeholder + ": 7pm-8pm");
      break;

      case L:
      System.out.println(stakeholder + ": 8pm-9pm");
      break;

      case M:
      System.out.println(stakeholder + ": 9pm-10pm");
      break;
    }
  }*/
}
