package project;

import java.util.Random;

public enum Jobs {
    RETAILER("продавец", 90, 1),
    WAITER("официант", 120, 2),
    CLEANER("уборщик", 80, 1),
    ACCOUNTANT("бухгалтер", 160, 3),
    UNEMPLOYED("безработный", 0, 0);

    private static final Random RANDOM = new Random();
    private static final Jobs[] values = {RETAILER, WAITER, CLEANER, ACCOUNTANT};
    public final String job;
    public final int salary;
    public final int requiredSkill;

    Jobs(String job, int salary, int requiredSkill) {
        this.job = job;
        this.salary = salary;
        this.requiredSkill = requiredSkill;
    }

    public static Jobs randomJob() {
        return values[RANDOM.nextInt(values.length)];
    }

}
