/*****
Generated automatically by tafat.framework.Translator
Version: 20.09.2011 at 12:29 CEST
*****/
package tafat.metamodel.entity;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import tafat.engine.DateParser;
import tafat.engine.conversion.UnitConversor;


public class HouseholdFull extends Household{
	
	public enum ElectrificationLevel {
 BASIC(0),HIGH(1);
 private double value;
 ElectrificationLevel(double val)
 {
 	value=val;
 }
 
 public double getValue()
 {
 	return value;
 }
}

	
	//Features
public String address;
public double areaFloor;// ( m^2 )
public Date constructionDate = new Date();// ( m^2 )
public ElectrificationLevel electrificationLevel;// ( m^2 )
public double height;// ( meter )
public Date renovationDate = new Date();// ( meter )


	//Variables
public int personCount;


	//Context Elements: begin
public BuildingFull building;
public PowerBusFull powerBus;
public ArrayList<PowerEquipment> powerEquipmentList = new ArrayList<PowerEquipment>();
//Context Elements: end

	public HouseholdFull(){
contentList.add("electricitymeter");
contentList.add("energyboxmillener");
contentList.add("gasmeter");
contentList.add("powerbus");
contentList.add("powerequipment");
contentList.add("room");
contentList.add("smartmeter");
contentList.add("watermeter");

}


	public void setDefaultValues() throws ParseException
{
super.setDefaultValues();
address = "";
areaFloor = 100;
constructionDate = DateParser.parseDate("01/01/1970");
height = 3;
renovationDate = DateParser.parseDate("01/01/1970");
personCount = 0;

}


	public void loadAttribute(String name, String value) throws ParseException
{
if (name.equals("address"))
address = value;
else if (name.equals("areaFloor"))
areaFloor= UnitConversor.parse(value,"m^2");
else if (name.equals("constructionDate"))
constructionDate = DateParser.parseDate(value);
else if (name.equals("electrificationLevel"))
electrificationLevel=ElectrificationLevel.valueOf(value.toUpperCase());
else if (name.equals("height"))
height= UnitConversor.parse(value,"meter");
else if (name.equals("renovationDate"))
renovationDate = DateParser.parseDate(value);
else if (name.equals("personCount"))
personCount = Integer.parseInt(value);
else
super.loadAttribute(name, value);
}


	

	public void init() throws ParseException {

super.init();

building = (BuildingFull) findOwner(BuildingFull.class);
powerBus = (PowerBusFull) findChild(PowerBusFull.class);

for (Object object : collect(PowerEquipment.class, true)) {
	powerEquipmentList.add((PowerEquipment) object);
}

if (powerBus != null) {
	for (PowerEquipment powerEquipment : powerEquipmentList) {
		//if (powerBus.voltageLevel == powerEquipment.voltageLevel) {
			powerBus.powerEquipmentList.add(powerEquipment);
		//} else {
		//	Console.error(
		//			powerEquipment.getFullPath()
		//					+ " voltageLevel is not valid for "
		//					+ getFullPath());
		//} 
	}
}
}


	public String toString()
{
String result="";
 result+="<feature name=\"address\" value=\"" + address + "\"/>\n"; 
 result+="<feature name=\"areaFloor\" value=\"" + areaFloor + "\"/>\n"; 
 result+="<feature name=\"constructionDate\" value=\"" + constructionDate.toString() + "\"/>\n"; 
 result+="<feature name=\"electrificationLevel\" value=\"" + electrificationLevel.toString() + "\"/>\n"; 
 result+="<feature name=\"height\" value=\"" + height + "\"/>\n"; 
 result+="<feature name=\"renovationDate\" value=\"" + renovationDate.toString() + "\"/>\n"; 
 result+="<feature name=\"personCount\" value=\"" + personCount + "\"/>\n"; 
return result;

}

}

