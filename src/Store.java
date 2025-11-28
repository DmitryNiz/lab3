import java.util.ArrayList;

public class Store extends Building{

    private Employer renter;

    public Store(boolean isBeautiful, int costOfRent) {
        super(isBeautiful, costOfRent);
        this.people = new ArrayList<>();
    }

    public void setRenter(Employer employer) throws AlreadyRented{
        if (renter != null) throw new AlreadyRented(renter.getBuisnes());
        this.renter = employer;
        employer.startToRent(this);
        this.people.add(employer);
        this.people.addAll(employer.getWorkers());
    }

    protected void setNullRenter() {
        this.renter = null;
    }
}
