import java.util.ArrayList;

public class Building extends CityObject{

    boolean isBeautiful;
    int costOfRent;
    Street street;

    public Building(boolean isBeautiful, int costOfRent){
        this.isBeautiful = isBeautiful;
        this.costOfRent = costOfRent;
    }

    public void setStreet(Street street) {
        this.street = street;
    }
}
