package tafat.engine.cache;

import java.util.ArrayList;

public class CacheHandler {

	private ArrayList<CacheElement> cacheElements = new ArrayList<CacheElement> ();
	private static CacheHandler instance = null;
	
	private CacheHandler (){
	}
	
	public static void createInstance(){
		if (instance == null){
			instance = new CacheHandler();
		}
	}
	
	public static CacheHandler getInstance (){
		return instance;
	}
	
	public static void addCacheElement (Object object, String id){
		instance.cacheElements.add(new CacheElement(object, id));
	}
	
	public static Object getCacheElement(String id){
		for (CacheElement element : instance.cacheElements)
			if (element.id.equals(id))
				return element.object;
		return null;
	}
	
	private static class CacheElement{
		Object object;
		String id;
		
		CacheElement (Object object, String id){
			this.object = object;
			this.id = id; 
		}
	}
}
