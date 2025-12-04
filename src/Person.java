import java.util.ArrayList;

public abstract class Person implements Inhabitable {

    protected String name;
    protected Moods mood;
    protected int money;
    protected House house;
    protected Street street;

    public Person(String name, Moods mood, int money) {
        this.mood = mood;
        this.name = name;
        this.money = money;
    }

    public static void happening(ArrayList<Person> persons) {
        for (Person person : persons) {
            Moods previousMood = person.mood;
            person.mood = Moods.randomMood();
            if (previousMood.index < person.mood.index) {
                System.out.println("у " + person.name + " произошла удача");
            } else if (previousMood.index > person.mood.index) {
                System.out.println("у " + person.name + " произоло несчастье");
            }
        }
    }

    public static void payments(House... houses) {
        for (House house : houses) {
            for (Person person : house.people) {
                person.spendMoney(person.house.costOfRent);
            }
        }
    }

    abstract void spendMoney(int spent);

    abstract void earnMoney();

    @Override
    public void setHouse(House house) {
        this.house = house;
    }

    @Override
    public void setStreet(Street street) {
        this.street = street;
    }

    public Street getOriginStreet() {
        return this.house.street;
    }
}
