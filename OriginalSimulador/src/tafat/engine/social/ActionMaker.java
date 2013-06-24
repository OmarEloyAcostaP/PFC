package tafat.engine.social;

import tafat.engine.ModelObject;

public abstract class ActionMaker {
	public abstract OrderAndData execute (OrderAndData orderAndData);
	public abstract void createContext (ModelObject object);
	public abstract void receiveMessage (Object data);
}
