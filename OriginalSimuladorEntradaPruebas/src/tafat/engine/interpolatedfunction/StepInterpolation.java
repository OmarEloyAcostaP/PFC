package tafat.engine.interpolatedfunction;


public class StepInterpolation extends InterpolationMethod {

	private Coordinate[] coordinates;
	
	public StepInterpolation(Coordinate[] coordinates){
		this.coordinates = coordinates;
	}
	
	@Override
	public double getY(double X) {
		double Y = coordinates[0].y;
		for (int i = 0; i < coordinates.length; i++) {
			if(coordinates[i].x <= X)
				Y = coordinates[i].y;
			else
				break;
		}
		return Y;
	}
}
