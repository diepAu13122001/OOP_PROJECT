package Customer;

import java.io.IOException;
import java.util.ArrayList;

import Menu.*;
import Store.LoadDataFromExcelFile;

public class OrderModel {
	private Menu menu;
	private LoadDataFromExcelFile load;
	private ArrayList<Food_Combo> comboList;
	private ArrayList<Food_Coffee> coffeeList;
	private ArrayList<Food_Tea> teaList;
	private ArrayList<Food_MainDishes> mainDishList;
	private ArrayList<Food_FiredFoods> firedList;
	private ArrayList<Food_Desserts> dessertList;
	private ArrayList<Food_ColdDrinks> coldDrinkList;

	public OrderModel() throws IOException {
		this.menu = new Menu();
		this.load = new LoadDataFromExcelFile();
		addDataForComboListFromFile();
	}

	private ArrayList<Food> loadDataFromExcelFile() throws IOException {
		return this.load.loadFoodData("D:\\code\\subject\\Project_OOP\\FileExcel\\HoaDon.xlsx", 37, 18, 2);
	}

	public ArrayList<Food_Combo> addDataForComboListFromFile() throws IOException {
		this.comboList = new ArrayList<>();
		for (Food food : loadDataFromExcelFile()) {
			if (menu.getTypeOfFoodByClass(food).equals("Combo")) {
				this.comboList.add((Food_Combo) food);
			}
		}
		return this.comboList;
	}

	// get name, type of food, price, imgURL
	public ArrayList<String[]> getComboList() {
		ArrayList<String[]> list = new ArrayList<>();
		for (Food_Combo combo : this.comboList) {
			String[] data = new String[4];
			data[0] = this.menu.getTypeOfFoodByClass(combo);
			data[1] = combo.getTenMon();
			data[2] = combo.getMinPriceInList().trim();
			data[3] = combo.getImgURL().trim();
			list.add(data);
		}
		return list;
	}

}
