public class Moon {
    public static void main(String[] args) {
        Employer employer1 = new Employer("Peter", Moods.NORMAL, 100, "TheDryestDayEver", 3);
        Employer employer2 = new Employer("Retep", Moods.NORMAL, 100, "COOL_SHOES", 4);
        Employee employee1 = new Employee("Незнайка", Moods.NORMAL, 100, 1);
        Employee employee2 = new Employee("Козлик", Moods.NORMAL, 110, 0.08);
        Employee employee3 = new Employee("Артем", Moods.NORMAL, 10, 2);
        Employee employee4 = new Employee("Андрей", Moods.NORMAL, 10, 1.1);
        Employee employee5 = new Employee("Дмитрий", Moods.NORMAL, 10, 0.8);
        Employee employee6 = new Employee("Михаил", Moods.NORMAL, 10, 0.14);
        Street street1 = new Street("Центральная");
        Store store1 = new Store(true,30);
        Store store2 = new Store(true,30);
        House house1 = new House(4, true, 10);

        //добавляю постройки на улицу
        street1.addBuilding(store1, house1);

        //засею жильцов в дом и указываю здание бизнеса
        house1.appendPersons(employee1, employee2, employee3, employer1);
        store1.setRenter(employer1);
        store2.setRenter(employer1);

        //проверка работы исключения
        leaveHouse(house1, employee6);

        //засею жильцов в дом
        house1.appendPersons(employee1, employee2, employee3);

        //устраиваю работников на работу работадателям
        employer1.chanceOfEmploy(employee1, employee2, employee3);
        employer2.chanceOfEmploy(employee4, employee5, employee6);
        employer2.chanceOfEmploy(employee4, employee5, employee6);

        //жители идут на прогулку
        street1.walking(employee3, employee1);

        //домой возвращаются не все
        street1.getHome(employee3);

        //день закончился, жители платят ренту, бизнес считает прибыль, жители обдумывают события за день
        Person.payments(house1);
        Employer.benefits(employer1, employer2);
        Person.happening(street1.people);
    }

    public static void leaveHouse(House house, Person person) {
        try {
            house.leave(person);
        }catch (NotHisHouse e){
            System.out.println(e.getMessage());
        }
    }
}
