/*****
Generated automatically by tafat.framework.Translator
Version: 20.09.2011 at 12:29 CEST
*****/
package tafat.metamodel.entity;

import java.text.ParseException;

import tafat.engine.conversion.UnitConversor;


public class TvFull extends Tv{
	
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
 STANDARD(0),LOW_CONSUMPTION(1);
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
public enum TypeTV {
 CRT(0),DLP(1),LCD(2),PDP(3),LED(4);
 private double value;
 TypeTV(double val)
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
public PhasesSystem phasesSystem;
public double size;// ( inch )
public double standbyPower;// ( W )
public Technology technology;// ( W )
public TypeTV typeTV;// ( W )
public VoltageLevel voltageLevel;// ( W )


	//Variables
public Mode mode;
public double powerFactor;


	

	public TvFull(){

}


	public void setDefaultValues() throws ParseException
{
super.setDefaultValues();
phasesSystem = PhasesSystem.SINGLE_PHASE_AND_NEUTRAL;
size = 32;
standbyPower = 3;
technology = Technology.STANDARD;
typeTV = TypeTV.LCD;
voltageLevel = VoltageLevel.LOW;
powerFactor = 0.0;

}


	public void loadAttribute(String name, String value) throws ParseException
{
if (name.equals("phasesSystem"))
phasesSystem=PhasesSystem.valueOf(value.toUpperCase());
else if (name.equals("size"))
size= UnitConversor.parse(value,"inch");
else if (name.equals("standbyPower"))
standbyPower= UnitConversor.parse(value,"W");
else if (name.equals("technology"))
technology=Technology.valueOf(value.toUpperCase());
else if (name.equals("typeTV"))
typeTV=TypeTV.valueOf(value.toUpperCase());
else if (name.equals("voltageLevel"))
voltageLevel=VoltageLevel.valueOf(value.toUpperCase());
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
 result+="<feature name=\"phasesSystem\" value=\"" + phasesSystem.toString() + "\"/>\n"; 
 result+="<feature name=\"size\" value=\"" + size + "\"/>\n"; 
 result+="<feature name=\"standbyPower\" value=\"" + standbyPower + "\"/>\n"; 
 result+="<feature name=\"technology\" value=\"" + technology.toString() + "\"/>\n"; 
 result+="<feature name=\"typeTV\" value=\"" + typeTV.toString() + "\"/>\n"; 
 result+="<feature name=\"voltageLevel\" value=\"" + voltageLevel.toString() + "\"/>\n"; 
 result+="<feature name=\"mode\" value=\"" + mode.toString() + "\"/>\n"; 
 result+="<feature name=\"powerFactor\" value=\"" + powerFactor + "\"/>\n"; 
return result;

}

}

