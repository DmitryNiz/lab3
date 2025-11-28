public class NotHisHouse extends Exception {
    public NotHisHouse(String name) {
        super(name);
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " здесь не живет";
    }
}
