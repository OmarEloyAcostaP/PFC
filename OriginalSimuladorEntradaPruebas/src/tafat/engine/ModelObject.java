
package tafat.engine;



import java.text.ParseException;
import java.util.ArrayList;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import tafat.control.Main;
import tafat.metamodel.ModelObjectFactory;


public class ModelObject {
	public String title = "";
	public String id = "";
	public String tags = "";
	public ModelObject owner = null;
	protected ArrayList<String> contentList = new ArrayList<String>();
	public ArrayList<ModelObject> objectList = new ArrayList<ModelObject>();
	public ArrayList<BehaviorContainer> behaviorList = new ArrayList<BehaviorContainer>();
	public ArrayList <Notification> notifications = new ArrayList <Notification> ();
	
	public void receiveNotification (Notification notification){
		notifications.add(notification);
	}
	
	public ModelObject() {
		contentList.add("behavior");		
	}
	
	public final void load(Node data) throws ParseException {
		String fullPath = this.getFullPath();
		Console.out(fullPath);
		
		setDefaultValues();		
		
		NamedNodeMap attributeList = data.getAttributes();
		for (int i = 0; i < attributeList.getLength(); i++) {
		  Node attribute = attributeList.item(i);
		  String setName = attribute.getNodeName();
		  String setValue = attribute.getNodeValue();
		  loadAttribute(setName, setValue);
		}
		
		NodeList nodeList = data.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			short nodeType = node.getNodeType();
			if (nodeType == Node.ELEMENT_NODE)
				loadChildrenNode(node);
		}
		init();
	}
	
	
	private final void loadChildrenNode(Node node) throws ParseException {
		String name = node.getNodeName().toLowerCase();
		
		if (name.equals("title")) {
			title = node.getFirstChild().getNodeValue();
		}
		else {
			if (!isInContentList(name)) {
				Console.error(name + " can't be inserted in " + getClassName());
				return;				
			}
			ModelObject object = ModelObjectFactory.createObject(name);
			if (object == null) {
				Console.error(name + " isn't a known class");
				return;
			}
			this.objectList.add(object);
			object.owner = this;
			object.load(node);
		}
	}

	private final boolean isInContentList(String name) {
		if (contentList.contains(name))
			return true;
		Class<?> objectClass = ModelObjectFactory.getClass(name);
		if (objectClass == null)
			return false;
		while (objectClass.getSuperclass() != Object.class){
			objectClass = objectClass.getSuperclass();
			if (contentList.contains(objectClass.getSimpleName().toLowerCase()))
				return true;
		}
		return false;
	}

	protected void setDefaultValues() throws ParseException {
		title = this.getClassName();
	}

	protected void loadAttribute(String name, String value) throws ParseException {
		if (name.equals("id"))
			id = value;
		else if (name.equals("tags"))
			tags = value;
		else
			Console.error(name + " is not a known attribute for " + this.getClassName());
	}

	protected void init() throws ParseException {
		for (ModelObject object : objectList){
			if (object instanceof BehaviorContainer) {
				BehaviorContainer container = (BehaviorContainer) object;
				if (container.behavior == null) continue;
				behaviorList.add(container);
			}
		}
		Main.scene.insertItem(this);
	}
	
	public void setState(int state) {
		
	}
	
	protected final String getClassName() {
		String result = getClass().getName();
		result = result.substring(result.lastIndexOf(".")+1);
		return result;
	}

	public final String getFullPath() {
		String result = "";
		ModelObject object = this;
		while (object != null) {
			result = "." + object.getClassName() + result;
			object = object.owner;
		}
		return result.substring(1);
	}
	
	public final ModelObject findOwner(Class<?> classObject) {
		ModelObject object = owner;
		while (object != null) {
			if (classObject.isInstance(object))
				return object;
			else
				object = object.owner;
		}
		return null;
	}
	
	public final ModelObject getFirstOwner() {
		return owner;
	}

	public final ModelObject findChild(Class<?> classObject) {
		for (ModelObject object : objectList) {
			if (classObject.isInstance(object))
				return object;
		}
		return null;
	}
	
	public final ArrayList<ModelObject> getChilds(){
		return objectList;
	}

	public final ArrayList<ModelObject> collect(Class<?> classObject, Boolean recursive) {
		ArrayList<ModelObject> resultList = new ArrayList<ModelObject>();
		putObjectsList(classObject, resultList, recursive);
		return resultList;
	}


	private final void putObjectsList(Class<?> classObject, ArrayList<ModelObject> targetList, Boolean recursive) {
		for (ModelObject object:objectList) {
			if (classObject.isInstance(object))
				targetList.add(object);
			if (recursive)
				object.putObjectsList(classObject, targetList, recursive);
		}
		
	}

	/* OLD VERSION */
	
	public void fastTick(Integer time) {
		for (ModelObject object : objectList)
			object.fastTick(time);
		
		for (BehaviorContainer behaviorContainer : behaviorList) {
			if (behaviorContainer.countdown != 0)
				continue;
			behaviorContainer.behavior.tickOn(time);			
		}
		for (BehaviorContainer behaviorContainer : behaviorList) {
			if (behaviorContainer.countdown != 0) continue;
			behaviorContainer.behavior.tickOff(time);
		}
	}
	
	/* OLD VERSION */
	
	/* IMPROVEMENT 19/08/2011 */
	
	public void tick(Integer time) {
		for (ModelObject object : objectList)
			object.tick(time);
	}
	
	public void tickOn(Integer time) {
		for (BehaviorContainer behaviorContainer : behaviorList) {
			if (behaviorContainer.countdown != 0)
				continue;
			behaviorContainer.behavior.tickOn(time);			
		}
		
		for (ModelObject object : objectList)
			object.tickOn(time);
	}
		
	public void tickOff(Integer time) {
		for (BehaviorContainer behaviorContainer : behaviorList) {
			if (behaviorContainer.countdown != 0) 
				continue;
			behaviorContainer.behavior.tickOff(time);			
		}
		
		for (ModelObject object : objectList)
			object.tickOff(time);
	}
	
	/* IMPROVEMENT 19/08/2011 */

	public void terminate(){
		/* Not needed */
//		for (BehaviorContainer behaviorContainer : behaviorList)
//			behaviorContainer.terminate();
		
		for (ModelObject object : objectList)
			object.terminate();
	}
	
	
}
