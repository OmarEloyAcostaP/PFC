package tafat.engine.statechart;

import java.util.ArrayList;

import tafat.engine.Console;

public abstract class State {
	
	String name;
	int id;
	
	ArrayList <Transition> transitionsTo = new ArrayList <Transition> ();
	
	public State(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public abstract void entryAction();
	public abstract void exitAction();

	public void add(Transition newTransition) {
		for (Transition transition : transitionsTo) {
			if (transition.destination == newTransition.destination)
				Console.out("WARNING: transitions with same source and destination");
		}
		transitionsTo.add(newTransition);
	}
	
	public void ActivateTransitionTo (int destination){
		for (Transition transition : transitionsTo) {
			if (transition.destination == destination)
				transition.activate();
		}
	}
	
	public void ActivateTransitions (){
		for (Transition transition : transitionsTo)
				transition.activate();
	}
}
