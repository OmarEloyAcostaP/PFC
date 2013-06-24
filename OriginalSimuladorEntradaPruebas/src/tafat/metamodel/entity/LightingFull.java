/*****
Generated automatically by tafat.framework.Translator
Version: 20.09.2011 at 12:29 CEST
*****/
package tafat.metamodel.entity;

import java.text.ParseException;


public class LightingFull extends Lighting{
	
	public enum LightingType {
 INDOOR(0),OUTDOOR(1);
 private double value;
 LightingType(double val)
 {
 	value=val;
 }
 
 public double getValue()
 {
 	return value;
 }
}
public enum PhasesSystem {
 SINGLE_PHASE_AND_NEUTRAL(0),THREE_PHASE_WITHOUT_NEUTRAL(1),THREE_PHASE_AND_NEUTRAL(2);
 private double value;
 PhasesSystem(double val)
 {
 	value=val;
 }
 
 public double getValue()
 {
 	return value;
 }
}
public enum Technology {
 FLUORESCENT(0),STANDARD(1),LOW_CONSUMPTION(2),EMERGENCY(3);
 private double value;
 Technology(double val)
 {
 	value=val;
 }
 
 public double getValue()
 {
 	return value;
 }
}
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
public enum Mode {
 OFF(0),ON(1);
 private double value;
 Mode(double val)
 {
 	value=val;
 }
 
 public double getValue()
 {
 	return value;
 }
}

	
	//Features
public int lampCount;
public LightingType lightingType;
public PhasesSystem phasesSystem;
public Technology technology;
public VoltageLevel voltageLevel;


	//Variables
public double installedPowerUsageRate;
public double intensityRate;
public Mode mode;
public double powerFactor;


	

	public LightingFull(){

}


	public void setDefaultValues() throws ParseException
{
super.setDefaultValues();
lampCount = 2;
lightingType = LightingType.INDOOR;
phasesSystem = PhasesSystem.SINGLE_PHASE_AND_NEUTRAL;
technology = Technology.STANDARD;
voltageLevel = VoltageLevel.LOW;
installedPowerUsageRate = 0;
intensityRate = 1;
powerFactor = 0.0;

}


	public void loadAttribute(String name, String value) throws ParseException
{
if (name.equals("lampCount"))
lampCount = Integer.parseInt(value);
else if (name.equals("lightingType"))
lightingType=LightingType.valueOf(value.toUpperCase());
else if (name.equals("phasesSystem"))
phasesSystem=PhasesSystem.valueOf(value.toUpperCase());
else if (name.equals("technology"))
technology=Technology.valueOf(value.toUpperCase());
else if (name.equals("voltageLevel"))
voltageLevel=VoltageLevel.valueOf(value.toUpperCase());
else if (name.equals("installedPowerUsageRate"))
installedPowerUsageRate = Double.parseDouble(value);
else if (name.equals("intensityRate"))
intensityRate = Double.parseDouble(value);
else if (name.equals("mode"))
mode=Mode.valueOf(value.toUpperCase());
else if (name.equals("powerFactor"))
powerFactor = Double.parseDouble(value);
else
super.loadAttribute(name, value);
}


	

	

	public String toString()
{
String result="";
 result+="<feature name=\"lampCount\" value=\"" + lampCount + "\"/>\n"; 
 result+="<feature name=\"lightingType\" value=\"" + lightingType.toString() + "\"/>\n"; 
 result+="<feature name=\"phasesSystem\" value=\"" + phasesSystem.toString() + "\"/>\n"; 
 result+="<feature name=\"technology\" value=\"" + technology.toString() + "\"/>\n"; 
 result+="<feature name=\"voltageLevel\" value=\"" + voltageLevel.toString() + "\"/>\n"; 
 result+="<feature name=\"installedPowerUsageRate\" value=\"" + installedPowerUsageRate + "\"/>\n"; 
 result+="<feature name=\"intensityRate\" value=\"" + intensityRate + "\"/>\n"; 
 result+="<feature name=\"mode\" value=\"" + mode.toString() + "\"/>\n"; 
 result+="<feature name=\"powerFactor\" value=\"" + powerFactor + "\"/>\n"; 
return result;

}

}

