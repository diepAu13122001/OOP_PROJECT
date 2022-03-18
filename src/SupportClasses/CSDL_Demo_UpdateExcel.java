package SupportClasses;

import java.io.*;
import java.util.*;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CSDL_Demo_UpdateExcel {
	public static void main(String[] args) throws IOException {

		File file = new File("D:\\code\\subject\\Project_OOP\\FileExcel\\Employee.xlsx");
		FileInputStream inputStream = new FileInputStream(file);

		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

		XSSFSheet sheet = workbook.getSheetAt(0);

		XSSFCell cell = sheet.getRow(1).getCell(2);
		cell.setCellValue(cell.getNumericCellValue() * 2);

		cell = sheet.getRow(2).getCell(2);
		cell.setCellValue(cell.getNumericCellValue() * 2);

		cell = sheet.getRow(3).getCell(2);
		cell.setCellValue(cell.getNumericCellValue() * 2);

		inputStream.close();

		// Ghi file
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
		out.close();
	}
}