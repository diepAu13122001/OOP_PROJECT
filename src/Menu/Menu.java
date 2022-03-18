package Menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Store.LoadDataFromExcelFile;

public class Menu {
	private ArrayList<Food> danhSachMonAn = new ArrayList<>();

	public ArrayList<Food> getDanhSachMonAn() {
		return danhSachMonAn;
	}

	public void setDanhSachMonAn(ArrayList<Food> danhSachMonAn) {
		this.danhSachMonAn = danhSachMonAn;
	}

	// TODO
	public void addItemInList(Food item, String maMon, String tenMon, ArrayList<String[]> giaTienVaDVT,
			ArrayList<Integer> caBan, String imgURL) {
		item.setMaMon(maMon);
		item.setTenMon(tenMon);
		item.setGiaTienVaDVT(giaTienVaDVT);
		item.setCaBan(caBan);
		item.setImgURL(imgURL);
		this.danhSachMonAn.add(item);
	}

	public void removeItemInList(String maMon) {
		for (Food Food : danhSachMonAn) {
			if (Food.getMaMon().equals(maMon)) {
				danhSachMonAn.remove(Food);
			}
		}
	}

//update by something

	public ArrayList<Food> loadExcelDataList() throws IOException {
		LoadDataFromExcelFile load = new LoadDataFromExcelFile();
		this.danhSachMonAn = load.loadFoodData("D:\\code\\subject\\Project_OOP\\FileExcel\\HoaDon.xlsx", 31, 15, 1);
		return this.danhSachMonAn;
	}

	public ArrayList<Food> getList() {
		return this.danhSachMonAn;
	}

	public List<Food> getTypeList() {
		List<Food> list = new ArrayList<>();
		list.add(new Food_MainDishes());
		list.add(new Food_FiredFoods());
		list.add(new Food_Desserts());
		list.add(new Food_ColdDrinks());
		list.add(new Food_Tea());
		list.add(new Food_Combo());
		list.add(new Food_Coffee());
		return list;
	}

	public Food getTypeOfFood(int id) {
		return getTypeList().get(id - 1);
	}

	public String getTypeOfFoodByClass(Food food) {
		if (food instanceof Food_Combo) {
			return "Combo";
		}
		if (food instanceof Food_MainDishes) {
			return "Main dishes";
		}
		if (food instanceof Food_FiredFoods) {
			return "Fired foods";
		}
		if (food instanceof Food_Desserts) {
			return "Desserts";
		}
		if (food instanceof Food_ColdDrinks) {
			return "Cold drinks";
		}
		if (food instanceof Food_Tea) {
			return "Tea";
		}
		if (food instanceof Food_Coffee) {
			return "Coffee";
		} else
			return "null";
	}

	// set hot deal if this food has more 100 purchases in months
}
