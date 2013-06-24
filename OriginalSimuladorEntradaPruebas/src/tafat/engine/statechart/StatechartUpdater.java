package tafat.engine.statechart;

import java.util.ArrayList;

import tafat.engine.timeout.TimeoutCyclic;

public class StatechartUpdater {
	private ArrayList <StatechartWithStep> statechartList = new ArrayList <StatechartWithStep> ();
	private static StatechartUpdater instance = null;
	
	private StatechartUpdater(){
		this.statechartList.clear();
	}
	
	public static void createInstance (){
		if (instance==null)
			instance = new StatechartUpdater();
	}
	
	public static StatechartUpdater getInstance(){
		return instance;
	}
	
	public void tick (){
		for (StatechartWithStep statechartWithStep : instance.statechartList){
			if (statechartWithStep.timeoutCyclic == null)
				statechartWithStep.statechart.update();
		}
	}
	
	public void startUpdate (StateChart statechart){
		instance.statechartList.add(new StatechartWithStep (statechart, null));
	}
	
	public void startUpdate (StateChart statechart, int step){
		instance.statechartList.add(new StatechartWithStep (statechart, step));
	}
	
	public void stopUpdate (StateChart statechart){
		StatechartWithStep stateChartToStop = null;
		for (StatechartWithStep statechartElement : statechartList){
			if (statechartElement.statechart.id == statechart.id)
				stateChartToStop = statechartElement;
		}
		statechartList.remove(stateChartToStop);
	}
	
	private class StatechartWithStep{
		StateChart statechart;
		TimeoutCyclic timeoutCyclic = null;
		
		private StatechartWithStep (StateChart statechartin, Integer step){
			this.statechart = statechartin;
			if (step != null){
				timeoutCyclic = new TimeoutCyclic (step) {
					@Override
					public void action() {
						statechart.update();
					}
				};
			}
		}
	}

	public static void clear() {
		instance = null;
	}
}
