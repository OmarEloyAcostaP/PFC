package tafat.engine;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {
	
	public static Date parseDate(String data) throws ParseException { 
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		return dateFormat.parse(data);
	}

	public static Date parseDateAndTime(String data) throws ParseException { 
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

		return dateFormat.parse(data);
	}
	
	@SuppressWarnings("deprecation")
	public static Date parseTime (String time) throws ParseException{
		Date currentDate = Time.getInstance().getSimulationDate();
		String[] timeSplitted = time.split(":");
		
		currentDate.setHours(Integer.parseInt(timeSplitted[0]));
		currentDate.setMinutes(Integer.parseInt(timeSplitted[1]));
		
		if (timeSplitted.length == 3)
			currentDate.setSeconds(Integer.parseInt(timeSplitted[2]));
		else
			currentDate.setSeconds(0);

		return currentDate;
	}
}
