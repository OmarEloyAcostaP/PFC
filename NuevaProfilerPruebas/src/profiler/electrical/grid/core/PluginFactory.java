package profiler.electrical.grid.core;

import java.util.HashMap;

import profiler.electrical.grid.plugins.Household_Statistical.Household_Statistical;
import profiler.electrical.grid.plugins.Lighting_Izaskun.Lighting_Izaskun;
import profiler.electrical.grid.plugins.PowerConsumer_Social.PowerConsumer_Social;
import profiler.electrical.grid.plugins.Radiator_Area.Radiator_Area;

public class PluginFactory {

	HashMap <String,Plugin> hasMap; 
	
	public PluginFactory(){
		hasMap = new HashMap <String,Plugin>();
		hasMap.put("profiler-Household", new Household_Statistical(this));
		hasMap.put("profiler-Lighting", new Lighting_Izaskun(this));
		hasMap.put("profiler-PowerConsumer", new PowerConsumer_Social(this));
		hasMap.put("profiler-Radiator", new Radiator_Area(this));
	}
	
	public Plugin getPlugin(String pluginName){
		return hasMap.get(pluginName);
	}
}