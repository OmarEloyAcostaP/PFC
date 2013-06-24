/*****
Generated automatically by tafat.framework.Translator
Version: 20.09.2011 at 12:29 CEST
*****/
package tafat.metamodel.entity;

import java.text.ParseException;

import tafat.engine.conversion.UnitConversor;


public class OutdoorFull extends Outdoor{
	
	
	
	//Features
public String coordinates;


	//Variables
public int dayType;
public double effectiveSolarRadiation;// ( kWh/m^2 )
public double solarRadiation;// ( kWh/m^2 )
public double temperature;// ( dC )


	

	public OutdoorFull(){
contentList.add("building");
contentList.add("controlunit");
contentList.add("factory");
contentList.add("industrialestate");
contentList.add("locationsgroup");
contentList.add("neighbourhood");
contentList.add("outdoor");
contentList.add("powerplant");
contentList.add("railwayelectrificationsystem");
contentList.add("residentialarea");
contentList.add("ruralconstruction");
contentList.add("substation");
contentList.add("tradecenter");
contentList.add("transformerstation");
contentList.add("vehicle");

}


	public void setDefaultValues() throws ParseException
{
super.setDefaultValues();
coordinates = "";
dayType = 0;
effectiveSolarRadiation = 0.0;
solarRadiation = 0.0;
temperature = 0.0;

}


	public void loadAttribute(String name, String value) throws ParseException
{
if (name.equals("coordinates"))
coordinates = value;
else if (name.equals("dayType"))
dayType = Integer.parseInt(value);
else if (name.equals("effectiveSolarRadiation"))
effectiveSolarRadiation= UnitConversor.parse(value,"kWh/m^2");
else if (name.equals("solarRadiation"))
solarRadiation= UnitConversor.parse(value,"kWh/m^2");
else if (name.equals("temperature"))
temperature= UnitConversor.parse(value,"dC");
else
super.loadAttribute(name, value);
}


	

	

	public String toString()
{
String result="";
 result+="<feature name=\"coordinates\" value=\"" + coordinates + "\"/>\n"; 
 result+="<feature name=\"dayType\" value=\"" + dayType + "\"/>\n"; 
 result+="<feature name=\"effectiveSolarRadiation\" value=\"" + effectiveSolarRadiation + "\"/>\n"; 
 result+="<feature name=\"solarRadiation\" value=\"" + solarRadiation + "\"/>\n"; 
 result+="<feature name=\"temperature\" value=\"" + temperature + "\"/>\n"; 
return result;

}

}

