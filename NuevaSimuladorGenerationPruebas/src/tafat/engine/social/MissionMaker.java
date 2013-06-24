package tafat.engine.social;

public abstract class MissionMaker {
	public abstract OrderAndData checkMissions();
	public abstract void receiveMessage(Object data);
}
