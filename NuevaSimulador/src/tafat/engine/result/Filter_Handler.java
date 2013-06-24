package tafat.engine.result;

import java.lang.reflect.Field;

import tafat.engine.Console;
import tafat.engine.ModelObject;
import tafat.engine.Tools;

public class Filter_Handler {
	
	final String EQUAL = "eq";
	final String NONEQUAL = "ne";
	final String GREATEROREQUAL = "ge";
	final String LESSOREQUAL = "le";
	final String GREATER = "g";
	final String LESS = "l";
	final String CONTAINS = "co";
	final String NOCONTAINS = "nco";
	
	
	Field field;
	String operator;
	String valueString;
	double valueDouble;
	boolean serie;
	boolean valid = true;
	
	public Filter_Handler(Filter_Serie filterSerie, Class<?> classToFilter){
		configure(filterSerie.getAttribute(), filterSerie.getOperator(), filterSerie.getValue(), classToFilter);
		serie = true;
	}
	
	private void configure(String attribute, String operator, String value, Class<?> classToFilter) {
		this.field = Tools.getField(classToFilter, attribute);
		this.operator = operator;
		try{
			valueDouble = Double.parseDouble(value);
			if (!((operator.equals(EQUAL)) || (operator.equals(NONEQUAL)) || (operator.equals(GREATEROREQUAL)) || 
				 (operator.equals(LESSOREQUAL)) || (operator.equals(GREATER)) || (operator.equals(LESS)))){
				Console.error("Field: " + field.getName() + " is not valid under the operator: " + operator + ". It will be ignored");
				valid = false;
			}				
		}catch (NumberFormatException e){
			valueDouble = Double.NaN;
			valueString = value;
			if (!((operator.equals(EQUAL)) || (operator.equals(NONEQUAL)) || (operator.equals(CONTAINS)) || (operator.equals(NOCONTAINS)))){
				Console.error("Field: " + field.getName() + " is not valid under the operator: " + operator + ". It will be ignored");
				valid = false;
			}
		}
	}

	public Filter_Handler(Filter_Value filterValue, Class<?> classToFilter){
		configure(filterValue.getAttribute(), filterValue.getOperator(), filterValue.getValue(), classToFilter);
		serie = false;
	}
	
	public boolean passFilter (ModelObject object){
		if (valid){
			if (Double.isNaN(valueDouble))
				return checkFilterAsString(object);
			else
				return checkFilterAsDouble(object);
			}
		return true;
	}	
	
	private boolean checkFilterAsDouble(ModelObject object) {
		if (operator.equals(EQUAL)){
			try {// TOLERANCE
				return field.getDouble(object) == valueDouble;
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		else if (operator.equals(NONEQUAL)){
			try {
				return field.getDouble(object) != valueDouble;
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		else if (operator.equals(GREATEROREQUAL)){
			try {
				return field.getDouble(object) >= valueDouble;
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		else if (operator.equals(LESSOREQUAL)){
			try {
				return field.getDouble(object) <= valueDouble;
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		else if (operator.equals(GREATER)){
			try {
				return field.getDouble(object) > valueDouble;
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		else if (operator.equals(LESS)){
			try {
				return field.getDouble(object) < valueDouble;
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	private boolean checkFilterAsString(ModelObject object) {
		if (operator.equals(EQUAL)){
			try {
				return field.get(object).toString().equals(valueString);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		else if (operator.equals(NONEQUAL)){
			try {
				return !(field.get(object).toString().equals(valueString));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		else if (operator.equals(CONTAINS)){
			try {
				return (field.get(object).toString().contains(valueString));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		else if (operator.equals(NOCONTAINS)){
			try {
				return !(field.get(object).toString().contains(valueString));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
}
