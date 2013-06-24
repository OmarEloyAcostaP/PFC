/*****
Generated automatically by tafat.framework.Translator
Version: 20.09.2011 at 12:29 CEST
*****/
package tafat.metamodel.entity;


import java.text.ParseException;

public abstract class PowerConsumer extends PowerEquipment{

	//Features
public double heatGainFraction;


	

	
	
	public void loadAttribute(String name, String value) throws ParseException
{
if (name.equals("heatGainFraction"))
heatGainFraction = Double.parseDouble(value);
else
super.loadAttribute(name, value);
}

	
	public void setDefaultValues() throws ParseException
{
super.setDefaultValues();
heatGainFraction = 1;

}

}

