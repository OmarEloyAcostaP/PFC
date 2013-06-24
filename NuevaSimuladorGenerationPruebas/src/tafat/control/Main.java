package tafat.control;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Writer;
import java.text.ParseException;
import java.util.Date;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.w3c.dom.DOMException;

import tafat.engine.Console;
import tafat.engine.DateParser;
import tafat.engine.Scene;
import tafat.engine.StepCalculator;
import tafat.engine.Time;
import tafat.engine.Topology;
import tafat.engine.cache.CacheHandler;
import tafat.engine.result.Result_Handler;
import tafat.engine.statechart.StatechartUpdater;
import tafat.engine.timeout.TimeoutManager;

public class Main {
	static private Main instance = new Main();

	public static boolean debugMode = false;

	private String modelFilename;
	private static Date from = null;
	private static Date to = null;

	public static Scene scene = new Scene();
	public static Topology topology = new Topology();
	public static Result_Handler result_Handler = null;

	private static FileReader reader;
	private static XMLStreamReader parserReader;

	public static int occurrences = 1;

	public static void main(String args[]) {
		Console.out("Heap size " + Runtime.getRuntime().totalMemory());

		instance.modelFilename = args[1];

		try {

			PrintStream orgStream = System.out;

			PrintStream fileStream = new PrintStream(new FileOutputStream(
					args[2], true));

			System.setOut(fileStream);
			System.setErr(fileStream);

			Runtime.getRuntime().gc();
			double freeMemBefore = Runtime.getRuntime().freeMemory();
			double timeBefore = System.currentTimeMillis();
			double totalMemBefore = Runtime.getRuntime().totalMemory();

			reader = new FileReader(instance.modelFilename);
			parserReader = XMLInputFactory.newInstance().createXMLStreamReader(
					reader);
			parserReader.next();

			boolean fromFound = false;
			boolean toFound = false;

			/* GET OCCURRENCES */
			for (int i = 0; i < parserReader.getAttributeCount(); i++) {
				if (parserReader.getAttributeLocalName(i).equals("occurrences"))
					occurrences = Integer.parseInt(parserReader
							.getAttributeValue(i));
				if (parserReader.getAttributeLocalName(i).equals("from")) {
					from = DateParser.parseDateAndTime(parserReader
							.getAttributeValue(i));
					fromFound = true;
				}
				if (parserReader.getAttributeLocalName(i).equals("to")) {
					to = DateParser.parseDateAndTime(parserReader
							.getAttributeValue(i));
					toFound = true;
				}
			}
			if (!fromFound) {
				Console.error("Initial time not set");
				return;
			}
			if (!toFound) {
				Console.error("Final time not set");
				return;
			}
			for (int occurrence = 0; occurrence < occurrences; occurrence++) {
				Time.createInstance(from, to);
				instance.execute(parserReader);
				Time.clear();
			}

			reader.close();
			parserReader.close();

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

		} catch (IOException | ParseException e) {
			e.printStackTrace();
			Runtime.getRuntime().exit(0);
		} catch (DOMException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}

	private void execute(XMLStreamReader parserReader) {

		try {
			TimeoutManager.clear();
			StatechartUpdater.clear();
			scene = null;
			topology = null;
			scene = new Scene();
			topology = new Topology();
			CacheHandler.createInstance();

			TimeoutManager.createInstance();
			StatechartUpdater.createInstance();

			try {
				while (parserReader.hasNext()) {
					parserReader.next();
					if (parserReader.isStartElement()) {
						if (parserReader.getLocalName().toLowerCase()
								.equals("scene")) {
							scene.load(parserReader);
						}
						if (parserReader.getLocalName().toLowerCase()
								.equals("topology")) {
							System.out.println(parserReader.getLocalName());
							topology.load(parserReader);
						}
						if (parserReader.getLocalName().toLowerCase()
								.equals("result")) {
							for (int i = 0; i < parserReader
									.getAttributeCount(); i++) {
								if (parserReader.getAttributeLocalName(i)
										.toString().toLowerCase()
										.equals("filename"))
									result_Handler = new Result_Handler(
											parserReader.getAttributeValue(i));
							}
						}
					}
				}
			} catch (XMLStreamException e) {
				e.printStackTrace();
			} catch (FactoryConfigurationError e) {
				e.printStackTrace();
			}

			Console.out("Scene loaded");

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}