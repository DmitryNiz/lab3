package project.City;

import project.Person.Person;

import java.util.ArrayList;

public abstract class CityObject {

    protected ArrayList<Person> people = new ArrayList<>();

    abstract void renovate();

    public ArrayList<Person> getPeople() {
        return people;
    }
}
