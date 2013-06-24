package tafat.engine.result;

import java.lang.reflect.Field;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import tafat.engine.Console;
import tafat.engine.ModelObject;
import tafat.engine.Tools;

public class Write_Handler {

	int firstCol;
	int lastCol;
	
	Field field;
	String type;
	boolean serie;
	
	ArrayList <Write_Handler_Storage> storage = new ArrayList <Write_Handler_Storage> ();
	
	final String csvSeparator = ",";
	
	public Write_Handler (Write_Serie write, Sheet excelSheet, CsvSheet csvSheet, ArrayList <ModelObject> objects, String selectObjectId){
		configure(write.getAttribute(), write.getType().toLowerCase(), objects, excelSheet, csvSheet, selectObjectId);
		serie = true;
	}	

	public Write_Handler (Write_Value write, Sheet excelSheet, CsvSheet csvSheet, ArrayList <ModelObject> objects, String selectObjectId){
		configure(write.getAttribute(), write.getType().toLowerCase(), objects, excelSheet, csvSheet, selectObjectId);
		serie = false;
	}
	
	public boolean isSerie(){
		return serie;
	}
	
	private void configure(String attributeName, String type, ArrayList<ModelObject> objects, Sheet excelSheet, CsvSheet csvSheet, String selectObjectId) {
		this.field = Tools.getField(objects.get(0).getClass(), attributeName);	
		this.type = type;
		
		writeHeaders(objects, excelSheet, csvSheet, selectObjectId);
	}
	
	void writeHeaders (ArrayList<ModelObject> objects, Sheet excelSheet, CsvSheet csvSheet, String selectObjectId) {
		if (csvSheet == null){		
			firstCol = excelSheet.getRow(0).getLastCellNum();
			if (type.equals("all") || type.equals("defined"))
				lastCol = firstCol + objects.size();
			else
				lastCol = firstCol;
		}
		
		
		String fieldName = "FieldNotFound";
		if (field != null)
			fieldName = field.getName();
		
		if (type.equals("all") || type.equals("defined")){
			int currentCol = firstCol;
			for (ModelObject object : objects){
				String id = object.id;
				storage.add(new Write_Handler_Storage(id));
				if (id.equals("")){
					id = getParentId(object);
					if (csvSheet == null)
						excelSheet.getRow(0).createCell(currentCol++).setCellValue(id + "_" + objects.get(0).getClass().getSimpleName() + "_"+ fieldName);
					else
						csvSheet.add(id + "_" + objects.get(0).getClass().getSimpleName() + "_"+ fieldName);
				}
				else
					if (csvSheet == null)
						excelSheet.getRow(0).createCell(currentCol++).setCellValue(id + "_"+ fieldName);
					else
						csvSheet.add(id + "_"+ fieldName);
			}
		}
		else{
			storage.add(new Write_Handler_Storage(type));
			if (csvSheet == null)
				excelSheet.getRow(0).createCell(firstCol).setCellValue(selectObjectId + "_" + objects.get(0).getClass().getSimpleName() + "_"+ fieldName + "_" + type);
			else
				csvSheet.add(selectObjectId + "_" +  objects.get(0).getClass().getSimpleName() + "_"+ fieldName + "_" + type);
		}
	}
	
	private String getParentId(ModelObject object) {
		ModelObject aux = object;
		while (aux.getFirstOwner() != null){
			if (!aux.id.equals(""))
				return aux.id;
			aux = aux.getFirstOwner();
		}
		return "unknown";
	}

	public void writeElements (int rowNumber, ArrayList <ModelObject> objects, ArrayList<Filter_Handler> filters, Sheet excelSheet, CsvSheet csvSheet, boolean write){
		if (field == null)
			return;
		
		Row row = null;
		if (excelSheet != null){
			row = excelSheet.getRow(rowNumber);
			if (row == null)
				row = excelSheet.createRow(rowNumber);
		}
		
		if (type.equals("all"))
			writeElementsAll(objects, filters, row, csvSheet, write);
		else if (type.equals("sum"))
			writeElementsSum(objects, filters, row, csvSheet, write);
		else if (type.equals("average"))
			writeElementsAverage(objects, filters, row, csvSheet, write);
		else if (type.equals("defined"))
			writeElementsDefined(objects, filters, row, csvSheet, write);
	}
	
