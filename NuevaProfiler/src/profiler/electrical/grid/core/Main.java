package profiler.electrical.grid.core;

import java.io.BufferedWriter;
import java.util.Date;
import java.util.HashMap;

import profiler.electrical.grid.core.xmlEvents.EventFactory;
import profiler.electrical.grid.core.xmlEvents.EventHandler;

import bsxParser.BsxParser;

public class Main {
	final static int EVENTBROWSE = 0;
	final static int EVENTEXECUTE = 1;
	final static int EXIT = 2;

	public static BufferedWriter fileBw = null;

	public static void main(String[] args) {
		String pathFileIn = "", pathFileOut = "";
		if (args != null) {
			if (args.length == 1) {
				pathFileIn = args[0];
				Console.setStringWriter(true);
			} else if (args.length == 2) {
				pathFileIn = args[0];
				pathFileOut = args[1];
				Console.setStringWriter(true);
			} else if (args.length == 3) {
				pathFileIn = args[0];
				pathFileOut = args[1];
				Console.setStringWriter(false);
			} else {
				Console.setStringWriter(true);
				Console.out("Path of the profiled XML:");
				pathFileIn = Console.in();
				Console.out("Name of the output file:");
				String nameFileOut = Console.in();
				pathFileOut = pathFileIn.substring(0,
						pathFileIn.lastIndexOf("/") + 1)
						+ nameFileOut;
			}
		}

		Date initialDate = new Date();

		BsxParser bsxParser = new BsxParser(pathFileIn, pathFileOut);
		EventFactory eventFactory = new EventFactory();
		HashMap<Integer, EventHandler> eventHashMap = eventFactory
				.createEvents();
		EventHandler eventHandler = null;
		Plugin plugin = null;
		PluginFactory pluginFactory = new PluginFactory();

		while (bsxParser.hasNext()) {
			eventHandler = (EventHandler) eventHashMap.get(bsxParser.next());
			if (eventHandler.handle(bsxParser) == 1) {
				plugin = pluginFactory.getPlugin(bsxParser.getLocalName());
				plugin.execute(bsxParser);
			}
		}

		if (args.length == 3) {
			args[2] = Console.out;
		}

		bsxParser.close();

		Date finalDate = new Date();
		Console.out("Profiler duration (s) = "
				+ ((finalDate.getTime() - initialDate.getTime()) / 1000));
	}
}
