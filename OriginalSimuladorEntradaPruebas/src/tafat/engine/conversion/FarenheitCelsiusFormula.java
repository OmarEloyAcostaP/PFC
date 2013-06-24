package tafat.engine.conversion;

public class FarenheitCelsiusFormula extends UnitFormula {

	public Double convert(Double value) {
		return (value-32)/1.8;
	}
	
}
