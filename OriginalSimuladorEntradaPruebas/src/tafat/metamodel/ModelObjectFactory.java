/*****
 Generated automatically by tafat.framework.Translator
 Version: 04.01.2011 at 02:46 GMT
 *****/
package tafat.metamodel;


import java.util.HashMap;

import tafat.engine.BehaviorContainer;
import tafat.engine.ModelObject;
import tafat.metamodel.entity.*;
import tafat.metamodel.connection.*;


public class ModelObjectFactory {
    private static ModelObjectFactory instance = new ModelObjectFactory();
    private HashMap<String, Class<?>> classes = new HashMap<String, Class<?>>();

    private ModelObjectFactory() {
        classes.put("behavior", BehaviorContainer.class);			
		classes.put("powerbusfull", PowerBusFull.class);
		classes.put("audiohififull", AudioHifiFull.class);
		classes.put("coffeemakerfull", CoffeeMakerFull.class);
		classes.put("computerfull", ComputerFull.class);
		classes.put("cookingstovefull", CookingStoveFull.class);
		classes.put("dishwasherfull", DishwasherFull.class);
		classes.put("dryerfull", DryerFull.class);
		classes.put("electricaltoolfull", ElectricalToolFull.class);
		classes.put("freezerfull", FreezerFull.class);
		classes.put("householdfull", HouseholdFull.class);
		classes.put("lightingfull", LightingFull.class);
		classes.put("microwavefull", MicrowaveFull.class);
		classes.put("ovenfull", OvenFull.class);
		classes.put("radiatorfull", RadiatorFull.class);
		classes.put("refrigeratorfull", RefrigeratorFull.class);
		classes.put("tvfull", TvFull.class);
		classes.put("washingmachinefull", WashingMachineFull.class);
		classes.put("outdoorfull", OutdoorFull.class);
		classes.put("buildingfull", BuildingFull.class);
		classes.put("powerconnectionfull", PowerConnectionFull.class);
		classes.put("locationsgroupfull", LocationsGroupFull.class);

    }
	
    static public ModelObject createObject(String className) {
        Class<?> classObject = instance.classes.get(className);

        if (classObject == null) {
            return null;
        }
        ModelObject object = null;

        try {
            object = (ModelObject) classObject.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return object;
    }
    
    static public Class<?> getClass(String className) {
        return instance.classes.get(className);
    }

}

