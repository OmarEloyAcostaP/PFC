package profiler.electrical.grid.core.xmlEvents;

import bsxParser.BsxParser;

public abstract class EventHandler {
	
	private static int STRING_PROFILER_DASH_LENGHT = 9;
	private static int STRING_SCENE_LENGHT = 4;
	private static int STRING_PROFILER_DASH_FIRST_CHARACTER = 0;	
	private static String PROFILER_DASH = "profiler-";
	private static String SCENE = "scene";
	
	public abstract int handle(BsxParser bsxParserEvent);
	 
	protected boolean isProfilerNode(String name){
		if ((name.length() >= STRING_PROFILER_DASH_LENGHT) && 
				(name.toLowerCase().subSequence(STRING_PROFILER_DASH_FIRST_CHARACTER,
						STRING_PROFILER_DASH_LENGHT).equals(PROFILER_DASH)))
				return true;
		return false;
	}
	
	protected boolean isSceneNode(String name){
		if ((name.length() >= STRING_SCENE_LENGHT) && 
				(name.toLowerCase().equals(SCENE)))
				return true;
		return false;
	}
}
 