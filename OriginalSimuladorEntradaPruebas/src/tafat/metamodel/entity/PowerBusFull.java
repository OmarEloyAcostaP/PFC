/*****
Generated automatically by tafat.framework.Translator
Version: 20.09.2011 at 12:29 CEST
*****/
package tafat.metamodel.entity;

import java.text.ParseException;
import java.util.ArrayList;

import tafat.engine.conversion.UnitConversor;
import tafat.metamodel.connection.PowerConnectionFull;


public class PowerBusFull extends PowerBus{
	
	public enum VoltageLevel {
 LOW(0),MEDIUM(1),HIGH(2);
 private double value;
 VoltageLevel(double val)
 {
 	value=val;
 }
 
 public double getValue()
 {
 	return value;
 }
}
public enum BusType {
 SLACK(0),PV(1),PQ(2);
 private double value;
 BusType(double val)
 {
 	value=val;
 }
 
 public double getValue()
 {
 	return value;
 }
}

	
	//Features
public VoltageLevel voltageLevel;


	//Variables
public double activePower;// ( W )
public BusType busType;// ( W )
public double reactivePower;// ( VAr )


	//Context Elements: begin
public PowerConnectionFull powerConnection;
public ArrayList<PowerEquipment> powerEquipmentList = new ArrayList<PowerEquipment>();
//Context Elements: end

	public PowerBusFull(){

}


	public void setDefaultValues() throws ParseException
{
super.setDefaultValues();
voltageLevel = VoltageLevel.LOW;
activePower = 0.0;
busType = BusType.PV;
reactivePower = 0.0;

}


	public void loadAttribute(String name, String value) throws ParseException
{
if (name.equals("voltageLevel"))
voltageLevel=VoltageLevel.valueOf(value.toUpperCase());
else if (name.equals("activePower"))
activePower= UnitConversor.parse(value,"W");
else if (name.equals("busType"))
busType=BusType.valueOf(value.toUpperCase());
else if (name.equals("reactivePower"))
reactivePower= UnitConversor.parse(value,"VAr");
else
super.loadAttribute(name, value);
}


	

	

	public String toString()
{
String result="";
 result+="<feature name=\"voltageLevel\" value=\"" + voltageLevel.toString() + "\"/>\n"; 
 result+="<feature name=\"activePower\" value=\"" + activePower + "\"/>\n"; 
 result+="<feature name=\"busType\" value=\"" + busType.toString() + "\"/>\n"; 
 result+="<feature name=\"reactivePower\" value=\"" + reactivePower + "\"/>\n"; 
return result;

}

}

