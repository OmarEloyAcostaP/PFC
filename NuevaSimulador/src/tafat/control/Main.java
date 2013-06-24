package tafat.control;

import java.io.FileReader;
import java.io.IOException;
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

		//instance.modelFilename = "ProfilerModel.xml";
		instance.modelFilename = "output-1.xml";
		
		try {

			reader = new FileReader("ProfilerModel.xml");
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

		} catch (IOException e) {
			e.printStackTrace();
		} catch (DOMException e) {
			e.printStackTrace();
		} catch (ParseException e) {
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

			Date initialDate = new Date();

			Console.out("Starting simulation " + initialDate.toString());

			TimeoutManager timeoutManagerInstance = TimeoutManager
					.getInstance();
			StatechartUpdater statechartUpdaterInstance = StatechartUpdater
					.getInstance();

			int percentage = 1;
			int next = (percentage * Time.getInstance()
					.getSimulationDurationTicks()) / 100;

			/* MULTITHREAD ATTEMPT, UNDER CONSTRUCTION */
			// MultithreadHandler multithreadHandler = new MultithreadHandler
			// (scene);
			/* DYNAMIC STEP ATTEMPT, UNDER CONSTRUCTION */
			StepCalculator stepCalculator = new StepCalculator(scene);
			int stepCountdown = 0;
			Console.out("Steps: " + stepCalculator.getStep());

			/* SIMULATION DURATION */
			for (int i = 0; i < Time.getInstance().getSimulationDurationTicks(); i++) {
				Time.getInstance().tick();
				if (i > next) {
					Console.out("Simulation percentage: " + percentage++);
					next = (percentage * Time.getInstance()
							.getSimulationDurationTicks()) / 100;
				}
				timeoutManagerInstance.tick();
				statechartUpdaterInstance.tick();

				if (stepCountdown == 0) {
					stepCountdown = stepCalculator.getStep();
					scene.tick(i);
					// scene.fastTick(i);

					// topology.tick(i);
					// topology.fastTick(i);
				}
				stepCountdown--;

				// multithreadHandler.tick(i);
				if (result_Handler != null)
					result_Handler.tick();
			}

			scene.terminate();
			if (result_Handler != null)
				result_Handler.terminate();

			Date finalDate = new Date();
			Console.out("Simulation finished " + finalDate.toString()
					+ ". Simulation duration (s) = "
					+ ((finalDate.getTime() - initialDate.getTime()) / 1000));

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}