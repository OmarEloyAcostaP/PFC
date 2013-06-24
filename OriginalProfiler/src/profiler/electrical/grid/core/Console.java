package profiler.electrical.grid.core;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Console {
	
	static String out = "";
	static boolean console = true;

	public static void setStringWriter(boolean useConsole) {
		console = useConsole;
		out = "";
	}
	
	public static void out(String message) {
		if (console)
			System.out.println(message);
		else
			out += message + "\n";
	}
	public static void error(String message) {
		if (console)
			System.out.println("ERROR:" + message);
		else
			out += "ERROR:" + message + "\n";
	}
	public static String in(){
		String linea = "";
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			linea = br.readLine();
		}catch(Exception e){
			e.printStackTrace();
		}
		return linea;
	}
}
