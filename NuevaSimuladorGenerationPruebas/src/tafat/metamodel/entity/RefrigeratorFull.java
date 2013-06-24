/*****
Generated automatically by tafat.framework.Translator
Version: 20.09.2011 at 12:29 CEST
*****/
package tafat.metamodel.entity;

import java.text.ParseException;

import tafat.engine.conversion.UnitConversor;


public class RefrigeratorFull extends Refrigerator{
	
	public enum Labelling {
 AAAA(0),AAA(1),AA(2),A(3),B(4),C(5),D(6),E(7),F(8),G(9);
 private double value;
 Labelling(double val)
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
 OFF(0),STANDBY(1),ON(2),LOAD_REDUCTION(3),OPEN(4);
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
public enum ThermostatLevel {
 LEVEL_1(1),LEVEL_2(2),LEVEL_3(3),LEVEL_4(4),LEVEL_5(5),LEVEL_6(6);
 private double value;
 ThermostatLevel(double val)
 {
 	value=val;
 }
 
 public double getValue()
 {
 	return value;
 }
}

	
	//Features
public Labelling labelling;
public PhasesSystem phasesSystem;
public VoltageLevel voltageLevel;


	//Variables
public Mode mode;
public double powerFactor;
public double tempRef;// ( dC )
public ThermostatLevel thermostatLevel;// ( dC )


	

	public RefrigeratorFull(){

}


	public void setDefaultValues() throws ParseException
{
super.setDefaultValues();
labelling = Labelling.A;
phasesSystem = PhasesSystem.SINGLE_PHASE_AND_NEUTRAL;
voltageLevel = VoltageLevel.LOW;
powerFactor = 0.0;
tempRef = 0.0;
thermostatLevel = ThermostatLevel.LEVEL_4;

}


	public void loadAttribute(String name, String value) throws ParseException
{
if (name.equals("labelling"))
labelling=Labelling.valueOf(value.toUpperCase());
else if (name.equals("phasesSystem"))
phasesSystem=PhasesSystem.valueOf(value.toUpperCase());
else if (name.equals("voltageLevel"))
voltageLevel=VoltageLevel.valueOf(value.toUpperCase());
else if (name.equals("mode"))
mode=Mode.valueOf(value.toUpperCase());
else if (name.equals("powerFactor"))
powerFactor = Double.parseDouble(value);
else if (name.equals("tempRef"))
tempRef= UnitConversor.parse(value,"dC");
else if (name.equals("thermostatLevel"))
thermostatLevel=ThermostatLevel.valueOf(value.toUpperCase());
else
super.loadAttribute(name, value);
}


	

	

	public String toString()
{
String result="";
 result+="<feature name=\"labelling\" value=\"" + labelling.toString() + "\"/>\n"; 
 result+="<feature name=\"phasesSystem\" value=\"" + phasesSystem.toString() + "\"/>\n"; 
 result+="<feature name=\"voltageLevel\" value=\"" + voltageLevel.toString() + "\"/>\n"; 
 result+="<feature name=\"mode\" value=\"" + mode.toString() + "\"/>\n"; 
 result+="<feature name=\"powerFactor\" value=\"" + powerFactor + "\"/>\n"; 
 result+="<feature name=\"tempRef\" value=\"" + tempRef + "\"/>\n"; 
 result+="<feature name=\"thermostatLevel\" value=\"" + thermostatLevel.toString() + "\"/>\n"; 
return result;

}

}

