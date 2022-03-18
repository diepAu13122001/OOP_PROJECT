package SupportClasses;

import java.io.*;
import java.util.*;

import org.apache.poi.ss.format.CellFormatType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CSDL_Demo_ReadExcel {

	public static void main(String[] args) throws IOException {

		FileInputStream inputStream = new FileInputStream("D:\\code\\subject\\Project_OOP\\FileExcel\\Employee.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

		XSSFSheet sheet = workbook.getSheetAt(0);

		Iterator<Row> rowIterator = sheet.iterator();

		ArrayList<String> tmpList = new ArrayList<String>();

		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			System.out.println(row.toString());

			Iterator<Cell> cellIterator = row.cellIterator();

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				System.out.println(cell.toString());
				if (cell == null || cell.getCellType() == CellType.BLANK || (cell.getCellType() == CellType.STRING && cell.getStringCellValue().trim().isEmpty())) {
					
					tmpList.add("null");
				} else {
					CellType cellType = cell.getCellType();
					switch (cellType) {
					case _NONE:
						tmpList.add("NONE");
						break;

					case BOOLEAN:
						tmpList.add(cell.getBooleanCellValue() + "");
						break;

					case BLANK:
						tmpList.add("  ");
						break;

					// Chu y phan cong thuc
					case FORMULA:
//					System.out.print(cell.getCellFormula());
						FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
						tmpList.add(evaluator.evaluate(cell).getNumberValue() + "");
						break;
					case NUMERIC:
						tmpList.add(cell.getNumericCellValue() + "");
						break;

					case STRING:
						tmpList.add(cell.getStringCellValue());
						break;

					case ERROR:
						tmpList.add("ERROR");
						break;
					}
				}
			}
		}
		System.out.println(tmpList);
//		CSDL_Demo_NhanvienDAO dao = new CSDL_Demo_NhanvienDAO();
//		for (int i = 5; i < tmpList.size(); i++) {
//			if (i % 5 == 0 && i + 4 < tmpList.size()) {
//				dao.addToList(tmpList.get(i), tmpList.get(i + 1), Double.parseDouble(tmpList.get(i + 2)),
//						(int) Double.parseDouble(tmpList.get(i + 3)), Double.parseDouble(tmpList.get(i + 4)));
//			}
//		}
//		System.out.println(dao.getList().toString());
	}
}
