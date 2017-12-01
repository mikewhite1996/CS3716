public class GettingRequest{
	public Info s;
	public GettingRequest(Info s) {
		this.s = s;
	}
	
	
	public Day getDay() {
		return s.getTheDay();
	}
	
	public Room getRoom() {
		return s.getTheRoom();
	}
	public TimeSlot getBlock() {
		return s.getTheTimeSlot();
	}
	
	

}