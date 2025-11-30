import java.util.*;
import static java.lang.Math.*;

public class Employer extends Person{
    private final String BUISNES;
    private ArrayList<Employee> workers;
    private int sizeOfCompany;
    private Store store;

    public Employer(String name, Moods mood, int money, String buisnes, int sizeOfCompany){
        super(name, mood, money);
        this.BUISNES = buisnes;
        this.sizeOfCompany = sizeOfCompany;
        this.workers = new ArrayList<Employee>();
    }

    public void startToRent(Store store) {
        if (this.store != null) {
            this.store.setNullRenter();
            this.store = store;
        } else {
            this.store = store;
        }
    }

    public ArrayList<Employee> getWorkers() {
        return this.workers;
    }

    public String getBuisnes(){
        return this.BUISNES;
    }

    @Override
    void spendMoney(int spent) {
        this.money -= spent;
    }

    public int buisnesProfit() {
        int res = 0;
        for (Employee employee : this.getWorkers()) {
            res += (int) employee.ganerateProfit();
            res -= employee.getWork().salary;
            employee.earnMoney();
        }
        if (this.store != null) {
            res -= store.costOfRent;
            System.out.println("В этот день бизнес " + this.BUISNES + " заработал " + res + " DB");
            return res;
        }else {
            System.out.println("В этот день бизнес " + this.BUISNES + " заработал " + res + " DB");
            return res;
        }
    }

    @Override
    void earnMoney() {
        this.money += buisnesProfit();
    }

    @Override
    public boolean equals(Object o1) {
        if (this == o1) return true;
        if (o1 == null || this.getClass() != o1.getClass()) return false;
        Employer other = (Employer) o1;
        return Objects.equals(this.BUISNES, other.BUISNES) && (this.sizeOfCompany == other.sizeOfCompany)
                && Objects.equals(this.mood, other.mood) && Objects.equals(this.workers, other.workers)
                && Objects.equals(this.name, other.name) && this.money == other.money && this.store == other.store;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, workers, money, mood, store, sizeOfCompany, BUISNES);
    }

    @Override
    public String toString() {
        return "Employer{name=" + name + ", BUISNES=" + BUISNES + ", money=" + money + ", workers=" + workers + ", store=" + store + ", sizeOfCompany=" + sizeOfCompany + ", mood=" + mood + "}";
    }

    public void chanceOfEmploy(Employee... employees) throws AlreadyRented {
        for (Employee employee : employees) {
            if ((this.workers.contains(employee))) {
                System.out.println( employee.name + " уже работает на " + this.name);
                continue;
            }
            int lowerLimit = 0;
            Jobs job = Jobs.randomJob();
            if (this.workers.size() < this.sizeOfCompany) {

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

    public void fireEmployee(Employee... employees){
        for (Employee employee : employees) {
            if (!this.workers.contains(employee)) {
                System.out.println( employee.name + " уже не работает на " + this.name);
                continue;
            }
            this.workers.remove(employee);
            employee.setJob(Jobs.UNEMPLOYED);
        }
    }

    public static void benefits(Employer... employers) {
        for(Employer employer : employers) {
            employer.earnMoney();
        }
    }

}
