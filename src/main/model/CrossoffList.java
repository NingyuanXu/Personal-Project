package main.model;

import exceptions.ItemNotThereException;

import java.util.ArrayList;
import java.util.List;

public class CrossoffList {
    private final Operation operation;
    public List<Assignment> crossoffList = new ArrayList<>();

    public CrossoffList(Operation operation) {


        this.operation = operation;
    }
    //REQUIRES: An integer smaller than the size of crossoffList; a non-empty crossoffList

    //MODIFIES: this
    //EFFECTS: delete the task with the same number as the parameter from the crossoffList and add it to the todolist; print out the statement when the operation is done; then break;
    public void retrievetask(int num) throws ItemNotThereException {
        boolean itemThere = false;


        Observable o = new Observable();
        Student s1 = new Student("Will");
        Student s2 = new Student("Jason");
        Student s3 = new Student("Frank");
        o.addObserver(s1);
        o.addObserver(s2);
        o.addObserver(s3);

        for (Assignment t : crossoffList) {
            if (t.getNumber() == num) {
                itemThere = true;
                crossoffList.remove(t);
                operation.getTodoList().add(t);
                TodoList.taskMap.put(num,t);
                break;
            }
        }
        if (itemThere) {
            System.out.println("The item you selected has been retrieved and placed back to the Todo List.");

        } else
            throw new ItemNotThereException();
    }



}