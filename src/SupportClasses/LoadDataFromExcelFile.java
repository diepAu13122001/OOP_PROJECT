package SupportClasses;

import java.io.*;
import java.util.*;

import Menu.Model.Food;
import Menu.Model.Menu;
import Store.DiscountCode;
import Store.DiscountCode_Dao;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;

public class LoadDataFromExcelFile {
	// string has two type: "x" or "BLANK"
	public ArrayList<Integer> convertStringToIntList(ArrayList<String> list) {
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			String string = list.get(i);
			if (string.equals("x")) {
				result.add((i + 1));
			}
		}
		return result;
	}

	private ArrayList<String> getDataFromExcel(String excelFileURL, int sheetIndex, int numOfCol) throws IOException {
		FileInputStream inputStream = new FileInputStream(excelFileURL);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheetAt(sheetIndex - 1);

		ArrayList<String> results = new ArrayList<String>();

		for (int i = 0; i < sheet.getLastRowNum() + 1; i++) {
			XSSFRow row = ((XSSFRow) sheet.getRow(i));
			if (row != null) {
				for (int j = 0; j < numOfCol; j++) {
					Cell cell = row.getCell(j);
					if (row != null && cell != null) {
						CellType cellType = row.getCell(j).getCellType();
						if (cellType == CellType.BLANK) {
							results.add("BLANK");
						}
						if (cellType == CellType._NONE) {
							results.add("BLANK");
						}
						if (cellType == CellType.BOOLEAN) {
							results.add(cell.getBooleanCellValue() + "");
						}
						if (cellType == CellType.FORMULA) {
							FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
							results.add(evaluator.evaluate(cell).getNumberValue() + "");
						}

						if (cellType == CellType.NUMERIC) {
							if (HSSFDateUtil.isCellDateFormatted(cell)) {
								if (cell.getDateCellValue().getYear() == (1899 - 1900)) {
									results.add(cell.getDateCellValue().getHours() + ":"
											+ cell.getDateCellValue().getMinutes() + ":"
											+ cell.getDateCellValue().getSeconds());
								} else {
									results.add(
											cell.getDateCellValue().getDate() + "/" + cell.getDateCellValue().getMonth()
													+ 1 + "/" + (cell.getDateCellValue().getYear() + 1900));
								}
							} else
								results.add(cell.getNumericCellValue() + "");
						}
						if (cellType == CellType.STRING) {
							results.add(cell.getStringCellValue());
						}
					} else {
						results.add("BLANK");
					}
				}
			}
		}
		workbook.close();
		return results;
	}

	public ArrayList<Food> loadFoodData(String excelFileURL, int cellIndexHasData, int numOfCol, int sheetIndex)
			throws IOException {
		ArrayList<String> tmpList = getDataFromExcel(excelFileURL, sheetIndex, numOfCol);
		Menu menu = new Menu();
		for (int i = cellIndexHasData - 1; i < tmpList.size(); i++) {
			if (i % numOfCol == 0 && i + (numOfCol - 1) < tmpList.size()) {
				Food food = null;
				ArrayList<String> loaiThucAnStringData = new ArrayList<>();
				for (int j = 1; j < 8; j++) {
					loaiThucAnStringData.add(tmpList.get(i + j));
				}

				String maMon = tmpList.get(i);
				String tenMon = tmpList.get(i + 8);
				ArrayList<String[]> giaTienVaDVT = new ArrayList<>();
				giaTienVaDVT.add(new String[] { tmpList.get(i + 9), tmpList.get(i + 10) });
				giaTienVaDVT.add(new String[] { tmpList.get(i + 11), tmpList.get(i + 12) });
				ArrayList<String> caBanStringData = new ArrayList<>();
				for (int j = 13; j < 16; j++) {
					caBanStringData.add(tmpList.get(i + j));
				}
				ArrayList<Integer> caBan = convertStringToIntList(caBanStringData);
				String imgURL = tmpList.get(i + 17);
				food = menu.getTypeOfFood(convertStringToIntList(loaiThucAnStringData).get(0));
				menu.addItemInList(food, maMon, tenMon, giaTienVaDVT, caBan, imgURL);
			}
		}
		return menu.getDanhSachMonAn();
	}

	public ArrayList<DiscountCode> loadDiscountData(String excelFileURL, int cellIndexHasData, int numOfCol,
													int sheetIndex) throws IOException {
		ArrayList<String> tmpList = getDataFromExcel(excelFileURL, sheetIndex, numOfCol);
		DiscountCode_Dao dao = new DiscountCode_Dao();
		for (int i = cellIndexHasData; i < tmpList.size(); i++) {
			if (i % numOfCol == 0 && i + (numOfCol - 1) < tmpList.size()) {
				String maKhuyenMai = tmpList.get(i);
				ArrayList<String> ptttDuocApDungMa = new ArrayList<>();
				for (int j = 1; j < 7; j++) {
					ptttDuocApDungMa.add(tmpList.get(i + j));
				}
				String gioVangBatDau = tmpList.get(i + 7);
				String ngayBatDau = tmpList.get(i + 8);
				String gioVangKetThuc = tmpList.get(i + 9);
				String ngayKetThuc = tmpList.get(i + 10);
				double giaTriPhanTram = Double.parseDouble(tmpList.get(i + 11));
				int giaTriThanhTien = (int) Double.parseDouble(tmpList.get(i + 12));
				int hoaDonToiThieu = (int) Double.parseDouble(tmpList.get(i + 13));
				int giamToiDa = (int) Double.parseDouble(tmpList.get(i + 14));
				dao.addItemInList(maKhuyenMai, ptttDuocApDungMa, gioVangBatDau, ngayBatDau, gioVangKetThuc, ngayKetThuc,
						giaTriPhanTram, giaTriThanhTien, hoaDonToiThieu, giamToiDa);
			}
		}
		return dao.getList();
	}

	// ma khuyen mai chỉ có 1 :)))

	public static void main(String[] args) throws IOException {
		LoadDataFromExcelFile load = new LoadDataFromExcelFile();
//		System.out.println(load.getDataFromExcel("D:\\code\\subject\\Project_OOP\\FileExcel\\HoaDon.xlsx", 2));
		System.out.println(load.loadFoodData("D:\\code\\subject\\Project_OOP\\FileExcel\\HoaDon.xlsx", 37, 18, 2).get(0)
				.getImgURL());
	}
}
