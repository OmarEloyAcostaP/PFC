package tafat.engine.interoperability;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSHandler {

	public Workbook wb = null;
	public Sheet sheet = null;
	public String inputFile = null;
	
	public XLSHandler (String filePath, int sheetNumber){
		this.inputFile = filePath;
		
		File file = new File (this.inputFile);
		if (!file.exists())
			try {
				Workbook wb = null; 
				if (this.inputFile.endsWith(".xlsx"))
					wb = new XSSFWorkbook();
				else if (this.inputFile.endsWith(".xls"))
					wb = new HSSFWorkbook();
			    FileOutputStream fileOut = new FileOutputStream(this.inputFile);
			    wb.createSheet("sheet 0");
			    wb.write(fileOut);
			    fileOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		setFile(filePath, sheetNumber);
	}
	
	public XLSHandler (String filePath, String sheetName){
		this.inputFile = filePath;
		
		File file = new File (this.inputFile);
		if (!file.exists())
			try {
				Workbook wb = null; 
				if (this.inputFile.endsWith(".xlsx"))
					wb = new XSSFWorkbook();
				else if (this.inputFile.endsWith(".xls"))
					wb = new HSSFWorkbook();
			    FileOutputStream fileOut = new FileOutputStream(this.inputFile);
			    wb.createSheet("sheet 0");
			    wb.write(fileOut);
			    fileOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		setFile(filePath, sheetName);
	}
	
	private void setFile(String inputFile, int sheetNumber) {
		try {
			wb = WorkbookFactory.create(new FileInputStream(inputFile));
			sheet = wb.getSheetAt(sheetNumber);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}
	}
	
	private void setFile(String inputFile, String sheetName) {
		try {
			wb = WorkbookFactory.create(new FileInputStream(inputFile));
			sheet = wb.getSheet(sheetName);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}
	}
	
	public void write(){
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(inputFile);
		    wb.write(fileOut);
		    fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void write(String outputPath){
		if (outputPath == null)
			return;
		
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(outputPath);
		    wb.write(fileOut);
		    fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String[] readColumn(String nameOfColumn)  {
		String out = "";
		for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
			if(sheet.getRow(0).getCell(j).getStringCellValue().equals(nameOfColumn)){
				for (int i = 1; i < sheet.getLastRowNum(); i++)
					out += sheet.getRow(i).getCell(j).getStringCellValue() + "@";
				break;
			}
		}
		return out.split("@");
	}
	
	public String[] readRow(int numberOfRow)  {
		String out = "";
		for(int i = 0; i < sheet.getRow(numberOfRow).getLastCellNum(); i++)
			out += sheet.getRow(numberOfRow).getCell(i).getStringCellValue() + "@";
		return out.split("@");
	}
	
	public String readCellofRow(int numberOfRow, String nameOfColumn){
		for (int j = 0; j < sheet.getRow(numberOfRow).getLastCellNum(); j++)
			if(sheet.getRow(0).getCell(j).getStringCellValue().equals(nameOfColumn))
				if (sheet.getRow(numberOfRow).getCell(j).getCellType() == Cell.CELL_TYPE_STRING)
					return sheet.getRow(numberOfRow).getCell(j).getStringCellValue();
				else if (sheet.getRow(numberOfRow).getCell(j).getCellType() == Cell.CELL_TYPE_NUMERIC)
					return sheet.getRow(numberOfRow).getCell(j).getNumericCellValue() + "";
				else if (sheet.getRow(numberOfRow).getCell(j).getCellType() == Cell.CELL_TYPE_BOOLEAN)
					return Boolean.toString(sheet.getRow(numberOfRow).getCell(j).getBooleanCellValue());
		return "";
	}
	
	public String readStringCellofRow(int numberOfRow, String nameOfColumn)  {
		for (int j = 0; j < sheet.getRow(numberOfRow).getLastCellNum(); j++)
			if(sheet.getRow(0).getCell(j).getStringCellValue().equals(nameOfColumn))
				return sheet.getRow(numberOfRow).getCell(j).getStringCellValue();
		return "";
	}
	
	public double readDoubleCellofRow(int numberOfRow, String nameOfColumn)  {
		for (int j = 0; j < sheet.getRow(numberOfRow).getLastCellNum(); j++)
			if(sheet.getRow(0).getCell(j).getStringCellValue().equals(nameOfColumn))
				return sheet.getRow(numberOfRow).getCell(j).getNumericCellValue();
		return Double.NaN;
	}
	
	public Date readDateCellofRow(int numberOfRow, String nameOfColumn)  {
		for (int j = 0; j < sheet.getRow(numberOfRow).getLastCellNum(); j++)
			if(sheet.getRow(0).getCell(j).getStringCellValue().equals(nameOfColumn))
				return sheet.getRow(numberOfRow).getCell(j).getDateCellValue();
		return null;
	}
	
	
	public Boolean readBooleanCellofRow(int numberOfRow, String nameOfColumn)  {
		for (int j = 0; j < sheet.getRow(numberOfRow).getLastCellNum(); j++)
			if(sheet.getRow(0).getCell(j).getStringCellValue().equals(nameOfColumn))
				return sheet.getRow(numberOfRow).getCell(j).getBooleanCellValue();
		return null;
	}
	
	public void writeCellOfRow(int numberOfRow, String nameOfColumn, String value)  {
		if (sheet.getRow(numberOfRow) == null)
			sheet.createRow(numberOfRow);
		
		for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
			if(sheet.getRow(0).getCell(j).getStringCellValue().equals(nameOfColumn)){
				if (sheet.getRow(numberOfRow).getCell(j) == null)
					sheet.getRow(numberOfRow).createCell(j);
				sheet.getRow(numberOfRow).getCell(j).setCellValue(value);
				return;
			}
		}
	}
	
	public void writeCellOfRow(int numberOfRow, String nameOfColumn, double value)  {
		if (sheet.getRow(numberOfRow) == null)
			sheet.createRow(numberOfRow);
		
		for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
			if(sheet.getRow(0).getCell(j).getStringCellValue().equals(nameOfColumn)){
				if (sheet.getRow(numberOfRow).getCell(j) == null)
					sheet.getRow(numberOfRow).createCell(j);
				sheet.getRow(numberOfRow).getCell(j).setCellValue(value);
				return;
			}
		}
	}
	
	public void writeCellOfRow(int numberOfRow, String nameOfColumn, Date value)  {
		if (sheet.getRow(numberOfRow) == null)
			sheet.createRow(numberOfRow);
		
		for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
			if(sheet.getRow(0).getCell(j).getStringCellValue().equals(nameOfColumn)){
				if (sheet.getRow(numberOfRow).getCell(j) == null)
					sheet.getRow(numberOfRow).createCell(j);
				sheet.getRow(numberOfRow).getCell(j).setCellValue(value);
				return;
			}
		}
	}
	
	public void writeCellOfRow(int numberOfRow, String nameOfColumn, boolean value)  {
		if (sheet.getRow(numberOfRow) == null)
			sheet.createRow(numberOfRow);
		
		for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
			if(sheet.getRow(0).getCell(j).getStringCellValue().equals(nameOfColumn)){
				if (sheet.getRow(numberOfRow).getCell(j) == null)
					sheet.getRow(numberOfRow).createCell(j);
				sheet.getRow(numberOfRow).getCell(j).setCellValue(value);
				return;
			}
		}
	}

	public int getNumberOfEntries() {
		return sheet.getLastRowNum() + 1;
	}

}

