package profiler.electrical.grid.core;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Writer;
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

		try {

			String pathFileIn = args[0];
			String pathFileOut = args[1];

			PrintStream orgStream = System.out;

			PrintStream fileStream = new PrintStream(new FileOutputStream(
					args[2], true));

			System.setOut(fileStream);
			System.setErr(fileStream);

			Runtime.getRuntime().gc();

			double freeMemBefore = Runtime.getRuntime().freeMemory();
			double timeBefore = System.currentTimeMillis();
			double totalMemBefore = Runtime.getRuntime().totalMemory();

			BsxParser bsxParser = new BsxParser(pathFileIn, pathFileOut);
			EventFactory eventFactory = new EventFactory();
			HashMap<Integer, EventHandler> eventHashMap = eventFactory
					.createEvents();
			EventHandler eventHandler = null;
			Plugin plugin = null;
			PluginFactory pluginFactory = new PluginFactory();

			while (bsxParser.hasNext()) {
				eventHandler = (EventHandler) eventHashMap
						.get(bsxParser.next());
				if (eventHandler.handle(bsxParser) == 1) {
					plugin = pluginFactory.getPlugin(bsxParser.getLocalName());
					plugin.execute(bsxParser);
				}
			}

			if (args.length == 3) {
				args[2] = Console.out;
			}

			bsxParser.close();

			double timeAfter = System.currentTimeMillis();
			double freeMemAfter = Runtime.getRuntime().freeMemory();
			double totalMemAfter = Runtime.getRuntime().totalMemory();

			Writer fstream = new FileWriter(args[3]);
			BufferedWriter out = new BufferedWriter(fstream);

			out.write(Float.toString((float) (totalMemBefore) / 1048576));
			out.newLine();
			out.write(Float.toString((float) (freeMemBefore / 1048576)));
			out.newLine();
			out.write(Float.toString((float) ((timeAfter - timeBefore) / 1000)));
			out.newLine();
			out.write(Float.toString((float) (freeMemAfter / 1048576)));
			out.newLine();
			out.write(Float.toString((float) (totalMemAfter / 1048576)));
			out.newLine();
			out.write(Float
					.toString((float) (((totalMemAfter - freeMemAfter) - (totalMemBefore - freeMemBefore)) / 1048576)));

			out.close();
			fstream.close();
			fileStream.close();
			orgStream.close();

			Runtime.getRuntime().exit(0);

		} catch (IOException e) {
			e.printStackTrace();
			Runtime.getRuntime().exit(0);
		}

	}
}
