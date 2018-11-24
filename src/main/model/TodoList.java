package main.model;

import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TodoList {
    private List<Assignment> todoList;
    private List<Assignment> crossOffList;
    public static int Number;
    public final Map<Integer, Assignment> taskMap1 = new HashMap<>();
    public final Map<Integer, Assignment> taskMap2 = new HashMap<>();


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
        taskMap1.put(a.getNumber(), a);
        print();
        Number++;
    }

    public void addurgentrtask(UrgentAssignment u) {
        todoList.add(u);
        taskMap1.put(u.getNumber(), u);
        print();
        Number++;
    }

    public void addoptionaltask(Assignment a) {
        todoList.add(a);
        taskMap1.put(a.getNumber(), a);
        print();
        Number++;

    }

    public void removetask(int num) {

        if (taskMap1.containsKey(num)) {
            crossOffList.add(taskMap1.get(num));
            todoList.remove(taskMap1.get(num));
            taskMap2.put(num, taskMap1.get(num));
            taskMap1.remove(num);
            JOptionPane.showMessageDialog(null, "The item you selected has been deleted from the Todo List.");
            System.out.println("The assignment is deleted successfully!\n");
        } else {
            JOptionPane.showMessageDialog(null, "Item Not Found!!!");
        }

    }


    public void retrievetask(int num) {

        if (taskMap2.containsKey(num)) {
            todoList.add(taskMap2.get(num));
            crossOffList.remove(taskMap2.get(num));
            taskMap1.put(num, taskMap2.get(num));
            taskMap2.remove(num);
            JOptionPane.showMessageDialog(null, "The item you selected has been retrieved and placed back to the Todo List.");
            System.out.println("The assignment is retrieved successfully!\n");
        } else {
            JOptionPane.showMessageDialog(null, "Item Not Found!!!");
        }


    }


    public void print() {
        System.out.println("The assignment " + Number + " is added successfully!\n");

    }

    public void save() throws IOException {
        PrintWriter writer = new PrintWriter("outputfile.txt", "UTF-8");
        List<String> lines = new ArrayList<>();
        for (Assignment a : todoList) {
            lines.add(a.toString());
        }
        for (String line: lines) {
            writer.println(line);
        }
        writer .close();
    }

//    public void load(List<String> data) throws IOException {
//        List<String> lines = readAllLines(Paths.get("outputfile.txt"));
//        String currentClass="";
//        List<String> temp = new ArrayList<>();
//        for (String s: lines) {
//            if (s.equals("Regular Assignment") || s.equals("Optional Assignment") || s.equals("Urgent Assignment")) {
//                currentClass = s;
//                buildTask(currentClass,temp);
//            } else {
//                temp.add(s);
//            }
//        }
//        buildTask(currentClass, temp);
//    }
//
//    private void buildTask(String currentClass, List<String> lines) {
//
//    }


}
