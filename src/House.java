import java.util.ArrayList;

public class House extends Building
implements Structure{

    private int countOfFlats;

    public House(int countOfFlats, boolean isBeautiful, int costOfRent){
        super(isBeautiful, costOfRent);
        this.countOfFlats = countOfFlats;
    }

    @Override
    public void BuildNewFloor() {
        this.countOfFlats += 5;
    }

    public void appendPersons(Person... persons){
        for (Person person : persons) {
            if (this.people.size() < this.countOfFlats) {
                if (!(this.street.people.contains(person))) {
                    this.people.add(person);
                    person.setHouse(this);
                    if (person.street == null || person.street != this.street) {
                        person.setStreet(this.street);
                        this.street.people.add(person);
                    }
                }
            } else {
                break;
            }
        }
    }

    public void leave(Person person) throws NotHisHouse{
        if (!(this.people.contains(person))) throw new NotHisHouse(person.name);
        this.people.remove(person);
    }
}