	private void writeElementsDefined(ArrayList <ModelObject> objects, ArrayList<Filter_Handler> filters, Row row,  CsvSheet csvSheet, boolean write) {
		int currentCol = firstCol;
		for (ModelObject object : objects){
			if (write){
				if (!checkFilters(filters, object)){
					if (row != null)
						row.createCell(currentCol).setCellValue("Filter");
					else
						csvSheet.add("Filter");
					currentCol++;
					continue;
				}
				else{
					if (row != null){
						try{
							if (field.get(object) == null)
								row.createCell(currentCol).setCellValue(0);
							else
								row.createCell(currentCol).setCellValue(1);
						} catch (IllegalArgumentException e1) {
							e1.printStackTrace();
						} catch (IllegalAccessException e1) {
							e1.printStackTrace();
						}
					}
					else{
						try{
							if (field.get(object) == null)
								csvSheet.add(0 + "");
							else
								csvSheet.add(1 + "");
						} catch (IllegalArgumentException e1) {
							e1.printStackTrace();
						} catch (IllegalAccessException e1) {
							e1.printStackTrace();
						}
					}
				}
			}		
			currentCol++;
		}
	}
	
	private void writeElementsAverage(ArrayList <ModelObject> objects, ArrayList<Filter_Handler> filters, Row row,  CsvSheet csvSheet, boolean write) {
		double average = 0;
		int noFilter = 0;
		
		for (ModelObject object : objects){
			if (!checkFilters(filters, object)){
				noFilter++;
				continue;
			}
			
			try {
				average += field.getDouble(object);
			} catch (IllegalArgumentException e) {
				Console.error("Field " + field.getName() + " is not a numeric attribute. Sum and Average not available.");
				//e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		average /= (objects.size() - noFilter);
		
		storage.get(0).addValue(average);
		
		if (write){
			if (row != null)
				row.createCell(firstCol).setCellValue(storage.get(0).getValue());
			else
				csvSheet.add(storage.get(0).getValue() + "");
		}
	}

	private void writeElementsSum(ArrayList <ModelObject> objects, ArrayList<Filter_Handler> filters, Row row,  CsvSheet csvSheet, boolean write) {
		
		double sum = 0;
		for (ModelObject object : objects){
			
			if (!checkFilters(filters, object))
				continue;
			
			try {
				sum += field.getDouble(object);
			} catch (IllegalArgumentException e) {
				Console.error("Field " + field.getName() + " is not a numeric attribute. Sum and Average not available.");
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
//			if (Double.isNaN(sum))
//				Console.out("NANCY");
		}
		
		storage.get(0).addValue(sum);
		
		if (write){
			if (row != null)
				row.createCell(firstCol).setCellValue(storage.get(0).getValue());
			else
				csvSheet.add(storage.get(0).getValue() + "");
		}
	}

	private void writeElementsAll(ArrayList <ModelObject> objects, ArrayList<Filter_Handler> filters, Row row,  CsvSheet csvSheet, boolean write) {
		int currentCol = firstCol;
		for (ModelObject object : objects){
			Write_Handler_Storage elementToFind = null;
			for (Write_Handler_Storage element : storage)
				if (element.objectId.equals(object.id)){
					elementToFind = element;
					break;
				}
			
			try {
				double value = field.getDouble(object);
				elementToFind.addValue(value);
			} catch (IllegalArgumentException e2) {
				elementToFind.addValue(Double.NaN);
			} catch (IllegalAccessException e2) {
				e2.printStackTrace();
			}
			
			if (write){
				if (!checkFilters(filters, object)){
					if (row != null)
						row.createCell(currentCol).setCellValue("Filter");
					else
						csvSheet.add("Filter");
					currentCol++;
					continue;
				}
				
				if (row != null){
					if (elementToFind.isDouble)
						row.createCell(currentCol).setCellValue(elementToFind.getValue());
					else{
						try {
							row.createCell(currentCol).setCellValue(field.get(object).toString());
						} catch (IllegalArgumentException e1) {
							e1.printStackTrace();
						} catch (IllegalAccessException e1) {
							e1.printStackTrace();
						}
					}
				}
				else{
					if (elementToFind.isDouble)
						csvSheet.add(elementToFind.getValue() + "");
					else{
						try {
							csvSheet.add(field.get(object).toString());
						} catch (IllegalArgumentException e) {
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						}
					}
				}
			}		
			currentCol++;
		}
	}
	
	public boolean checkFilters (ArrayList <Filter_Handler> filters, ModelObject object){
		if (filters != null){
			boolean passFilters = true;
			for (Filter_Handler filter : filters)
				if (!filter.passFilter(object)){
					passFilters = false;
					break;
				}
			return passFilters;
		}
		return true;
	}

	public void terminate() {}

	public void tick(int rowNumber, ArrayList<ModelObject> objects, ArrayList<Filter_Handler> filter, Sheet excelSheet, CsvSheet csvSheet, boolean write) {
		if (serie)
			writeElements(rowNumber, objects, filter, excelSheet, csvSheet, write);
		else if (rowNumber == 1)
			writeElements(rowNumber, objects, null, excelSheet, csvSheet, write);
		else if ((write)&&(excelSheet == null))
			for (@SuppressWarnings("unused") ModelObject object : objects)
				csvSheet.add("");
	}
	
}
