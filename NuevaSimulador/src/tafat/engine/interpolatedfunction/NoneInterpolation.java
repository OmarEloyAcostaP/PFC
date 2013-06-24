package tafat.engine.interpolatedfunction;


public class NoneInterpolation extends InterpolationMethod {

	private Coordinate[] coordinates;
	private double TOLERANCE;
	
	public NoneInterpolation (Coordinate[] coordinates, double tolerance){
		this.coordinates = coordinates;
		this.TOLERANCE = tolerance;
	}
	
	@Override
	public double getY(double X) {
		for (Coordinate coordinate : coordinates){
			if (Math.abs(coordinate.x - X) < TOLERANCE){
				return coordinate.y;
			}
		}
		return Double.NaN;
	}

}
