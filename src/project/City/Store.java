package project.City;

import project.Person.Employer;

public class Store extends Building {

    private Employer renter;

    public Store(boolean isBeautiful, int costOfRent) {
        super(isBeautiful, costOfRent);
    }

    public void setRenter(Employer employer) throws AlreadyRented {
        if (renter != null) throw new AlreadyRented(renter.getBuisnes().getName());
        if (employer != null && !employer.getStores().contains(this)) {
            this.renter = employer;
            employer.startToRent(this);
        }
    }

    public void changeRenter(Employer renter) {
        this.renter.getStores().remove(this);
        this.renter = renter;
    }

    public int getCostOfRent() {
        return this.costOfRent;
    }

    protected void setNullRenter() {
        this.renter = null;
    }
}
