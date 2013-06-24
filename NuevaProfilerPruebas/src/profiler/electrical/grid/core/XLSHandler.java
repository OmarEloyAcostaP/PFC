package profiler.electrical.grid.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class XLSHandler {

	private InputStream inp;
	private Workbook wb;
	private Sheet sheet;
	private String inputFile;
	private String outputFile;

	public XLSHandler(String inputFile, String outputFile) {
		this.inputFile = inputFile;
		this.outputFile = outputFile;

		File file = new File(this.inputFile);
		if (!file.exists())
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}

		setInputFile(inputFile);
	}

	private void setInputFile(String inputFile) {
		try {
			inp = new FileInputStream(inputFile);
			wb = WorkbookFactory.create(inp);
			sheet = wb.getSheetAt(0);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}
	}

	public void terminate() {
		if (outputFile == null)
			return;

		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(outputFile);
			wb.write(fileOut);
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String[] readColumn(String nameOfColumn) {
		String out = "";
		for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
			if (sheet.getRow(0).getCell(j).getStringCellValue()
					.equals(nameOfColumn)) {
				for (int i = 1; i < sheet.getLastRowNum(); i++)
					if ((sheet.getRow(i) != null)
							&& (sheet.getRow(i).getCell(j) != null)) {
						if (sheet.getRow(i).getCell(j).getCellType() == Cell.CELL_TYPE_STRING)
							out += sheet.getRow(i).getCell(j)
									.getStringCellValue()
									+ "@";
						else if (sheet.getRow(i).getCell(j).getCellType() == Cell.CELL_TYPE_NUMERIC)
							out += sheet.getRow(i).getCell(j)
									.getNumericCellValue()
									+ "@";
						else if (sheet.getRow(i).getCell(j).getCellType() == Cell.CELL_TYPE_BOOLEAN)
							out += Boolean.toString(sheet.getRow(i).getCell(j)
									.getBooleanCellValue())
									+ "@";
					} else
						break;
				break;
			}
		}
		return out.split("@");
	}

	public String[] readRow(int numberOfRow) {
		String out = "";
		for (int i = 0; i < sheet.getRow(numberOfRow).getLastCellNum(); i++)
			out += sheet.getRow(numberOfRow).getCell(i).getStringCellValue()
					+ "@";
		return out.split("@");
	}

	public String readCellofRow(int numberOfRow, String nameOfColumn) {
		for (int j = 0; j < sheet.getRow(numberOfRow).getLastCellNum(); j++)
			if (sheet.getRow(0).getCell(j).getStringCellValue()
					.equals(nameOfColumn))
				if (sheet.getRow(numberOfRow).getCell(j).getCellType() == Cell.CELL_TYPE_STRING)
					return sheet.getRow(numberOfRow).getCell(j)
							.getStringCellValue();
				else if (sheet.getRow(numberOfRow).getCell(j).getCellType() == Cell.CELL_TYPE_NUMERIC)
					return sheet.getRow(numberOfRow).getCell(j)
							.getNumericCellValue()
							+ "";
				else if (sheet.getRow(numberOfRow).getCell(j).getCellType() == Cell.CELL_TYPE_BOOLEAN)
					return Boolean.toString(sheet.getRow(numberOfRow)
							.getCell(j).getBooleanCellValue());
		return "";
	}

	public String readStringCellofRow(int numberOfRow, String nameOfColumn) {
		for (int j = 0; j < sheet.getRow(numberOfRow).getLastCellNum(); j++)
			if (sheet.getRow(0).getCell(j).getStringCellValue()
					.equals(nameOfColumn))
				return sheet.getRow(numberOfRow).getCell(j)
						.getStringCellValue();
		return "";
	}

	public double readDoubleCellofRow(int numberOfRow, String nameOfColumn) {
		for (int j = 0; j < sheet.getRow(numberOfRow).getLastCellNum(); j++)
			if (sheet.getRow(0).getCell(j).getStringCellValue()
					.equals(nameOfColumn))
				return sheet.getRow(numberOfRow).getCell(j)
						.getNumericCellValue();
		return Double.NaN;
	}

	public Date readDateCellofRow(int numberOfRow, String nameOfColumn) {
		for (int j = 0; j < sheet.getRow(numberOfRow).getLastCellNum(); j++)
			if (sheet.getRow(0).getCell(j).getStringCellValue()
					.equals(nameOfColumn))
				return sheet.getRow(numberOfRow).getCell(j).getDateCellValue();
		return null;
	}

	public Boolean readBooleanCellofRow(int numberOfRow, String nameOfColumn) {
		for (int j = 0; j < sheet.getRow(numberOfRow).getLastCellNum(); j++)
			if (sheet.getRow(0).getCell(j).getStringCellValue()
					.equals(nameOfColumn))
				return sheet.getRow(numberOfRow).getCell(j)
						.getBooleanCellValue();
		return null;
	}

	public void writeCellOfRow(int numberOfRow, String nameOfColumn,
			String value) {
		for (int j = 0; j < sheet.getRow(numberOfRow).getLastCellNum(); j++) {
			if (sheet.getRow(0).getCell(j).getStringCellValue()
					.equals(nameOfColumn)) {
				if (sheet.getRow(numberOfRow) == null)
					sheet.createRow(numberOfRow);
				sheet.getRow(numberOfRow).createCell(j);
				sheet.getRow(numberOfRow).getCell(j).setCellValue(value);
			}
		}
	}

	public void writeCellOfRow(int numberOfRow, String nameOfColumn,
			double value) {
		for (int j = 0; j < sheet.getRow(numberOfRow).getLastCellNum(); j++) {
			if (sheet.getRow(0).getCell(j).getStringCellValue()
					.equals(nameOfColumn)) {
				if (sheet.getRow(numberOfRow) == null)
					sheet.createRow(numberOfRow);
				sheet.getRow(numberOfRow).createCell(j);
				sheet.getRow(numberOfRow).getCell(j).setCellValue(value);
			}
		}
	}

	public void writeCellOfRow(int numberOfRow, String nameOfColumn, Date value) {
		for (int j = 0; j < sheet.getRow(numberOfRow).getLastCellNum(); j++) {
			if (sheet.getRow(0).getCell(j).getStringCellValue()
					.equals(nameOfColumn)) {
				if (sheet.getRow(numberOfRow) == null)
					sheet.createRow(numberOfRow);
				sheet.getRow(numberOfRow).createCell(j);
				sheet.getRow(numberOfRow).getCell(j).setCellValue(value);
			}
		}
	}

	public void writeCellOfRow(int numberOfRow, String nameOfColumn,
			boolean value) {
		for (int j = 0; j < sheet.getRow(numberOfRow).getLastCellNum(); j++) {
			if (sheet.getRow(0).getCell(j).getStringCellValue()
					.equals(nameOfColumn)) {
				if (sheet.getRow(numberOfRow) == null)
					sheet.createRow(numberOfRow);
				sheet.getRow(numberOfRow).createCell(j);
				sheet.getRow(numberOfRow).getCell(j).setCellValue(value);
			}
		}
	}

	public int getNumberOfEntries() {
		return sheet.getLastRowNum();
	}

}
