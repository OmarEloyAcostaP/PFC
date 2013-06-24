package profiler.electrical.grid.core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Writer;
import java.util.Date;

import org.w3c.dom.Document;

public class Main {
	private static Document document;
	private static Profiler profiler = new Profiler();
	private static Interface dialog = new Interface();

	final static int EVENTBROWSE = 0;
	final static int EVENTEXECUTE = 1;
	final static int EXIT = 2;

	private static FileWriter file = null;
	public static BufferedWriter fileBw = null;

	public static void main(String[] args) {
		// dialog.createMainDialog();
		/*
		 * initializeOutputFile(); String pathFileIn = "", pathFileOut = ""; if
		 * (args != null){ if (args.length == 1){ pathFileIn = args[0];
		 * Console.setStringWriter(true); } else if (args.length == 2){
		 * pathFileIn = args[0]; pathFileOut = args[1];
		 * Console.setStringWriter(true); } else if (args.length == 3){
		 * pathFileIn = args[0]; pathFileOut = args[1];
		 * Console.setStringWriter(false); } else{
		 * Console.setStringWriter(true);
		 * Console.out("Path of the profiled XML:"); pathFileIn = Console.in();
		 * Console.out("Name of the output file:"); String nameFileOut =
		 * Console.in(); pathFileOut = pathFileIn.substring(0,
		 * pathFileIn.lastIndexOf("/") + 1) + nameFileOut; } } Date initialDate
		 * = new Date();
		 */
		// ------------------------------------------------------------------------------------------------
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

			document = XMLHandler.openDocument(pathFileIn);
			profiler.execute(document);
			XMLHandler.saveDocument(pathFileOut, document);

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

		// ------------------------------------------------------------------------------------------------

		/*
		 * closeOutputFile(); Date finalDate = new Date();
		 * Console.out("Profiler duration (s) = " + ((finalDate.getTime() -
		 * initialDate.getTime())/1000));
		 */
	}

	private static void closeOutputFile() {
		try {
			fileBw.close();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void initializeOutputFile() {
		try {
			file = new FileWriter("profiler.out");
			fileBw = new BufferedWriter(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void handlerDialog(int event) {
		if (event == EVENTBROWSE) {
			String path = dialog.openFileDialog();
			document = XMLHandler.openDocument(path);
			dialog.pathField.setText(path);
		}
		if (event == EVENTEXECUTE) {
			if (document != null) {
				profiler.execute(document);
				String path = dialog.saveFileDialog();
				XMLHandler.saveDocument(path, document);
			}
			dialog.pathField.setText("Write a valid path");
		}
		if (event == EXIT)
			System.exit(0);
	}

}
