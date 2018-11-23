package main.model;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private List<Assignment> todoList;
    private List<Assignment> crossOffList;
    public static int Number;


    public TodoList() {

        todoList = new ArrayList<>();
        crossOffList = new ArrayList<>();
        Number = 1;

    }

    public List<Assignment> getTodoList() {
        return todoList;
    }

    public void addregulartask(Assignment a) {
        todoList.add(a);
        print();
        Number++;
    }

    public void addurgentrtask(UrgentAssignment u) {
        todoList.add(u);
        print();
        Number++;
    }

    public void addoptionaltask(Assignment a)  {
        todoList.add(a);
        print();
        Number++;

    }

    public void removetask(int num) {
        boolean itemThere = false;

        for (Assignment a : todoList) {
            if (a.getNumber() == num) {
                itemThere = true;
                todoList.remove(a);
                crossOffList.add(a);
                System.out.println("The item you selected has been deleted from the Todo List.\n");
                System.out.println("You have " + todoList.size() + " items left in your TodoList");
            }
        }
        if (!itemThere) {
            System.out.println("Item Not Found!!!");
        }

    }


    public void retrievetask(int num) {
        boolean itemThere = false;
        for (Assignment t : crossOffList) {
            if (t.getNumber() == num) {
                itemThere = true;
                crossOffList.remove(t);
                todoList.add(t);
                System.out.println("The item you selected has been retrieved and placed back to the Todo List.");
            }
        }
        if (!itemThere) {
            System.out.println("Item Not Found!!!");
        }
    }


    public void print() {
        System.out.println("The assignment " + Number + " is added successfully!\n");

    }


    }

