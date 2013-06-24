package tafat.engine.interpolatedfunction;

import tafat.engine.Console;


public class InterpolatedFunction {
	public enum OutOfRange {ERROR, NEAREST, REPEATING, CUSTOM, EXTRAPOLATE};

	private OutOfRange outOfRange;
	
	private double minX;
	private double maxX;
	
	private double customValue = Double.NaN;
	
	private InterpolationMethod interpolationMethod;
	
	public InterpolatedFunction(Coordinate[] coordinates, OutOfRange outOfRange){
		this.outOfRange = outOfRange;
		Coordinate[] aux = coordinates;
		if(!SortHandler.isSortedNumberList(aux))
			aux = SortHandler.sortNumberList(aux);
		this.minX = aux[0].x;
		this.maxX = aux[aux.length - 1].x;
	}
	
	public void setInterpolationMethod(InterpolationMethod interpolationMethod){
		this.interpolationMethod = interpolationMethod;
	}
	
	public void setCustomValue(double customValue){
		this.customValue = customValue;	
	}
	
	public double getY (double X){
		if ((X > maxX) || (X < minX))
			return getYOutOfRange(X);
		else 
			return interpolationMethod.getY(X);
	}

	private double getYOutOfRange(double X){
		switch (outOfRange){
		
		case ERROR:
			Console.error("out of range");
			return Double.NaN;
		case NEAREST:
			if(X > maxX)
				return interpolationMethod.getY(maxX);
			else
				return interpolationMethod.getY(minX);
		case REPEATING:
			double auxIndex = X;
			if(auxIndex > maxX)
				while(auxIndex > maxX)
					auxIndex -= Math.abs(maxX - minX);
			else
				while(auxIndex < minX)
					auxIndex += Math.abs(maxX - minX);
			return interpolationMethod.getY(auxIndex);
		case CUSTOM:
			if (Double.isNaN(customValue))
				Console.error("custom value not set, please use setCustomValue after constructor");
			return customValue;
		case EXTRAPOLATE:
			return interpolationMethod.getY(X);
		default:
			return Double.NaN;
		}
	}
	
	public String toString (){
		String out = "";
		out += "* ------ InterpolatedFunction: ------ *\n";
		out +=  "\tMinX: " + minX + "\n";
		out +=  "\tMaxX: " + maxX + "\n";
		out +=  "\tOutOfRange: " + outOfRange.toString() + "\n";
		out +=  "\tInterpolation method: "  + interpolationMethod.getClass().getSimpleName() + "\n";
		if (!Double.isNaN(customValue))
			out+= "\t\tCustom Value: " + customValue + "\n";
		return out;
	}
}
