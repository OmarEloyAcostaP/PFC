package tafat.engine.interpolatedfunction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import tafat.engine.Console;

public class FileParser extends Parser {

	final private String[] contentNumber = {"0","1","2","3","4","5","6","7","8","9",".","-","e","(",")"};
	
	private BufferedReader in;
		
	public FileParser(String filename){
		try {			
			in = new BufferedReader(new FileReader(filename));
		} catch (IOException e) {
			Console.error("file not found or empty");
		}
	}
	
	
	@Override
	public Coordinate[] loadData (boolean avoidFirstRow) {
		String nextLine = "";
		try {
			if(avoidFirstRow)
					in.readLine();
			while ((nextLine = in.readLine()) != null) {
				 Coordinate coordinate = getCoordinate(nextLine);
			     if (existsX(coordinate.x)){
			    	 Console.out("WARNING: some numbers are repeated, not added: " + nextLine);
			    	 continue;
			     }
			     coordinatesList.add(coordinate);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return arrayListToArray();
	}
	
	private Coordinate getCoordinate(String line){
		double[] numbers = new double [2];
		for(int k=0; k < 2; k++){
			for(int i=0; i < line.length(); i++){
				boolean isNumber = false;
				for(int j=0; j < contentNumber.length; j++){
					if(line.substring(i,i+1).equals(contentNumber[j])){
						isNumber = true;
						line = line.substring(i);
						break;
					}
				}
				if(isNumber)
					break;
			}
			String toReturn = "";
			for(int i=0; i < line.length(); i++){
				boolean isNumber = false;
				for(int j=0; j < contentNumber.length; j++){
					if(line.substring(i,i+1).equals(contentNumber[j])){
						isNumber = true;
						toReturn += line.substring(i,i+1);
						break;
					}
				}
				if((!isNumber) || (i == line.length()-1)){
					numbers[k] = Double.parseDouble(toReturn);
					line = line.substring(i);
					break;
				}
			}
		}
		return new Coordinate (numbers[0], numbers[1]);
	}
}
