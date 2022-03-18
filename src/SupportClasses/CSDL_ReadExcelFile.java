package SupportClasses;

import java.io.*;
import java.util.*;

import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// lop interface de xuat du lieu ???
// hay lop abstract de chua ca cach thuc thi
public class CSDL_ReadExcelFile {
	protected String URLOfFile;
	protected FileInputStream inputStream;
	protected XSSFWorkbook workbook;
	protected XSSFSheet sheet;

	public CSDL_ReadExcelFile(String uRLOfFile, int sheetIndex) throws IOException {
		URLOfFile = uRLOfFile;
		this.inputStream = new FileInputStream(URLOfFile);
		this.workbook = new XSSFWorkbook(inputStream);
		this.sheet = workbook.getSheetAt(sheetIndex);
	}

	public String readFile() {
		Iterator<Row> rowIterator = sheet.iterator();
		String result = "";
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();

			Iterator<Cell> cellIterator = row.cellIterator();

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();

				CellType cellType = cell.getCellType();

				switch (cellType) {

				case _NONE:
					result += "     \t\t";
					break;

				case BOOLEAN:
					result += cell.getBooleanCellValue() + "\t\t";
					break;

				case BLANK:
					result += "     \t\t";
					break;

				// Chu y phan cong thuc
				case FORMULA:
					result += cell.getStringCellValue() + "\t\t";
					break;

				case NUMERIC:
					result += cell.getNumericCellValue() + "\t\t";
					break;

				case STRING:
					result += cell.getStringCellValue() + "\t\t";
					break;

				case ERROR:
					result += "! ! ! ! !\\t\\t";
					break;
				}
			}
			result += "\n";
		}
		return result;
	}

	public String[] readOneColumn(int columnIndex) {
		int numOfRow = sheet.getPhysicalNumberOfRows();
		String[] data = new String[numOfRow];

		for (int i = 0; i < numOfRow; i++) {

			Cell cell = sheet.getRow(i).getCell(columnIndex);

			CellType cellType = cell.getCellType();

			switch (cellType) {

			case _NONE:
				data[i]="none!";
				break;

			case BOOLEAN:
				data[i] =cell.getBooleanCellValue()+"";
				break;

			case BLANK:
				data[i]= " ";
				break;

			// Chu y phan cong thuc
			case FORMULA:
				data[i] = cell.getStringCellValue() + "";
				break;

			case NUMERIC:
				data [i]= cell.getNumericCellValue() + "";
				break;

			case STRING:
				data [i]= cell.getStringCellValue() + "";
				break;

			case ERROR:
				data [i]= "error!";
				break;
			}
		}
		return data;
	}
	
	public void printColumn(int columnIndex) {
		String [] data = readOneColumn(columnIndex);
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}
	
	static void main(String[] args) throws IOException {
		// doc thu file cua nhan vien

		CSDL_ReadExcelFile w1 = new CSDL_ReadExcelFile("D:\\code\\subject\\Project_OOP\\FileExcel\\Cus+Staff.xlsx", 1);
		System.out.println(w1.readFile());
		w1.printColumn(2);
	}
}
