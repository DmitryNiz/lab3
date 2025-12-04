import java.util.ArrayList;
import java.util.Objects;

import static java.lang.Math.random;

public class Employer extends Person {
    private Business BUSINESS;
    private final ArrayList<Employee> workers = new ArrayList<Employee>();
    private Store store;

    public Employer(String name, Moods mood, int money) {
        super(name, mood, money);
    }

    public static void benefits(Employer... employers) {
        for (Employer employer : employers) {
            employer.earnMoney();
        }
    }

    protected void setBUSINESS(Business BUSINESS) {
        this.BUSINESS = BUSINESS;
    }

    protected void startToRent(Store store) {
        if (this.store != null) {
            this.store.setNullRenter();
            this.store = store;
        } else {
            this.store = store;
        }
    }

    protected void setStore(Store store) {
        this.store = store;
    }

    public ArrayList<Employee> getWorkers() {
        return this.workers;
    }

    public Business getBuisnes() {
        return this.BUSINESS;
    }

    public Store getStore() {
        return this.store;
    }

    @Override
    public void spendMoney(int spent) {
        this.money -= spent;
    }

    @Override
    protected void earnMoney() {
        this.money += this.getBuisnes().businessProfit();
    }

    private void earnMoney(int income) {
        this.money += income;
    }

    public void sellBusiness(Employer owner, int value) {
        this.earnMoney(value);
        owner.spendMoney(value);
        owner.setBUSINESS(this.BUSINESS);
        this.setBUSINESS(null);
    }

    @Override
    public boolean equals(Object o1) {
        if (this == o1) return true;
        if (o1 == null || this.getClass() != o1.getClass()) return false;
        Employer other = (Employer) o1;
        return Objects.equals(this.BUSINESS, other.BUSINESS)
                && Objects.equals(this.mood, other.mood) && Objects.equals(this.workers, other.workers)
                && Objects.equals(this.name, other.name) && this.money == other.money && this.store == other.store;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, workers, money, mood, store, BUSINESS);
    }

    @Override
    public String toString() {
        return "Employer{name=" + name + ", BUISNES=" + BUSINESS + ", money=" + money + ", workers=" + workers + ", store=" + store + ", mood=" + mood + "}";
    }

    public void chanceOfEmploy(Employee... employees) throws AlreadyRented {
        for (Employee employee : employees) {
            if ((this.workers.contains(employee))) {
                System.out.println(employee.name + " уже работает на " + this.name);
                continue;
            }
            int lowerLimit = 0;
            Jobs job = Jobs.randomJob();
            if (this.workers.size() < this.BUSINESS.getSizeOfCompany()) {

                if (this.mood.index > 2) {
                    lowerLimit += 15;
                } else if (this.mood.index < 2) {
                    lowerLimit -= 10;
                }

                if (employee.getSkill() < job.requiredSkill) {
                    lowerLimit -= 100;
                } else {
                    lowerLimit += 50;
                }

                if ((random() * lowerLimit) + 100 > 70) {
                    this.workers.add(employee);
                    System.out.println(employee.name + " устроился работать на работу " + job.job + " на предпринимателя " + this.name);
                    employee.setJob(job);
                } else {
                    System.out.println(employee.name + " не удалось устроится на работу");
                }
            } else {
                break;
            }
        }
    }

    public void fireEmployee(Employee... employees) {
        for (Employee employee : employees) {
            if (!this.workers.contains(employee)) {
                System.out.println(employee.name + " уже не работает на " + this.name);
                continue;
            }
            this.workers.remove(employee);
            employee.setJob(Jobs.UNEMPLOYED);
        }
    }

}
