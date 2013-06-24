package profiler.electrical.grid.core;

import java.util.ArrayList;

public class CsvReader {

	ArrayList<String> headers = new ArrayList <String> ();
	String[] rows;
	
	public CsvReader (String path){
		rows = FileHandler.readFile(path).split("\n");
		for (String header : rows[0].split(";"))
			headers.add(header);
	}
	
	public String readCellOfRow (int numberOfRow, String nameOfColumn){
		for(int i = 0; i < headers.size(); i++)
			if (headers.get(i).equals(nameOfColumn))
				return readCellOfRow(numberOfRow, i);
		return null;
	}
	
	private String readCellOfRow(int numberOfRow, int numberOfColumn) {
		String[] splitted = rows[numberOfRow].split(";");
		return splitted[numberOfColumn];
	}

	public int getNumberOfEntries() {
		return rows.length;
	}
}
