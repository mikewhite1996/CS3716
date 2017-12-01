import java.io.*;
public class Group implements Serializable{
	private String s;
	
	public Group(String s){
		this.s = s;
	}
	
	public String getName(String s){
		return s;
	}
}