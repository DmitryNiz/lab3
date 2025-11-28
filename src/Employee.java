public class Employee extends Person{

    private Jobs work;
    private double skill;

    public Employee(String name, Moods mood, int money, double skill){
        super(name, mood, money);
        this.work = Jobs.UNEMPLOYED;
        this.skill = skill;
    }

    @Override
    void spendMoney(int spent) {
        this.money -= spent;
    }

    @Override
    void earnMoney() {
        this.money += work.salary;
    }

    protected double ganerateProfit(){
        this.skill += 0.01;
        try {
            if (this.skill >= this.work.requiredSkill) {
                return (this.work.requiredSkill + (this.skill - this.work.requiredSkill) * 0.1 / this.skill) * 100;
            } else {
                return (this.work.requiredSkill + (this.skill - this.work.requiredSkill) * 0.1) * 100;
            }
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }finally {
            return (this.work.requiredSkill + (this.skill - this.work.requiredSkill) * 0.1 / 2) * 100;
        }
    }

     protected void setJob (Jobs job) {
        this.work = job;
        if(job != Jobs.UNEMPLOYED) {
            Moods.up(this);
        }else {
            Moods.down(this);
        }
    }

    public double getSkill(){
        return skill;
    }

    public Jobs getWork() {
        return work;
    }
}
