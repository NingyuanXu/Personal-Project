package main.model;

public class Student implements Observer{
    String name;



    public Student (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update() {
        System.out.println(name+" : A new assignment has been released! "  );
    }
}
