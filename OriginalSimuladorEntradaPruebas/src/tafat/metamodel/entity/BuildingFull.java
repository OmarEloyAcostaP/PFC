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


public class BuildingFull extends Building{
	
	
	
	//Features
public String address;
public double alphaFloor;// ( W/(m^2K) )
public double alphaRoof;// ( W/(m^2K) )
public double alphaWall;// ( W/(m^2K) )
public double alphaWindow;// ( W/(m^2K) )
public double areaFloor;// ( m^2 )
public double areaRoof;// ( m^2 )
public double areaWall;// ( m^2 )
public double areaWindow;// ( m^2 )
public Date constructionDate = new Date();// ( m^2 )
public int floorCount;// ( m^2 )
public Date renovationDate = new Date();// ( m^2 )
public double volume;// ( m^3 )


	//Variables
public int personCount;
public double referenceTemperature;// ( dC )
public double roofInsolation;// ( kWh/m^2 )
public double temperature;// ( dC )
public double wallInsolation;// ( kWh/m^2 )
public double windowInsolation;// ( kWh/m^2 )


	//Context Elements: begin
public LocationsGroupFull locationsGroup;
public OutdoorFull outdoor;
public PowerBusFull powerBus;
public ArrayList<PowerEquipment> powerEquipmentList = new ArrayList<PowerEquipment>();
//Context Elements: end

	public BuildingFull(){
contentList.add("commonhold");
contentList.add("household");
contentList.add("powerbus");
contentList.add("servicehold");
contentList.add("wildcard");

}


	public void setDefaultValues() throws ParseException
{
super.setDefaultValues();
address = "";
alphaFloor = 0;
alphaRoof = 0;
alphaWall = 0;
alphaWindow = 0;
areaFloor = 100;
areaRoof = 100;
areaWall = 10;
areaWindow = 1;
constructionDate = DateParser.parseDate("01/01/1970");
floorCount = 1;
renovationDate = DateParser.parseDate("01/01/1970");
volume = 300;
personCount = 0;
referenceTemperature = 0.0;
roofInsolation = 0.0;
temperature = 0.0;
wallInsolation = 0.0;
windowInsolation = 0.0;

}


	public void loadAttribute(String name, String value) throws ParseException
{
if (name.equals("address"))
address = value;
else if (name.equals("alphaFloor"))
alphaFloor= UnitConversor.parse(value,"W/(m^2K)");
else if (name.equals("alphaRoof"))
alphaRoof= UnitConversor.parse(value,"W/(m^2K)");
else if (name.equals("alphaWall"))
alphaWall= UnitConversor.parse(value,"W/(m^2K)");
else if (name.equals("alphaWindow"))
alphaWindow= UnitConversor.parse(value,"W/(m^2K)");
else if (name.equals("areaFloor"))
areaFloor= UnitConversor.parse(value,"m^2");
else if (name.equals("areaRoof"))
areaRoof= UnitConversor.parse(value,"m^2");
else if (name.equals("areaWall"))
areaWall= UnitConversor.parse(value,"m^2");
else if (name.equals("areaWindow"))
areaWindow= UnitConversor.parse(value,"m^2");
else if (name.equals("constructionDate"))
constructionDate = DateParser.parseDate(value);
else if (name.equals("floorCount"))
floorCount = Integer.parseInt(value);
else if (name.equals("renovationDate"))
renovationDate = DateParser.parseDate(value);
else if (name.equals("volume"))
volume= UnitConversor.parse(value,"m^3");
else if (name.equals("personCount"))
personCount = Integer.parseInt(value);
else if (name.equals("referenceTemperature"))
referenceTemperature= UnitConversor.parse(value,"dC");
else if (name.equals("roofInsolation"))
roofInsolation= UnitConversor.parse(value,"kWh/m^2");
else if (name.equals("temperature"))
temperature= UnitConversor.parse(value,"dC");
else if (name.equals("wallInsolation"))
wallInsolation= UnitConversor.parse(value,"kWh/m^2");
else if (name.equals("windowInsolation"))
windowInsolation= UnitConversor.parse(value,"kWh/m^2");
else
super.loadAttribute(name, value);
}


	

	public void init() throws ParseException {

super.init();

locationsGroup = (LocationsGroupFull) findOwner(LocationsGroupFull.class);

outdoor = (OutdoorFull) findOwner(OutdoorFull.class);
powerBus = (PowerBusFull) findChild(PowerBusFull.class);

	if (outdoor == null) {
		return;
	}

for (Object object : collect(PowerEquipment.class, true))
	powerEquipmentList.add((PowerEquipment) object);

	if (powerBus == null) {
		return;
	}

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


	public String toString()
{
String result="";
 result+="<feature name=\"address\" value=\"" + address + "\"/>\n"; 
 result+="<feature name=\"alphaFloor\" value=\"" + alphaFloor + "\"/>\n"; 
 result+="<feature name=\"alphaRoof\" value=\"" + alphaRoof + "\"/>\n"; 
 result+="<feature name=\"alphaWall\" value=\"" + alphaWall + "\"/>\n"; 
 result+="<feature name=\"alphaWindow\" value=\"" + alphaWindow + "\"/>\n"; 
 result+="<feature name=\"areaFloor\" value=\"" + areaFloor + "\"/>\n"; 
 result+="<feature name=\"areaRoof\" value=\"" + areaRoof + "\"/>\n"; 
 result+="<feature name=\"areaWall\" value=\"" + areaWall + "\"/>\n"; 
 result+="<feature name=\"areaWindow\" value=\"" + areaWindow + "\"/>\n"; 
 result+="<feature name=\"constructionDate\" value=\"" + constructionDate.toString() + "\"/>\n"; 
 result+="<feature name=\"floorCount\" value=\"" + floorCount + "\"/>\n"; 
 result+="<feature name=\"renovationDate\" value=\"" + renovationDate.toString() + "\"/>\n"; 
 result+="<feature name=\"volume\" value=\"" + volume + "\"/>\n"; 
 result+="<feature name=\"personCount\" value=\"" + personCount + "\"/>\n"; 
 result+="<feature name=\"referenceTemperature\" value=\"" + referenceTemperature + "\"/>\n"; 
 result+="<feature name=\"roofInsolation\" value=\"" + roofInsolation + "\"/>\n"; 
 result+="<feature name=\"temperature\" value=\"" + temperature + "\"/>\n"; 
 result+="<feature name=\"wallInsolation\" value=\"" + wallInsolation + "\"/>\n"; 
 result+="<feature name=\"windowInsolation\" value=\"" + windowInsolation + "\"/>\n"; 
return result;

}

}

