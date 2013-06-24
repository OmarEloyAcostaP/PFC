package tafat.engine.interpolatedfunction;

import tafat.engine.tools.Lagrange;

public class LagrangeInterpolation extends InterpolationMethod{

	private Lagrange lagrangeInterpolator;
	
	public LagrangeInterpolation (Coordinate[] coordinates){
		lagrangeInterpolator = new Lagrange(getArrayX(coordinates), getArrayY(coordinates));
	}
	
	@Override
	public double getY(double X) {
		return lagrangeInterpolator.evaluate(X);
	}

}
