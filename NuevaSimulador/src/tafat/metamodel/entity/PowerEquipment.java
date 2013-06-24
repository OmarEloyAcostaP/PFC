/*****
Generated automatically by tafat.framework.Translator
Version: 20.09.2011 at 12:29 CEST
*****/
package tafat.metamodel.entity;


import java.text.ParseException;

import tafat.engine.conversion.UnitConversor;

public abstract class PowerEquipment extends ElectricEquipment{

	//Features
public double installedPower;// ( W )


	//Variables
public double activePower;// ( W )
public double reactivePower;// ( VAr )


	
	
	public void loadAttribute(String name, String value) throws ParseException
{
if (name.equals("installedPower"))
installedPower= UnitConversor.parse(value,"W");
else if (name.equals("activePower"))
activePower= UnitConversor.parse(value,"W");
else if (name.equals("reactivePower"))
reactivePower= UnitConversor.parse(value,"VAr");
else
super.loadAttribute(name, value);
}

	
	public void setDefaultValues() throws ParseException
{
super.setDefaultValues();
installedPower = 0.0;
activePower = 0.0;
reactivePower = 0.0;

}

}

