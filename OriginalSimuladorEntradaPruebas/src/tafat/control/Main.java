package tafat.control;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Writer;
import java.text.ParseException;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

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

	public static int occurrences = 1;

	public static void main(String args[]) {
		Console.out("Heap size " + Runtime.getRuntime().totalMemory());

		// instance.modelFilename = "ProfilerModel.xml";

		DocumentBuilder builder;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			builder = factory.newDocumentBuilder();

			// ---------------------------------------------------------------
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

				Document document = builder.parse(args[1]);

				double timeAfter = System.currentTimeMillis();
				double freeMemAfter = Runtime.getRuntime().freeMemory();
				double totalMemAfter = Runtime.getRuntime().totalMemory();

				Writer fstream = new FileWriter(args[3]);
				BufferedWriter out = new BufferedWriter(fstream);

				out.write(Float.toString((float) (totalMemBefore) / 1048576));
				out.newLine();
				out.write(Float.toString((float) (freeMemBefore / 1048576)));
				out.newLine();
				out.write(Float
						.toString((float) ((timeAfter - timeBefore) / 1000)));
				out.newLine();
				out.write(Float.toString((float) (freeMemAfter / 1048576)));
				out.newLine();
				out.write(Float.toString((float) (totalMemAfter / 1048576)));
				out.newLine();
				out.write(Float
						.toString((float) (((totalMemAfter - freeMemAfter) - 
								(totalMemBefore - freeMemBefore)) / 1048576)));

				out.close();
				fstream.close();
				fileStream.close();
				orgStream.close();

				Runtime.getRuntime().exit(0);

			} catch (IOException e) {
				e.printStackTrace();
				Runtime.getRuntime().exit(0);
			}

			// ---------------------------------------------------------------

		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (DOMException e) {
			e.printStackTrace();
		}

		for (int occurrence = 0; occurrence < occurrences; occurrence++) {
			Time.createInstance(from, to);
			instance.execute(occurrence);
			Time.clear();
		}
	}

	private void execute(int occurrence) {
		DocumentBuilder builder;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {

			builder = factory.newDocumentBuilder();
			Document document = builder.parse(modelFilename);
			NodeList nodeList = document.getDocumentElement().getChildNodes();

			TimeoutManager.clear();
			StatechartUpdater.clear();
			scene = null;
			topology = null;
			scene = new Scene();
			topology = new Topology();
			CacheHandler.createInstance();

			TimeoutManager.createInstance();
			StatechartUpdater.createInstance();

			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				String nodeName = node.getNodeName().toLowerCase();
				short nodeType = node.getNodeType();
				if (nodeType == Node.ELEMENT_NODE) {
					if (nodeName.equals("scene"))
						scene.load(node);
					else if (nodeName.equals("topology"))
						topology.load(node);
					else if (nodeName.equals("result"))
						if (node.getAttributes().getNamedItem("filename") != null)
							result_Handler = new Result_Handler(node
									.getAttributes().getNamedItem("filename")
									.getNodeValue());
				}
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
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}