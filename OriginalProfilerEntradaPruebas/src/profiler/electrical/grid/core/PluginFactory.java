package profiler.electrical.grid.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.w3c.dom.Document;
import org.w3c.dom.Node;


public class PluginFactory {
	
	Object[] parametersValues = null;
	
	/**
	 * 
	 * Search the plugin and execute it obtaining the node result which will be in the final xml
	 * @param profilerNode 
	 * @param document 
	 * @param  
	 * @param Plugin name: name of the plugin to search
	 * @param Attributes: attributes of the profiler node found
	 * @return 
	 * 
	 **/
	
	public boolean  create(Document document, Node profilerNode){
			String pluginName = profilerNode.getNodeName().substring(9);
			
			String pluginRelease = "";
			if (profilerNode.getAttributes().getNamedItem("release") != null)
				pluginRelease = profilerNode.getAttributes().getNamedItem("release").getNodeValue();
			else
				Console.error("Release not found");
			
			String plugin = pluginName;
			if (!pluginRelease.equals(""))
				plugin += "_" + pluginRelease;
			
			Class<?> pluginHandlerClass = getHandlerClass("profiler.electrical.grid.plugins." + plugin + "." + plugin);
			
			if (pluginHandlerClass == null){
				Console.out(plugin + " not found");
				return false;
			}
			
			try {
				Object[] parametersValues = new Object[2];
				parametersValues[0] = document;				
				parametersValues[1] = profilerNode;
				
				Method[] execute = pluginHandlerClass.getDeclaredMethods();
				
				for (int i=0; i<execute.length; i++){
					if(execute[i].getName().equals("execute")){
						execute[i].invoke(pluginHandlerClass.newInstance(), parametersValues);
						break;
					}
				}
				
			} catch (InstantiationException e) {
				e.printStackTrace();
			}
			  catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
			return true;
		}

	private Class<?> getHandlerClass(String substring) {
		//ClassLoader loader = ClassLoader.getSystemClassLoader();
		Class<?> found = null;
		try {
			//found = loader.loadClass(substring);
			found = Class.forName(substring);
		} catch (ClassNotFoundException e1) {
			Console.out(e1.toString());
		}
		return found;
	}
}
