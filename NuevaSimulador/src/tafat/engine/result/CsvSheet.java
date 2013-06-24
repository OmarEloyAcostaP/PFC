package tafat.engine.result;

import java.io.UnsupportedEncodingException;

import tafat.engine.Time;

public class CsvSheet {
	private static final String ENCODING = "ISO-8859-1";
	
	String name;
	byte[] content = new byte [5000000];
	int contentIndex = 0;
	final String separator = ";";	
	
	public CsvSheet(String name) {
		this.name = name;
	}
	
	public void add (String toAdd) {
		if (toAdd.contains(separator))
			toAdd = "\"" + toAdd + "\"";
		
		toAdd+=separator;
		try {
			byte[] toCopy = toAdd.replace(".",",").getBytes(ENCODING);
			if ((contentIndex + toCopy.length) > content.length)
				resizeContent();
			for (int i = 0; i < toCopy.length ; i++)
				content[contentIndex++] = toCopy[i];
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	private void resizeContent() {
		double newSize = ((double)contentIndex * (double)Time.getInstance().getSimulationDurationTicks()) / (double)Time.getInstance().getSimulationTick();
		newSize += 1000000; // Extra MB. Just in case
		byte[] aux = content;
		content = null;
		content = new byte [(int)newSize];
		for (int i = 0; i < contentIndex; i++)
			content[i] = aux[i];
	}

	public String getName () {
		return name;
	}
	
	public byte[] getContent () {
		byte[] toReturn = new byte[contentIndex];
		for (int i = 0; i < contentIndex; i++)
			toReturn[i] = content[i];
		return toReturn;
	}

	public void newLine() {
		try {
			byte[] toCopy = "\n".getBytes(ENCODING);
			for (int i = 0; i < toCopy.length ; i++)
				content[contentIndex++] = toCopy[i];
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
