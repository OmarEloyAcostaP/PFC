package profiler.electrical.grid.core;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
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
	
	public static void main (String[] args) {
		//dialog.createMainDialog();
		initializeOutputFile();
		String pathFileIn = "", pathFileOut = "";
		if (args != null){
			if (args.length == 1){
				pathFileIn = args[0];
				Console.setStringWriter(true);
			}
			else if (args.length == 2){
				pathFileIn = args[0];
				pathFileOut = args[1];
				Console.setStringWriter(true);
			}
			//else if (args.length == 3){
			else {	
				pathFileIn = args[0];
				pathFileOut = args[1];				
				PrintStream fileStream;				
				try {
					fileStream = new PrintStream(new FileOutputStream(
							args[2], true));
					System.setOut(fileStream);
					System.setErr(fileStream);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
				//Console.setStringWriter(false);
			}/*
			else{
				Console.setStringWriter(true);
				Console.out("Path of the profiled XML:");
				pathFileIn = Console.in();
				Console.out("Name of the output file:");
				String nameFileOut = Console.in();
				pathFileOut = pathFileIn.substring(0, pathFileIn.lastIndexOf("/") + 1) + nameFileOut;
			}*/
		}
		
		Date initialDate = new Date();
		document = XMLHandler.openDocument(pathFileIn);		
		profiler.execute(document);		
		XMLHandler.saveDocument(pathFileOut, document);

		closeOutputFile();
		Date finalDate  = new Date();
		Console.out("Profiler duration (s) = " + ((finalDate.getTime() - initialDate.getTime())/1000));
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
			file = new FileWriter ("profiler.out");
			fileBw = new BufferedWriter(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void handlerDialog(int event) {
		if(event == EVENTBROWSE){
			String path = dialog.openFileDialog();
			document = XMLHandler.openDocument(path);
			dialog.pathField.setText(path);
		}
		if(event == EVENTEXECUTE){
			if(document!=null){
					profiler.execute(document);
					String path = dialog.saveFileDialog();
					XMLHandler.saveDocument(path, document);
			}
			dialog.pathField.setText("Write a valid path");
		}
		if(event == EXIT)
			System.exit(0);
	}
	
}
