package tafat.engine;

public class Notification{
	public int id;
	public String notify;
	public Object data;
	
	public Notification (int id, String notify, Object data){
		this.id = id;
		this.notify = notify;
		this.data = data;
	}
}