package tafat.engine.multithread;

import java.util.ArrayList;

import tafat.engine.ModelObject;

public class MultithreadHandler {
	ArrayList <ArrayList <ModelObject>> objectsDivision = new ArrayList <ArrayList<ModelObject>> ();
	ArrayList <SingleThread> threads = new ArrayList <SingleThread> ();
	
	int numberOfThreads = 8;
	
	
	public MultithreadHandler(ModelObject scene){
		ArrayList <ModelObject> sceneObjects = scene.collect(Object.class, true);
		
		int objectsPerThread = sceneObjects.size() / numberOfThreads;
		int offset = sceneObjects.size() - (objectsPerThread * numberOfThreads);
		
		for (int i = 0; i < numberOfThreads - 1; i++){
			ArrayList <ModelObject> objectsToThread = new ArrayList<ModelObject>();
			for (int j = 0; j < objectsPerThread; j++)
				objectsToThread.add(sceneObjects.get(i * objectsPerThread + j));
			objectsDivision.add(objectsToThread);
		}
		
		ArrayList <ModelObject> objectsToThread = new ArrayList<ModelObject>();
		for (int j = 0; j < objectsPerThread + offset; j++)
			objectsToThread.add(sceneObjects.get((numberOfThreads - 1) * objectsPerThread + j));
		objectsDivision.add(objectsToThread);
	}
	
	public void tick (int time){
		for (int i = 0; i < numberOfThreads; i++){
			SingleThread thread = new SingleThread(objectsDivision.get(i), time);
			thread.start();
			threads.add(thread);
		}
		
		for (SingleThread thread : threads){
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		threads.clear();
	}
}
