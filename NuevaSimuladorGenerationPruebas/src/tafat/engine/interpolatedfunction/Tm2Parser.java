package tafat.engine.interpolatedfunction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import tafat.engine.Console;

public class Tm2Parser extends Parser{
	
	private HashMap<Integer, Date> indexToDate = new HashMap <Integer, Date> ();
	private HashMap<Date, Integer> dateToIndex = new HashMap <Date, Integer> ();
	
	private ColumnNames columnName;
	
	private Date from = null;
	private Date to = null;
	
	private BufferedReader in;
	
	public enum ColumnNames {Year,
						     Month,
						     Day,
						     Hour,
						     Extraterrestrial_Horizontal_Radiation,
						     Extraterrestrial_Direct_Normal_Radiation,
						     Global_Horizontal_Radiation,//_2
						     Direct_normal_Radiation,//_2
						     Diffuse_Horizontal_Radiation,//2,
						     Global_Horizontal_Illuminance,//2
						     Direct_Normal_Illuminance,//2
						     Diffuse_Horizontal_Illuminance,//2
						     Zenith_Luminance,//2
						     Total_Sky_Cover,//2
						     Opaque_Sky_Cover,//2
						     Dry_Bulb_Temperature,//2_
						     Dew_Point_Temperature,//2
						     Relative_humidity,//2
						     Atmospheric_pressure,//2
						     Wind_direction,//2
						     Wind_speed,//2
						     Visibility,//2
						     Ceiling_height,//2
						     Present_Weather,
						     Precipitable_Water,//2
						     Aerosol_Optical_Depth,//2
						     Snow_Depth,//2
						     Days_Since_Last_Snowfall,//2
						   	};
						   
		private Tm2ColumnFormat[] parserHelper = { new Tm2ColumnFormat(ColumnNames.Year, 3, 0),
												   new Tm2ColumnFormat(ColumnNames.Month, 2, 0),
												   new Tm2ColumnFormat(ColumnNames.Day, 2, 0),
												   new Tm2ColumnFormat(ColumnNames.Hour, 2, 0),
												   new Tm2ColumnFormat(ColumnNames.Extraterrestrial_Horizontal_Radiation, 4, 0),
												   new Tm2ColumnFormat(ColumnNames.Extraterrestrial_Direct_Normal_Radiation, 4, 0),
												   new Tm2ColumnFormat(ColumnNames.Global_Horizontal_Radiation, 4, 2),
												   new Tm2ColumnFormat(ColumnNames.Direct_normal_Radiation, 4, 2),
												   new Tm2ColumnFormat(ColumnNames.Diffuse_Horizontal_Radiation, 4, 2),
												   new Tm2ColumnFormat(ColumnNames.Global_Horizontal_Illuminance, 4, 2),
												   new Tm2ColumnFormat(ColumnNames.Direct_Normal_Illuminance, 4, 2),
												   new Tm2ColumnFormat(ColumnNames.Diffuse_Horizontal_Illuminance, 4, 2),
												   new Tm2ColumnFormat(ColumnNames.Zenith_Luminance, 4, 2),
												   new Tm2ColumnFormat(ColumnNames.Total_Sky_Cover, 2, 2),
												   new Tm2ColumnFormat(ColumnNames.Opaque_Sky_Cover, 2, 2),
												   new Tm2ColumnFormat(ColumnNames.Dry_Bulb_Temperature, 4, 2),
												   new Tm2ColumnFormat(ColumnNames.Dew_Point_Temperature, 4, 2),
												   new Tm2ColumnFormat(ColumnNames.Relative_humidity, 3, 2),
												   new Tm2ColumnFormat(ColumnNames.Atmospheric_pressure, 4, 2),
												   new Tm2ColumnFormat(ColumnNames.Wind_direction, 3, 2),
												   new Tm2ColumnFormat(ColumnNames.Wind_speed, 3, 2),
												   new Tm2ColumnFormat(ColumnNames.Visibility, 4, 2),
												   new Tm2ColumnFormat(ColumnNames.Ceiling_height, 5, 2),
												   new Tm2ColumnFormat(ColumnNames.Present_Weather, 10, 0),
												   new Tm2ColumnFormat(ColumnNames.Precipitable_Water, 3, 2),
												   new Tm2ColumnFormat(ColumnNames.Aerosol_Optical_Depth, 3, 2),
												   new Tm2ColumnFormat(ColumnNames.Snow_Depth, 3, 2),
												   new Tm2ColumnFormat(ColumnNames.Days_Since_Last_Snowfall, 2, 2),
												 };
		
