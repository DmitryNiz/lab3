package project.City;

public class Building extends CityStructure {

    protected boolean isBeautiful;
    protected int costOfRent;
    protected Street street;

    public Building(boolean isBeautiful, int costOfRent) {
        this.isBeautiful = isBeautiful;
        this.costOfRent = costOfRent;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    @Override
    public void renovate() {
        this.isBeautiful = true;
    }

    public Street getStreet() {
        return street;
    }

    public int getCostOfRent() {
        return costOfRent;
    }
}
