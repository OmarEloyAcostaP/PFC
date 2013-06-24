package tafat.engine.social;

import java.util.ArrayList;

public abstract class DecisionMaker {
	public abstract ArrayList<OrderAndData> checkActions(OrderAndData orderAndData);
	public abstract void receiveMessage(Object data);
}
