package tafat.engine;

import java.util.ArrayList;

import org.apache.commons.math.util.MathUtils;

public class StepCalculator {
	int gdcTotalObjects;
	
	ArrayList <Integer> steps = new ArrayList <Integer> ();
	
	public StepCalculator (ModelObject scene){
		ArrayList <ModelObject> sceneObjects = scene.collect(Object.class, true);
		
		gdcTotalObjects = initialize(sceneObjects);
		
		for (ModelObject object : sceneObjects)
			for (BehaviorContainer behavior : object.behaviorList)
				gdcTotalObjects = MathUtils.gcd (gdcTotalObjects, behavior.step);
	}

	private int initialize(ArrayList<ModelObject> sceneObjects) {
		for (ModelObject object : sceneObjects){
			for (BehaviorContainer behavior : object.behaviorList){
				return behavior.step;
			}
		}
		return 10000;
	}
	
	public int getStep(){
		return gdcTotalObjects;
	}

}
