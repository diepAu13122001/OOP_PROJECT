package SupportClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

public class CSDL_Demo_CreateExcel {

// hang ngang: row
// hang doc: cell	
	public static XSSFCellStyle createStyleForTitle(XSSFWorkbook workbook) {
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		XSSFCellStyle style = workbook.createCellStyle();
		style.setFont(font);
		return style;
	}

	public static void main(String[] args) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Employee sheet");

		List<CSDL_NhanVien> list = CSDL_Demo_NhanvienDAO.listNv();

		int rownum = 0;
		Cell cell;
		Row row;

		XSSFCellStyle style = createStyleForTitle(workbook);

		row = sheet.createRow(rownum);

		// EmpNo
		cell = row.createCell(0, CellType.STRING);
		cell.setCellValue("EmpNo");
		cell.setCellStyle(style);

		// EmpName
		cell = row.createCell(1, CellType.STRING);
		cell.setCellValue("EmpName");
		cell.setCellStyle(style);

		// Salary
		cell = row.createCell(2, CellType.STRING);
		cell.setCellValue("Salary");
		cell.setCellStyle(style);

		// Grade
		cell = row.createCell(3, CellType.STRING);
		cell.setCellValue("Grade");
		cell.setCellStyle(style);

		// Bonus
		cell = row.createCell(4, CellType.STRING);
		cell.setCellValue("Bonus");
		cell.setCellStyle(style);

		// data
		for (CSDL_NhanVien nv : list) {
			rownum++;
			row = sheet.createRow(rownum);

			// EmpNo (A)
			cell = row.createCell(0, CellType.STRING);
			cell.setCellValue(nv.getEmpNo());
			// EmpName (B)
			cell = row.createCell(1, CellType.STRING);
			cell.setCellValue(nv.getEmpName());
			// Salary (C)
			cell = row.createCell(2, CellType.STRING);
			cell.setCellValue(nv.getSalary());
			// Grade (D)
			cell = row.createCell(3, CellType.STRING);
			cell.setCellValue(nv.getGrade());
			// Bonus (E)
			int temp = rownum + 1;
			String fomula = "0.1*C" + temp + "*D" + temp;
			cell = row.createCell(4, CellType.FORMULA);
			// phai de cellFormula neu k no hien kieu string T.T
			cell.setCellFormula(fomula);
		}

		File file = new File("D:\\code\\subject\\Project_OOP\\FileExcel\\Employee.xlsx");
		file.getParentFile().mkdir();

		FileOutputStream outFile = new FileOutputStream(file);
		workbook.write(outFile);
		System.out.println("Created file: " + file.getAbsolutePath());
	}
}
