package tafat.engine;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tools {
	public static int randomInRangeInt(int min, int max){
		double minD = min - 0.49;
		double maxD = max + 0.49;
		return (int) (Math.round(Math.random()* (maxD-minD) + minD));		
	}

	public static double randomInRangeDouble(double min, double max) {
		return (Math.random()*(max-min))+min;	
	}
	
	// STACK OVERFLOW code
	public static List<Field> getAllFields(List<Field> fields, Class<?> type) {
	    for (Field field: type.getDeclaredFields()) {
	        fields.add(field);
	    }

	    if (type.getSuperclass() != null) {
	        fields = getAllFields(fields, type.getSuperclass());
	    }

	    return fields;
	}
	
	public static Field getField (Class<?> type, String fieldName) {
		for (Field field : getAllFields(new ArrayList <Field> (), type))
			if (field.getName().equals(fieldName))
				return field;
		return null;
	}
	
	@SuppressWarnings("deprecation")
	public static double getDecimaltime (Date time){
		return time.getHours() + time.getMinutes() / 60. + time.getSeconds() / 3600.;
	}
}