		public Tm2Parser(String filename, ColumnNames nameColum , Date from, Date to){
			try {			
				in = new BufferedReader(new FileReader(filename));
			} catch (IOException e) {
				Console.error("file not found or empty");
			}
			this.columnName = nameColum;
			this.from = from;
			this.to = to;
		}
		
		public Tm2Parser(String filename, ColumnNames nameColum){
			try {			
				in = new BufferedReader(new FileReader(filename));
			} catch (IOException e) {
				Console.error("file not found or empty");
			}
			this.columnName = nameColum;
		}
		
		@Override
		public Coordinate[] loadData(boolean avoidFirstRow) {
			String nextLine = "";
			int rowCounter = 1;
			try {
				if(avoidFirstRow)
						in.readLine();
				int[] accessColumn = calculateAccessColumn(columnName);
				
				int[] accessYear = calculateAccessColumn(ColumnNames.Year);
				int[] accessMonth = calculateAccessColumn(ColumnNames.Month);
				int[] accessDay = calculateAccessColumn(ColumnNames.Day);
				int[] accessHour = calculateAccessColumn(ColumnNames.Hour);
				
				while ((nextLine = in.readLine()) != null) {
					 int firstCharacter = 0;
					 if (nextLine.substring(0, 1).equals(" "))
						 firstCharacter = 1;
					
					 
				     int year = Integer.parseInt(nextLine.substring(accessYear[0] + firstCharacter, accessYear[1]));
				     int month = Integer.parseInt(nextLine.substring(accessMonth[0], accessMonth[1])) - 1;
				     int day = Integer.parseInt(nextLine.substring(accessDay[0], accessDay[1]));
				     int hour = Integer.parseInt(nextLine.substring(accessHour[0], accessHour[1]));
				     Calendar calendar = Calendar.getInstance();
				     calendar.clear();
				     calendar.set(1900 + year, month, day, hour, 0);
				     Date date = calendar.getTime();
				     
				     if (date.compareTo(from) > -1 && date.compareTo(to) < 1){
					 
						 Coordinate coordinate = new Coordinate (rowCounter, 
								 								 Double.parseDouble(nextLine.substring(accessColumn[0], accessColumn[1])));
					     coordinatesList.add(coordinate);
						
						 indexToDate.put(rowCounter, date);
						 dateToIndex.put(date, rowCounter);
						
						 rowCounter++;
				     }
				     /* IT'S SUPPOSED THAT DATA WILL BE SORTED. DICOTOMIC SEARCH COULD BE INTERESTING */
				     if (date.compareTo(to) == 1)
				    	 break;
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
	
		private int[] calculateAccessColumn (ColumnNames columnName) {
			int letterCounter = 0;
			int width = 0;
			for(Tm2ColumnFormat column : parserHelper){
				if(column.dataName != columnName)
					letterCounter += column.width + column.numberOfFlags;
				else{
					width = column.width;
					break;
				}	
			}
			return new int[]{letterCounter, letterCounter + width};
		}

		public Date getDate (int index){
			return indexToDate.get(index);
		}
		
		@SuppressWarnings("deprecation")
		public int getIndex (Date date){
//			if (date.getMinutes() > 30){
//				date.setTime(date.getTime() + 1800000);
//				date.setMinutes(0);				
//			}
//			else
				date.setMinutes(0);
			date.setSeconds(0);
			if (dateToIndex.get(date) == null)
				return -1;
			return dateToIndex.get(date);
		}
		
		private class Tm2ColumnFormat{
			ColumnNames dataName;
			int width;
			int numberOfFlags;
			
			public Tm2ColumnFormat (ColumnNames dataName, int width, int numberOfFlags){
				this.dataName = dataName;
				this.width = width;
				this.numberOfFlags = numberOfFlags;
			}
		}
}
