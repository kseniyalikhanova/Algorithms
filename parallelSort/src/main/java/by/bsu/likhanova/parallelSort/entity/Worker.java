package by.bsu.likhanova.parallelSort.entity;

public class Worker extends Person {
    private int salary;

    public Worker(String name, int age, int salary) {
        super(name, age);
        this.salary = salary;
    }

    public Worker(Person person, int salary){
        super(person.name, person.age);
        this.salary = salary;
    }

    public Worker(String name, int age) {
        super(name, age);
    }

    public Worker(Person person){
        super(person.name, person.age);
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Worker name = " + super.name +
                ", age = " + super.age +
                ", salary = " + salary +";\n";
    }

    /*public String toString(boolean flag) {
        if (flag) {
            return "Worker name = " + name + ", age = " + age + ", salary = " + salary + ";\n";
        } else {
            return "Worker name = " + name + ", age = " + age + ";\n";
        }
    }*/
}
