package by.bsu.likhanova.parallelSort.initialiser;

import by.bsu.likhanova.parallelSort.entity.Person;
import by.bsu.likhanova.parallelSort.entity.Worker;

public class TableInitialiser {
    public static Worker[] initializeChiefTable(){
        Worker[] workers = new Worker[10];
        for (int i = 0; i < 10; i++) {
            workers[i] = new Worker(initializeWorkerTable()[i]);
        }
        workers[0].setSalary(3000);
        workers[1].setSalary(2000);
        workers[2].setSalary(2500);
        workers[3].setSalary(1500);
        workers[4].setSalary(3500);
        workers[5].setSalary(1000);
        workers[6].setSalary(4000);
        workers[7].setSalary(5000);
        workers[8].setSalary(1700);
        workers[9].setSalary(3100);
        return workers;
    }

    public static Person[] initializeWorkerTable(){
        Person[] people = new Person[10];
        people[0] = new Person("Kseniya", 19);
        people[1] = new Person("Max", 35);
        people[2] = new Person("Vitaly", 29);
        people[3] = new Person("Kate", 24);
        people[4] = new Person("Mike", 33);
        people[5] = new Person("Olga", 22);
        people[6] = new Person("Ivan", 37);
        people[7] = new Person("Tatyana", 45);
        people[8] = new Person("Alex", 18);
        people[9] = new Person("Anton", 26);
        return people;
    }
}
