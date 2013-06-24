package tafat.engine.timeout;

public class Timeout {
	public int id;
	public int time;
	public TimeoutHandler handler;
	public Object data;
	public boolean stopped = false;

	public Timeout(int id, int time, TimeoutHandler handler, Object data){
		this.id = id;
		this.time = time;
		this.handler = handler;
		this.data = data;
	}

}
