package tafat.engine.interpolatedfunction;

import tafat.engine.tools.Spline;

public class SplineInterpolation extends InterpolationMethod {

	private Spline splineInterpolator;
	
	public SplineInterpolation(Coordinate[] coordinates){
		splineInterpolator = new Spline(getArrayX(coordinates),getArrayY(coordinates));
	}
	
	@Override
	public double getY(double X) {
		return splineInterpolator.evaluate(X);
	}
}
