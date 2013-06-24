package tafat.engine.statechart;

import java.util.ArrayList;

import tafat.engine.Console;

public class StateChart {

	int currentState = Integer.MIN_VALUE;
	ArrayList <State> states = new ArrayList<State>();
	private static int idGiver = -1;
	public int id;
	public String message;
	
	public StateChart(){
		idGiver++;
		this.id = idGiver;
	}
	
	public void addState(State newState){
		if (existState(newState.id)){
			Console.error("states cannot have same id: " + newState.name);
			return;
		}
		states.add(newState);
	}

	public void addTransition(Transition newTransition){
		if ((!existState(newTransition.source)) || (!existState(newTransition.destination))){
			Console.error("source and/or destination do not exist");
			return;
		}
		getState(newTransition.source).add(newTransition);
	}
	
	public void update(){
		if (existState(getCurrentState())){
			for (Transition transition : getState(getCurrentState()).transitionsTo) {
				if (transition.condition()){
						getState(currentState).exitAction();
						currentState = transition.destination;
						transition.action();
						getState(getCurrentState()).entryAction();
						getState(getCurrentState()).ActivateTransitions();
						return;
				}	
			}
		}
		else
			Console.error(" updating: state not found (probably initial state not set, use setInitialState)");
	}
	
	private State getState(int stateId) {
		for (State state  : states){
			if (state.id == stateId) {
				return state;
			}
		}
		return null;
	}

	public void setCurrentState(int stateId){
		currentState = stateId;
		getState(getCurrentState()).entryAction();
		getState(getCurrentState()).ActivateTransitions();
	}
	
	public int getCurrentState(){
		return currentState;
	}
	
	public void setInitialState(int stateId){
		currentState = stateId;
	}
	
	private boolean existState (int id){
		for (State state  : states){
			if (state.id == id)
				return true;
		}
		return false;
	}
	
	public void receiveMessage (String message){
		this.message = message;
	}
	
	public String toString (){
		String out = "";
		out += "* ------ Statechart: ------ *\n";
		out +=  "\tCurrent State: " + getCurrentState() + "\n";
		for (int i = 0; i < states.size(); i++){
			out += "\t\tState " + i + ":\n";
			out += "\t\t\tID: " + states.get(i).id + "\n";
			out += "\t\t\tName: " + states.get(i).name + "\n";
			out += "\t\t\tConnections: \n";
			for (Transition transition : states.get(i).transitionsTo) {
				if (transition.source == states.get(i).id)
					out += "\t\t\t\tTo " + transition.destination + "\n";	
			}
		}
		return out;
	}
}
