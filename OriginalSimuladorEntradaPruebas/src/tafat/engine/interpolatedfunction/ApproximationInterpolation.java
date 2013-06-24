package tafat.engine.interpolatedfunction;

import tafat.engine.Console;
import tafat.engine.tools.LeastSquareFit;

public class ApproximationInterpolation extends InterpolationMethod {

	LeastSquareFit leastSquareFitInterpolator;
	
	public ApproximationInterpolation (Coordinate[] coordinates, int order){
		if (order > -1)
			leastSquareFitInterpolator =new LeastSquareFit(getArrayX(coordinates), 
														   getArrayY(coordinates),
														   order);
		else
			Console.error("invalid order");
	}
	
	
	@Override
	public double getY(double X) {
		return leastSquareFitInterpolator.evaluate(X);
	}

}
