package tafat.engine;

public interface Behavior  {
	
	public abstract void init(ModelObject target);
	public abstract void tickOn(Integer time);
	public abstract void tickOff(Integer time);
	public abstract void terminate();
	public abstract void loadAttribute(String name, String value);

}
