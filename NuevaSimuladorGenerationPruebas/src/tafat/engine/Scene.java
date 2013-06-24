package tafat.engine;

import java.text.ParseException;
import java.util.HashMap;


public class Scene extends ModelObject {
	public HashMap<String,ModelObject> item = new HashMap<String,ModelObject>();

	public Scene() {
		contentList.add("outdoor");
		contentList.add("locationsgroup");
	}
	
	public void init() throws ParseException{
		super.init();
		insertItem(this);
	}
	
	public void insertItem(ModelObject object) {
		if (object == null)
			return;
//		for (ModelObject aux : object.objectList)
//			insertItem(aux);
		if (object.id.equals(""))
			return;
		item.put(object.id, object);
	}
	
	/* IMPROVEMENT - 19/08/2011 */
	public void tick(Integer time) {
		for (ModelObject object : objectList)
			object.tick(time);
		
		tickOn(time);
		tickOff(time);
	}
	
	/* IMPROVEMENT 19/08/2011 */

}
