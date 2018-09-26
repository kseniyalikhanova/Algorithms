package by.bsu.likhanova.parallelSort.entity;

public class Worker {
    private String name;
    private int age;
    private int salary;

    public Worker(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String toString(boolean flag) {
        if (flag){
            return "Worker name = " + name + ", age = " + age + ", salary = " + salary + ";\n";
        } else {
            return "Worker name = " + name + ", age = " + age + ";\n";
        }
    }
}
