package main.model;

import java.util.ArrayList;
import java.util.List;

public class Observable {
    protected List<Observer> observers;

    public Observable() {
        observers = new ArrayList<>();

        Student s1 = new Student("Will");
        Student s2 = new Student("Jason");
        Student s3 = new Student("Frank");
        addObserver(s1);
        addObserver(s2);
        addObserver(s3);

    }

    public void addObserver(Observer o) {
        if (!observers.contains(o))
            observers.add(o);
    }

    public void notifyObserver() {
        for (Observer o: observers) {
            o.update();

        }

    }
}

