package project.City;

import project.Person.Person;

public class House extends Building
        implements Structure {

    private int countOfFlats;

    public House(int countOfFlats, boolean isBeautiful, int costOfRent) {
        super(isBeautiful, costOfRent);
        this.countOfFlats = countOfFlats;
    }

    @Override
    public void BuildNewFloor(int countOfNewFlats) {
        this.countOfFlats += countOfNewFlats;
    }

    public void appendPersons(Person... persons) {
        for (Person person : persons) {
            if (this.people.size() < this.countOfFlats) {
                if (!(this.street.people.contains(person))) {
                    this.people.add(person);
                    person.setHouse(this);
                    if (person.getStreet() == null || person.getStreet() != this.street) {
                        person.setStreet(this.street);
                        this.street.people.add(person);
                    }
                }
            } else {
                break;
            }
        }
    }

    public void leave(Person person) throws NotHisHouseException {
        if (!(this.people.contains(person))) throw new NotHisHouseException(person.getName());
        this.people.remove(person);
    }

}
