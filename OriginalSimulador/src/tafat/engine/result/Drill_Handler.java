package tafat.engine.result;

import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Sheet;

import tafat.engine.Console;
import tafat.engine.ModelObject;

public class Drill_Handler {

	Drill drillXml;

	ArrayList <Filter_Handler> filterSeries = new ArrayList <Filter_Handler> ();
	ArrayList <Filter_Handler> filterValues = new ArrayList <Filter_Handler> ();
	ArrayList<Write_Handler> writers = new ArrayList<Write_Handler> ();
	ArrayList<ModelObject> objects = new ArrayList<ModelObject> ();	
	
	ArrayList <Drill_Handler> drills = new ArrayList <Drill_Handler> ();
	
	/* Class option*/
	Class<?> classToSearch = null;
	
	public Drill_Handler(Drill drill, Sheet excelSheet, CsvSheet csvSheet, ArrayList <ModelObject> parentObjects, String selectObjectId) {
		configure (drill, excelSheet, csvSheet, parentObjects, selectObjectId);
	}

	public Drill_Handler(Drill drill, Sheet excelSheet, CsvSheet csvSheet,ModelObject parentObject, String selectObjectId) {
		ArrayList<ModelObject> parent = new ArrayList<ModelObject> ();
		parent.add(parentObject);
		configure (drill, excelSheet, csvSheet, parent, selectObjectId);
	}

	private void configure(Drill drill, Sheet excelSheet, CsvSheet csvSheet, ArrayList <ModelObject> parentObjects, String selectObjectId){
		drillXml = drill;
		
		if (drillXml.getTypeClass() != null){
			try {
				classToSearch = Class.forName("tafat.metamodel.entity." + drillXml.getTypeClass());
			} catch (ClassNotFoundException e) {
				Console.error("Class " + drillXml.getTypeClass() + " does not exist");
			}
			
			for (Filter_Serie filter : drillXml.getFilter_Serie())
				filterSeries.add(new Filter_Handler (filter, classToSearch));
			
			for (Filter_Value filter : drillXml.getFilter_Value())
				filterValues.add(new Filter_Handler (filter, classToSearch));
			
			ArrayList <ModelObject> objectList = new ArrayList <ModelObject> ();  
			for (ModelObject object : parentObjects){
				if ((drill.getRecursive().toLowerCase().equals("yes")) || (drill.getRecursive().toLowerCase().equals("true")))			
					objectList.addAll(object.collect(classToSearch, true));
				else
					objectList.addAll(object.collect(classToSearch, false));
			}
			
			boolean passFilters = true;
			for (ModelObject object : objectList){
				for (Filter_Handler filter : filterValues)
					if (!filter.passFilter(object)){
						passFilters = false;
						break;
					}
				if (passFilters)
					objects.add(object);
			}						
		}
		if (objects.size() > 0){
			processWrites(excelSheet, csvSheet, selectObjectId);
			for (Drill subDrill : drillXml.getDrillList())
				drills.add(new Drill_Handler(subDrill, excelSheet, csvSheet, objects, selectObjectId));
		}
	}
	private void processWrites(Sheet excelSheet, CsvSheet csvSheet, String selectObjectId) {
		ArrayList<String> attributesSorted = sortAttributes();
		
		for (String attribute : attributesSorted){
			boolean found = false;
			for (Write_Value write : drillXml.getWrite_Value())
				if (attribute.equals(write.getAttribute() + "@" + write.getType())){
					writers.add(new Write_Handler (write, excelSheet, csvSheet, objects, selectObjectId));
					found = true;
					break;
				}
			if (found)
				continue;
			for (Write_Serie write : drillXml.getWrite_Serie())
				if (attribute.equals(write.getAttribute() + "@" + write.getType())){
					writers.add(new Write_Handler (write, excelSheet, csvSheet, objects, selectObjectId));
					break;
				}
		}
	}

	private ArrayList<String> sortAttributes() {
		ArrayList<String> toReturn = new ArrayList<String> ();
		
		for (Write_Value write : drillXml.getWrite_Value())
			if (write.getType().toLowerCase().equals("average"))
				toReturn.add(write.getAttribute() + "@" + "average");
		
		for (Write_Serie write : drillXml.getWrite_Serie())
			if (write.getType().toLowerCase().equals("average"))
				toReturn.add(write.getAttribute() + "@" + "average");
		
		for (Write_Value write : drillXml.getWrite_Value())
			if (write.getType().toLowerCase().equals("sum"))
				toReturn.add(write.getAttribute() + "@" + "sum");
		
		for (Write_Serie write : drillXml.getWrite_Serie())
			if (write.getType().toLowerCase().equals("sum"))
				toReturn.add(write.getAttribute() + "@" + "sum");
		
		for (Write_Value write : drillXml.getWrite_Value())
			if (write.getType().toLowerCase().equals("all"))
				toReturn.add(write.getAttribute() + "@" + "all");
		
		for (Write_Serie write : drillXml.getWrite_Serie())
			if (write.getType().toLowerCase().equals("all"))
				toReturn.add(write.getAttribute() + "@" + "all");

		return toReturn;
	}

	public void terminate() {
		for (Write_Handler writer : writers)
			writer.terminate();
		for (Drill_Handler drill : drills)
			drill.terminate();
	}
	


	public void tick(int rowIndex, Sheet excelSheet, CsvSheet csvSheet, boolean write){
		for (Write_Handler writer : writers)
			writer.tick(rowIndex ,objects, filterSeries, excelSheet, csvSheet, write);
		for (Drill_Handler drill : drills)
			drill.tick(rowIndex, excelSheet, csvSheet, write);
	}
}
