package tafat.engine.interpolatedfunction;

public class LinearInterpolation extends InterpolationMethod {

	private Coordinate[] coordinates;
	private double minX;
	private double maxX;
	
	public LinearInterpolation (Coordinate[] coordinates){
		this.coordinates = coordinates;
		if(!SortHandler.isSortedNumberList(this.coordinates))
			this.coordinates = SortHandler.sortNumberList(this.coordinates);
		this.minX = this.coordinates[0].x;
		this.maxX = this.coordinates[this.coordinates.length - 1].x;
	}
	
	@Override
	public double getY(double X) {
		if ((X <= maxX) && (X >= minX)){
			for (int i = 0; i < coordinates.length-1; i++) {
				if((X >= coordinates[i].x) && (X <= coordinates[i+1].x))
					return getRectValue(coordinates[i], coordinates[i+1], X);
			}
		}
		else{
			if(X > maxX)
				return getRectValue(coordinates[coordinates.length - 2], 
						            coordinates[coordinates.length - 1], 
						            X);
			else
				return getRectValue(coordinates[0], 
			            coordinates[1], 
			            X);
		}
		return Double.NaN;
	}
	
	private double getRectValue(Coordinate c1, Coordinate C2, double X){
		double x1 = c1.x;
		double y1 = c1.y;
		double x2 = C2.x;
		double y2 = C2.y;
		
		double xdifference = x1 - x2;
		double ydifference = y1 - y2;
		
		double numerator = ydifference * X - ydifference * x1 + xdifference * y1;
		
		return numerator/xdifference;
	}
}
