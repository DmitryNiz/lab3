package project;

import project.Person.Person;

import java.util.Random;

public enum Moods {
    ANGRY("злой", 0),
    SAD("грустный", 1),
    ANNOYED("раздраженный", 2),
    NORMAL("", 3),
    JOY("веселый", 4);

    private static final Random RANDOM = new Random();
    private static final Moods[] VALUES = values();
    public final String mood;
    public final int index;

    Moods(String mood, int index) {
        this.mood = mood;
        this.index = index;
    }

    public static Moods randomMood() {
        return VALUES[RANDOM.nextInt(VALUES.length)];
    }

    public static void up(Person person) {
        if (person.getMood().index < 4) {
            person.setMood(VALUES[person.getMood().index + 1]);
            System.out.println(person.getName() + " повеселел");
        }
    }

    public static void down(Person person) {
        if (person.getMood().index > 0) {
            person.setMood(VALUES[person.getMood().index - 1]);
            System.out.println(person.getMood() + " погрустнел");
        }
    }
}
