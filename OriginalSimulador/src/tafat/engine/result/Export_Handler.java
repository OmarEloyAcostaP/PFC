package tafat.engine.result;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.simpleframework.xml.Root;

import tafat.engine.Console;
import tafat.engine.Time;

@Root
public class Export_Handler {
	
	Export exportXml;
	FileOutputStream out;
	Workbook wb = null;
	int countdown;
	int step;
	Date from;
	Date to;
	int rowIndex = 0;	
	
	boolean csvWorkbook = false;
	
	ArrayList<Select_Handler> select_HandlerList = new ArrayList<Select_Handler> ();
	
	public Export_Handler(Export export) {
		exportXml = export;
		
		if (exportXml.getFilename().endsWith(".xlsx"))
			wb = new XSSFWorkbook();
		else if (exportXml.getFilename().endsWith(".xls"))
			wb = new HSSFWorkbook();
		else if (exportXml.getFilename().endsWith(".csv"))
			csvWorkbook = true;
		else
			Console.error("File extension not recognized for a Excel file or Csv file");
		
		if ((wb == null) && (!csvWorkbook))
			return;
		
		for (int i = 0; i < export.getSelectList().size(); i++){
			Select select = export.getSelectList().get(i);
			Sheet excelSheet = null;
			CsvSheet csvSheet = null;
			
			if (wb != null){
				if (select.getName() != null)
					excelSheet = wb.createSheet(select.getName());
				else
					excelSheet = wb.createSheet();
				excelSheet.createRow(0).createCell(0).setCellValue("Date");
				excelSheet.createRow(0).createCell(0).setCellValue("Time");
			}
			else{
				if (select.getName() != null)
					csvSheet = new CsvSheet(select.getName());
				else
					csvSheet = new CsvSheet("select_" + i );
				csvSheet.add("Date");
				csvSheet.add("Time");
			}
			select_HandlerList.add(new Select_Handler(select, excelSheet, csvSheet));
		}
			

		step = exportXml.getStep();
		countdown = 0;
		
		from = exportXml.getFrom();
		to = exportXml.getTo();
	}

	public void terminate() {
		if ((wb == null) && (!csvWorkbook))
			return;
		
		if (!csvWorkbook){
			for (int i = 0; i < wb.getNumberOfSheets(); i++)
				wb.getSheetAt(i).autoSizeColumn(0);
			
			for (Select_Handler select : select_HandlerList)
				select.terminate();
			
			FileOutputStream fileOut;
			try {
				fileOut = new FileOutputStream(exportXml.getFilename());
				wb.write(fileOut);
				fileOut.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		else{
			for (Select_Handler select : select_HandlerList){
				try {
					OutputStream out = new FileOutputStream(select.csvSheet.getName() + "_" + exportXml.getFilename());
					out.write(select.csvSheet.getContent());
					out.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void tick() {
		if ((wb == null) && (!csvWorkbook))
			return;
		
		if (countdown == 0)
			countdown = step;
		else{
			countdown--;
			if (exportXml.getType().toLowerCase().equals("average"))
				for (Select_Handler select : select_HandlerList)
					select.tick(rowIndex, false);
			return;
		}
		countdown--;
		
		if ((from == null) || (to == null)){
			rowIndex++;
			
			for (Select_Handler select : select_HandlerList)
				select.tick(rowIndex, true);
			return;
		}
		
		if ((Time.getInstance().getSimulationDate().after(from)) && Time.getInstance().getSimulationDate().before(to)){
			rowIndex++;
			for (Select_Handler select : select_HandlerList)
				select.tick(rowIndex, true);
		}
	}
}
