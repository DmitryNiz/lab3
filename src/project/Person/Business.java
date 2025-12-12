package project.Person;

import project.*;
import project.City.*;

public class Business {
    private int sizeOfCompany;
    private String name;
    private Employer owner;

    public Business(int sizeOfCompany, String name, Employer owner) {
        this.name = name;
        this.sizeOfCompany = sizeOfCompany;
        this.owner = owner;
        this.owner.setBUSINESS(this);
    }

    public int businessProfit() {
        int res = 0;
        for (Employee employee : this.owner.getWorkers()) {
            res += (int) employee.generateProfit();
            res -= employee.getWork().salary;
            employee.earnMoney();
        }

        for (Store store : this.owner.getStores()) {
            res -= store.getCostOfRent();
        }
        System.out.println("В этот день бизнес " + this.name + " заработал " + res + " DB");
        return res;

    }

    public String getName() {
        return name;
    }

    public int getSizeOfCompany() {
        return sizeOfCompany;
    }
}
