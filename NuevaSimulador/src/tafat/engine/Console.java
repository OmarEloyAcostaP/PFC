package tafat.engine;

import tafat.control.Main;

public class Console {
	public static void out(String message) {
		System.out.println(message);
	}
	public static void error(String message) {
		System.out.println("\nERROR:" + message + "\n");
		if (Main.debugMode)
			System.exit(0);
	}
}
