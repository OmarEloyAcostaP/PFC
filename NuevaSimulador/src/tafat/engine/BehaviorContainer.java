package tafat.engine;


import java.lang.reflect.Method;
import java.util.ArrayList;

public class BehaviorContainer extends ModelObject {
	public String name;
	public String release = "";
	public Behavior behavior;
	public Integer step = 1;
	public Integer countdown = 0;
	public ArrayList<String> settingList = new ArrayList<String>();
	
	private int lastTick = 0;

	protected void loadAttribute(String name, String value) {
		if (name.equals("name"))
			this.name = value;
		else if (name.equals("release"))
			this.release = value;
		else if (name.equals("step")){
			this.step = Integer.parseInt(value);
			settingList.add("step=" + this.step);
		}
		else
			settingList.add(name + "=" + value);
	}

	public void init()  {
		if (name == null) {
			Console.error(this.getFullPath() + " name is not specified");
			return;			
		}
		String behaviorClassName = name + release;
		behavior = createInstance(behaviorClassName);
		if (behavior == null) return;
		if (owner == null) {
			try {
				Console.error(behaviorClassName + " target does not exist");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;			
		}
		
		for (String setting : settingList) {
			String[] nameAndValue = setting.split("=");
			behavior.loadAttribute(nameAndValue[0], nameAndValue[1]);
		}
		behavior.init(owner);
		Console.out(behaviorClassName + " initialized");
		// FORCE TO TICK AT SECOND 0!
		lastTick = - step;
	}

	public void tick(Integer time) {
		if (countdown == 0)
			countdown = step;
		countdown -= (time - lastTick);
		lastTick = time;
	}
	
	public void fastTick (Integer time){
		tick(time);
	}

	private Behavior createInstance(String name) {
		Class<? extends Behavior> behaviorClass = null;
		try {
			behaviorClass = Class.forName("tafat.metamodel.behavior." + name).asSubclass(Behavior.class);
		}
		catch (Throwable e) {
			Console.error(name + " not found");
			return null;
		}

		try {
		    Method createMethod = behaviorClass.getMethod("newInstance");
			Object object = createMethod.invoke(null);
			return (Behavior) object;
		}
		catch (Throwable e) {
			Console.error(e + name + " could not be instantiated");
			return null;
		}
	}
	
	public void terminate(){
		if (behavior != null)
			behavior.terminate();
	}
}
