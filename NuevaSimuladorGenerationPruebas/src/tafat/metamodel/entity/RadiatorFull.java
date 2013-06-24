/*****
Generated automatically by tafat.framework.Translator
Version: 20.09.2011 at 12:29 CEST
*****/
package tafat.metamodel.entity;

import java.text.ParseException;

import tafat.engine.conversion.UnitConversor;


public class RadiatorFull extends Radiator{
	
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
 OFF(0),STANDBY(1),ON(2);
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
public double installedPower;// ( W )
public PhasesSystem phasesSystem;// ( W )
public double ratedPower;// ( W )
public double standbyPower;// ( W )
public VoltageLevel voltageLevel;// ( W )


	//Variables
public double intensityRate;
public Mode mode;
public double powerFactor;
public double referenceTemperature;// ( dC )


	//Context Elements: begin
public BuildingFull building;
//Context Elements: end

	public RadiatorFull(){

}


	public void setDefaultValues() throws ParseException
{
super.setDefaultValues();
installedPower = 1000;
phasesSystem = PhasesSystem.SINGLE_PHASE_AND_NEUTRAL;
ratedPower = 100;
standbyPower = 10;
voltageLevel = VoltageLevel.LOW;
intensityRate = 1;
powerFactor = 0.0;
referenceTemperature = 0.0;

}


	public void loadAttribute(String name, String value) throws ParseException
{
if (name.equals("installedPower"))
installedPower= UnitConversor.parse(value,"W");
else if (name.equals("phasesSystem"))
phasesSystem=PhasesSystem.valueOf(value.toUpperCase());
else if (name.equals("ratedPower"))
ratedPower= UnitConversor.parse(value,"W");
else if (name.equals("standbyPower"))
standbyPower= UnitConversor.parse(value,"W");
else if (name.equals("voltageLevel"))
voltageLevel=VoltageLevel.valueOf(value.toUpperCase());
else if (name.equals("intensityRate"))
intensityRate = Double.parseDouble(value);
else if (name.equals("mode"))
mode=Mode.valueOf(value.toUpperCase());
else if (name.equals("powerFactor"))
powerFactor = Double.parseDouble(value);
else if (name.equals("referenceTemperature"))
referenceTemperature= UnitConversor.parse(value,"dC");
else
super.loadAttribute(name, value);
}


	

	public void init() throws ParseException {

super.init();
building = (BuildingFull) findOwner(BuildingFull.class);
}


	public String toString()
{
String result="";
 result+="<feature name=\"installedPower\" value=\"" + installedPower + "\"/>\n"; 
 result+="<feature name=\"phasesSystem\" value=\"" + phasesSystem.toString() + "\"/>\n"; 
 result+="<feature name=\"ratedPower\" value=\"" + ratedPower + "\"/>\n"; 
 result+="<feature name=\"standbyPower\" value=\"" + standbyPower + "\"/>\n"; 
 result+="<feature name=\"voltageLevel\" value=\"" + voltageLevel.toString() + "\"/>\n"; 
 result+="<feature name=\"intensityRate\" value=\"" + intensityRate + "\"/>\n"; 
 result+="<feature name=\"mode\" value=\"" + mode.toString() + "\"/>\n"; 
 result+="<feature name=\"powerFactor\" value=\"" + powerFactor + "\"/>\n"; 
 result+="<feature name=\"referenceTemperature\" value=\"" + referenceTemperature + "\"/>\n"; 
return result;

}

}

