package tafat.engine.result;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Sheet;

import tafat.control.Main;
import tafat.engine.Console;
import tafat.engine.ModelObject;
import tafat.engine.Time;

public class Select_Handler {

	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
	
	Select selectXml;
	Sheet excelSheet = null;
	CsvSheet csvSheet = null;

	ArrayList <Filter_Handler> filterSeries = new ArrayList <Filter_Handler> ();
	ArrayList <Filter_Handler> filterValues = new ArrayList <Filter_Handler> ();
	ArrayList<Write_Handler> writers = new ArrayList<Write_Handler> ();
	ArrayList<ModelObject> objects = new ArrayList<ModelObject> ();
	
	ArrayList <Drill_Handler> drills = new ArrayList <Drill_Handler> ();
	
	/* Class option*/
	Class<?> classToSearch = null;
	
	public Select_Handler(Select select, Sheet s, CsvSheet csvSheet) {
		selectXml = select;
		excelSheet = s;
		this.csvSheet = csvSheet;
		
		if (selectXml.getTypeClass() != null){
			ArrayList <ModelObject> objectList = null;
			try {
				classToSearch = Class.forName("tafat.metamodel.entity." + selectXml.getTypeClass());
				objectList = Main.scene.collect(classToSearch, true);
			} catch (ClassNotFoundException e) {
				try {
					classToSearch = Class.forName("tafat.metamodel.connection." + selectXml.getTypeClass());
					objectList = Main.topology.collect(classToSearch, true);
				} catch (ClassNotFoundException e1) {
					Console.error("Class " + select.getTypeClass() + " does not exist");
					return;
				}
			}
			
			for (Filter_Serie filter : selectXml.getFilter_Serie())
				filterSeries.add(new Filter_Handler (filter, classToSearch));
			
			for (Filter_Value filter : selectXml.getFilter_Value())
				filterValues.add(new Filter_Handler (filter, classToSearch));
			
			for (ModelObject object : objectList){
				boolean passFilters = true;
				for (Filter_Handler filter : filterValues)
					if (!filter.passFilter(object)){
						passFilters = false;
						break;
					}
				if (passFilters)
					objects.add(object);
			}						
		}
		else if (selectXml.getId() != null){
			objects.add(Main.scene.item.get(selectXml.getId()));
		}
		if (objects.size() > 0){
			processWrites();
			for (Drill drill : selectXml.getDrillList())
				for (ModelObject object : objects)
					drills.add(new Drill_Handler(drill, s, csvSheet, object, object.id));
			if (excelSheet == null)
				csvSheet.newLine();
		}

	}

	private void processWrites() {
		ArrayList<String> attributesSorted = sortAttributes();
		
		for (String attribute : attributesSorted){
			boolean found = false;
			for (Write_Value write : selectXml.getWrite_Value())
				if (attribute.equals(write.getAttribute() + "@" + write.getType())){
					writers.add(new Write_Handler (write, excelSheet, csvSheet, objects, ""));
					found = true;
					break;
				}
			if (found)
				continue;
			for (Write_Serie write : selectXml.getWrite_Serie())
				if (attribute.equals(write.getAttribute() + "@" + write.getType())){
					writers.add(new Write_Handler (write, excelSheet, csvSheet, objects, ""));
					break;
				}
		}
	}

	private ArrayList<String> sortAttributes() {
		ArrayList<String> toReturn = new ArrayList<String> ();
		
		for (Write_Value write : selectXml.getWrite_Value())
			if (write.getType().toLowerCase().equals("average"))
				toReturn.add(write.getAttribute() + "@" + "average");
		
		for (Write_Serie write : selectXml.getWrite_Serie())
			if (write.getType().toLowerCase().equals("average"))
				toReturn.add(write.getAttribute() + "@" + "average");
		
		for (Write_Value write : selectXml.getWrite_Value())
			if (write.getType().toLowerCase().equals("sum"))
				toReturn.add(write.getAttribute() + "@" + "sum");
		
		for (Write_Serie write : selectXml.getWrite_Serie())
			if (write.getType().toLowerCase().equals("sum"))
				toReturn.add(write.getAttribute() + "@" + "sum");
		
		for (Write_Value write : selectXml.getWrite_Value())
			if (write.getType().toLowerCase().equals("all"))
				toReturn.add(write.getAttribute() + "@" + "all");
		
		for (Write_Serie write : selectXml.getWrite_Serie())
			if (write.getType().toLowerCase().equals("all"))
				toReturn.add(write.getAttribute() + "@" + "all");
		
		for (Write_Value write : selectXml.getWrite_Value())
			if (write.getType().toLowerCase().equals("defined"))
				toReturn.add(write.getAttribute() + "@" + "defined");
		
		for (Write_Serie write : selectXml.getWrite_Serie())
			if (write.getType().toLowerCase().equals("defined"))
				toReturn.add(write.getAttribute() + "@" + "defined");
		
		return toReturn;
	}

	public void terminate() {
		if (excelSheet != null)
			for (int i = 0; i < excelSheet.getRow(0).getLastCellNum(); i++)
				excelSheet.autoSizeColumn(i);
				
		for (Write_Handler writer : writers)
			writer.terminate();
		for (Drill_Handler drill : drills)
			drill.terminate();
	}
	


	public void tick(int rowIndex, boolean write){
		
		if (write){
			if (excelSheet != null){
				excelSheet.createRow(rowIndex).createCell(0).setCellValue(dateFormat.format(Time.getInstance().getSimulationDate()));
				excelSheet.createRow(rowIndex).createCell(1).setCellValue(timeFormat.format(Time.getInstance().getSimulationDate()));
			}
			else{
				csvSheet.add(dateFormat.format(Time.getInstance().getSimulationDate()));
				csvSheet.add(timeFormat.format(Time.getInstance().getSimulationDate()));
			}
		}
		
		for (Write_Handler writer : writers)
			writer.tick(rowIndex ,objects, filterSeries, excelSheet, csvSheet, write);
		for (Drill_Handler drill : drills)
			drill.tick(rowIndex, excelSheet, csvSheet, write);
		
		if (write)
			if (excelSheet == null)
				csvSheet.newLine();
	}
}
