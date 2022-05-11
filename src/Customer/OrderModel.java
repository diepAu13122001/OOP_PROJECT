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
        addDataForMainListFromFile();
        addDataForColdDrinkListFromFile();
        addDataForCoffeeListFromFile();
        addDataForTeaListFromFile();
        addDataForFiredFoodListFromFile();
        addDataForDessertListFromFile();
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

    public ArrayList<Food_MainDishes> addDataForMainListFromFile() throws IOException {
        this.mainDishList = new ArrayList<>();
        for (Food food : loadDataFromExcelFile()) {
            if (menu.getTypeOfFoodByClass(food).equals("Main dishes")) {
                this.mainDishList.add((Food_MainDishes) food);
            }
        }
        return this.mainDishList;
    }

    public ArrayList<Food_ColdDrinks> addDataForColdDrinkListFromFile() throws IOException {
        this.coldDrinkList = new ArrayList<>();
        for (Food food : loadDataFromExcelFile()) {
            if (menu.getTypeOfFoodByClass(food).equals("Cold drinks")) {
                this.coldDrinkList.add((Food_ColdDrinks) food);
            }
        }
        return this.coldDrinkList;
    }

    public ArrayList<Food_Coffee> addDataForCoffeeListFromFile() throws IOException {
        this.coffeeList = new ArrayList<>();
        for (Food food : loadDataFromExcelFile()) {
            if (menu.getTypeOfFoodByClass(food).equals("Coffee")) {
                this.coffeeList.add((Food_Coffee) food);
            }
        }
        return this.coffeeList;
    }

    public ArrayList<Food_Tea> addDataForTeaListFromFile() throws IOException {
        this.teaList = new ArrayList<>();
        for (Food food : loadDataFromExcelFile()) {
            if (menu.getTypeOfFoodByClass(food).equals("Tea")) {
                this.teaList.add((Food_Tea) food);
            }
        }
        return this.teaList;
    }

    public ArrayList<Food_FiredFoods> addDataForFiredFoodListFromFile() throws IOException {
        this.firedList = new ArrayList<>();
        for (Food food : loadDataFromExcelFile()) {
            if (menu.getTypeOfFoodByClass(food).equals("Fired foods")) {
                this.firedList.add((Food_FiredFoods) food);
            }
        }
        return this.firedList;
    }

    public ArrayList<Food_Desserts> addDataForDessertListFromFile() throws IOException {
        this.dessertList = new ArrayList<>();
        for (Food food : loadDataFromExcelFile()) {
            if (menu.getTypeOfFoodByClass(food).equals("Desserts")) {
                this.dessertList.add((Food_Desserts) food);
            }
        }
        return this.dessertList;
    }

    private String[] getDataFromFoodItem(Food food) {
        String[] data = new String[4];
        data[0] = this.menu.getTypeOfFoodByClass(food);
        data[1] = food.getTenMonShort();
        data[2] = food.getMinPriceInList().trim();
        data[3] = food.getImgURL().trim();
        return data;
    }

    // get name, type of food, price, imgURL
    public ArrayList<String[]> getHotDealList() {
        ArrayList<String[]> list = new ArrayList<>();

        return list;
    }

    public ArrayList<String[]> getComboList() {
        ArrayList<String[]> list = new ArrayList<>();
        for (Food_Combo combo : this.comboList) {
            list.add(getDataFromFoodItem(combo));
        }
        return list;
    }

    public ArrayList<String[]> getMainDishList() {
        ArrayList<String[]> list = new ArrayList<>();
        for (Food_MainDishes mainDish : this.mainDishList) {
            list.add(getDataFromFoodItem(mainDish));
        }
        return list;
    }

    public ArrayList<String[]> getColdDrinkList() {
        ArrayList<String[]> list = new ArrayList<>();
        for (Food_ColdDrinks coldDrink : this.coldDrinkList) {
            list.add(getDataFromFoodItem(coldDrink));
        }
        return list;
    }

    public ArrayList<String[]> getCoffeeList() {
        ArrayList<String[]> list = new ArrayList<>();
        for (Food_Coffee coffee : this.coffeeList) {
            list.add(getDataFromFoodItem(coffee));
        }
        return list;
    }

    public ArrayList<String[]> getTeaList() {
        ArrayList<String[]> list = new ArrayList<>();
        for (Food_Tea tea : this.teaList) {
            list.add(getDataFromFoodItem(tea));
        }
        return list;
    }

    public ArrayList<String[]> getFiredFoodList() {
        ArrayList<String[]> list = new ArrayList<>();
        for (Food_FiredFoods firedFood : this.firedList) {
            list.add(getDataFromFoodItem(firedFood));
        }
        return list;
    }

    public ArrayList<String[]> getDessertList() {
        ArrayList<String[]> list = new ArrayList<>();
        for (Food_Desserts dessert : this.dessertList) {
            list.add(getDataFromFoodItem(dessert));
        }
        return list;
    }

}
