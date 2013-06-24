package tafat.engine.interpolatedfunction;

import java.util.ArrayList;

public abstract class Parser {

	protected ArrayList <Coordinate> coordinatesList = new ArrayList <Coordinate> ();
	
	private double TOLERANCE = 0.001;

	public abstract Coordinate[] loadData(boolean avoidFirstRow);
	
	protected boolean existsX (double X){
		for (Coordinate coordinate : coordinatesList){
			if (Math.abs(coordinate.x - X) < TOLERANCE){
				return true;
			}
		}
		return false;
	}
	
	public void setTolerance (double tolerance){
		this.TOLERANCE = tolerance;
	}
	
	public Coordinate[] arrayListToArray(){
		Coordinate[] out = new Coordinate[coordinatesList.size()];
		for (int i = 0; i < coordinatesList.size(); i++)
			out[i] = coordinatesList.get(i);
		return out;
	}
}
