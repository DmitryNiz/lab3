import java.util.ArrayList;

public abstract class Person {

    String name;
    Moods mood;
    int money;
    House house;
    Street street;

    public Person(String name, Moods mood, int money){
        this.mood = mood;
        this.name = name;
        this.money = money;
    }

    abstract void spendMoney(int spent);

    abstract void earnMoney();

    public static void happening(ArrayList<Person> persons){
        for(Person person : persons){
            Moods previousMood = person.mood;
            person.mood = Moods.randomMood();
            if (previousMood.index < person.mood.index) {
                System.out.println("у " + person.name + " произошла удача");
            }else if (previousMood.index > person.mood.index) {
                System.out.println("у " + person.name + " произоло несчастье");
            }
        }
    }

    public static void payments(House... houses) {
        for (House house : houses){
            for (Person person : house.people) {
                person.spendMoney(person.house.costOfRent);
            }
        }
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public Street getOriginStreet() {
        return this.house.street;
    }
}
