package project.City;

public class NotHisHouseException extends Exception {
    public NotHisHouseException(String name) {
        super(name);
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " здесь не живет";
    }
}
