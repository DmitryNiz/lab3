public class Building extends CityObject {

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
        isBeautiful = true;
    }
}
