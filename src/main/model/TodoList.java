package main.model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TodoList {
    private List<Assignment> todoList;
    private List<Assignment> crossOffList;
    public static int Number;
    public static Map<Integer, Assignment> taskMap1  = new HashMap<>();
    public static Map<Integer, Assignment> taskMap2  = new HashMap<>();



    public TodoList() {

        todoList = new ArrayList<>();
        crossOffList = new ArrayList<>();
        Number = 1;

    }

    public List<Assignment> getTodoList() {
        return todoList;
    }

    public List<Assignment> getCrossOffList() {
        return crossOffList;
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
                JOptionPane.showConfirmDialog(null,"The item you selected has been deleted from the Todo List.");
                System.out.println("The assignment is deleted successfully!");
            }
        }
        if (!itemThere) {
            JOptionPane.showConfirmDialog(null,"Item Not Found!!!");

        }

    }


    public void retrievetask(int num) {
        boolean itemThere = false;
        for (Assignment t : crossOffList) {
            if (t.getNumber() == num) {
                itemThere = true;
                crossOffList.remove(t);
                todoList.add(t);
                JOptionPane.showConfirmDialog(null,"The item you selected has been retrieved and placed back to the Todo List.");
                System.out.println("The deleted item is retrieved successfully!");
            }
        }
        if (!itemThere) {
            JOptionPane.showConfirmDialog(null,"Item Not Found!!!");
        }
    }


    public void print() {
        System.out.println("The assignment " + Number + " is added successfully!\n");

    }


    }

