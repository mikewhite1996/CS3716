import java.util.ArrayList;
import java.io.*;

public class TimeSlot implements Serializable {
  private Block_Sch startBlock;
  private Block_Sch endBlock;
  private ArrayList<Block_Sch> range = new ArrayList<Block_Sch>();


  public TimeSlot(Block_Sch start, Block_Sch end) {
    startBlock = start;
    endBlock = end;
    int startIndex = startBlock.ordinal();
    int endIndex = endBlock.ordinal();
    for (Block_Sch b: Block_Sch.values()) {
      if (b.ordinal() >= startIndex && b.ordinal() <= endIndex)
      range.add(b);
    }
  }

  public void getByString() {
	    for (Block_Sch b: Block_Sch.values()) {
	      if (b.equals("9am - 10am")) {
	        System.out.println("found match for '9am - 10am'");
	      }
	    }
	  }


    public boolean equals(Object other) {
      if (!(other instanceof TimeSlot)) {
        return false;
      }
      TimeSlot check = (TimeSlot) other;
      return this.startBlock.equals(check.startBlock)
            && this.endBlock.equals(check.endBlock);
    }


    public void printBlocks() {
      for(int i = 0; i < range.size(); ++i) {
        String letter = range.get(i).toString();
        System.out.println(range.get(i).toString());
      }
    }

    public ArrayList<Block_Sch> getRange() {
      return range;
    }





    public Block_Sch getStartBlock() {
      return startBlock;
    }

    public Block_Sch getEndBlock() {
      return endBlock;
    }

}
