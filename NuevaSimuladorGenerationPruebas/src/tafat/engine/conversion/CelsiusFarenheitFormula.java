package tafat.engine.conversion;

public class CelsiusFarenheitFormula extends UnitFormula {

	public Double convert(Double value) {
		return value*1.8 + 32;
	}
	
}
