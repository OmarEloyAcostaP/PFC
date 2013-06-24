package tafat.engine.result;

public class Write_Handler_Storage {
	public String objectId;
	double currentValue;
	int times;
	boolean isDouble = true;
	
	public Write_Handler_Storage(String objectId){
		this.objectId = objectId;
		currentValue = 0;
		times = 0;
	}
	
	public void addValue (double value){
		if (Double.isNaN(value))
			isDouble = false;
		currentValue += value;
		times++;
	}
	
	public double getValue (){
		double toReturn = currentValue / times;
		currentValue = 0;
		times = 0;
		return toReturn;
	}
}
