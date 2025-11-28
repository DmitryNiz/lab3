public class AlreadyRented extends RuntimeException {
    public AlreadyRented(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " уже снимает это здание";
    }
}
