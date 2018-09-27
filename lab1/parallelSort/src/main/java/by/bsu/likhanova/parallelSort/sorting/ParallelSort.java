package by.bsu.likhanova.parallelSort.sorting;

import by.bsu.likhanova.parallelSort.entity.Person;
import by.bsu.likhanova.parallelSort.entity.Worker;

public class ParallelSort {
    private Person[] people;

    public  ParallelSort(){
        people = new Person[10];
    }
    public ParallelSort(Person[] people){
        this.people = people;
    }

    public void setPeople(Person[] people) {
        this.people = people;
    }

    public void parallelSort(Worker[] workers, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            parallelSort(workers, left, middle);
            parallelSort(workers, middle + 1, right);
            parallelMerge(workers, left, middle, right);
        }
    }

    private void parallelMerge(Worker[] workers, int left, int middle, int right) {
        Worker[] helper = new Worker[workers.length];
        for (int i = left; i <= right; i++) {
            helper[i] = workers[i];
        }

        int helperLeft = left;
        int helperRight = middle + 1;
        int current = left;

        while (helperLeft <= middle && helperRight <= right) {
            if (helper[helperLeft].getSalary() <= helper[helperRight].getSalary()) {
                workers[current] = helper[helperLeft];
                peopleSort(workers[current], current);
                helperLeft++;

            } else {
                workers[current] = helper[helperRight];
                peopleSort(workers[current], current);
                helperRight++;
            }
            current++;
        }

        for (int i = 0; helperLeft <= middle; i++, helperLeft++) {
            workers[current + i] = helper[helperLeft];
            peopleSort(workers[current], current);
        }
        for (int i = 0; helperRight <= right; i++, helperRight++) {
            workers[current + i] = helper[helperRight];
            peopleSort(workers[current], current);
        }
    }
    private void peopleSort(Worker worker, int current){
        for (int j = 0; j < people.length; j++) {
            if((worker.getName().equals(people[j].getName()))
                    && worker.getAge() == people[j].getAge()){
                Person tmp = people[current];
                people[current] = people[j];
                people[j] = tmp;
                break;
            }
        }
    }
}
