package pl.pjait;

import java.time.LocalDate;
import java.util.Comparator;
public class Cars implements Comparable<Cars>  {
    private int price;
    private String keyword;
    private int yearOfProduction;
    private int vehiMileage;
    private String dateOfPublication;

    public Cars(int price, String keyword, int yearOfProduction, int vehiMileage, String dateOfPublication){
        this.price = price;
        this.keyword = keyword;
        this.yearOfProduction = yearOfProduction;
        this.vehiMileage = vehiMileage;
        this.dateOfPublication = dateOfPublication;
    }

    public String getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(String dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public int getVehiMileage() {
        return vehiMileage;
    }

    public void setVehiMileage(int vehiMileage) {
        this.vehiMileage = vehiMileage;
    }

    @Override
    public int compareTo(Cars o) {
        return keyword.compareTo(o.keyword);
    }

    @Override public String toString(){
        return "Price: "+price+ " | Keyword: "+keyword+" | Year of Production: "
                +yearOfProduction+" | Vehicle Mileage: "+vehiMileage+ " | Year of offer publication " + dateOfPublication;
    }

}
