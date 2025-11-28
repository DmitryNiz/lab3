import java.util.ArrayList;

public class Street extends CityObject {

    int beauty;
    String name;
    ArrayList<Building> buildings = new ArrayList<Building>();

    public Street(String name){
        this.name = name;
        this.beauty = 0;
    }

    public void addBuilding(Building... buildings){
        for (Building building : buildings) {
            this.buildings.add(building);
            this.people.addAll(building.people);
            building.setStreet(this);
            if (building.isBeautiful) {
                this.beauty++;
            }else {
                this.beauty--;
            }
        }
    }

    public void walking(Person... persons) {
        if(this.beauty > 0) {
            for (Person person : persons) {
                person.setStreet(this);
                Moods.up(person);
            }
        }else {
            for (Person person : persons) {
                person.setStreet(this);
                Moods.down(person);
            }
        }
    }

    public void getHome(Person... persons) {
        for (Person person : persons) {
            person.setStreet(person.getOriginStreet());
        }
    }
}
