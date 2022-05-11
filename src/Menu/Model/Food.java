package Menu.Model;

import java.util.ArrayList;

import Personel.*;
import SupportClasses.MyCurency;

public abstract class Food {

    protected String maMon;
    protected String tenMon;
    protected ArrayList<PriceByUnit> giaTienVaDVT;
    protected ArrayList<Shift> caBan;
    protected String imgURL;

    public Food(String maMon, String tenMon, ArrayList<String[]> giaTienVaDVT, ArrayList<Integer> caBan,
                String imgURL) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.giaTienVaDVT = new ArrayList<>();
        setGiaTienVaDVT(giaTienVaDVT);
        this.caBan = new ArrayList<>();
        setCaBan(caBan);
        this.imgURL = imgURL;
    }

    public Food() {
        this.giaTienVaDVT = new ArrayList<>();
        this.caBan = new ArrayList<>();
    }

    public String getMaMon() {
        return maMon;
    }

    public abstract void setMaMonByIndex(int indexOfFood);

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public String getTenMonShort() {
        if (tenMon.length() > 20) {
            return tenMon.substring(0, 20) + "..." ;
        } else return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public ArrayList<PriceByUnit> getGiaTienVaDVT() {
        return giaTienVaDVT;
    }

    public void setGiaTienVaDVT(ArrayList<String[]> data) {
        for (String[] strings : data) {
            if (!strings[0].equals("BLANK")) {
                PriceByUnit giaTheoDVT = new PriceByUnit(strings[0], strings[1]);
                this.giaTienVaDVT.add(giaTheoDVT);
            }
        }
    }

    public ArrayList<Shift> getCaBan() {
        return caBan;
    }

    public void setCaBan(ArrayList<Integer> idList) {
        for (Integer id : idList) {
            for (Shift shift : Shift.getShiftList()) {
                if (shift.getId() == id) {
                    this.caBan.add(shift.getInfo());
                }
            }
        }
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getMinPriceInList() {
        ArrayList<Integer> amounts = new ArrayList<>();
        for (PriceByUnit priceByUnit : this.giaTienVaDVT) {
            amounts.add((int) Double.parseDouble(priceByUnit.getGia()));
        }
        int min = amounts.get(0);
        for (int i = 1; i < amounts.size(); i++) {
            if (min > amounts.get(i)) {
                min = amounts.get(i);
            }
        }
        return new MyCurency(min).getResult();
    }

}