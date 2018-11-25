package main.model;

import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.*;

import static java.nio.file.Files.readAllLines;

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
        for (String line : lines) {
            writer.println(line);
        }
        writer.close();
    }

    public void load() throws IOException {
        List<String> lines = readAllLines(Paths.get("outputfile.txt"));
        String currentClass ;
        for (String s : lines) {
            ArrayList<String> partsOfLine = splitOnSpace(s);
            if (partsOfLine.get(0).equals("Regular Assignment") || partsOfLine.get(0).equals("Optional Assignment") || partsOfLine.get(0).equals("Urgent Assignment")) {
                currentClass = partsOfLine.get(0);
                partsOfLine.remove(0);
                buildTask(currentClass, partsOfLine);
            }
        }
    }

    public static ArrayList<String> splitOnSpace(String line){
        String[] splits = line.split("  ");
        return new ArrayList<>(Arrays.asList(splits));
    }

    private void buildTask(String currentClass, List<String> lines) {
        if (currentClass.equals("Regular Assignment")) {
            Assignment r = new RegularAssignment(0, "", "", "", "", 0);
            createTask(r, lines);
            todoList.add(r);
            taskMap1.put(r.getNumber(), r);
        } else if (currentClass.equals("Optional Assignment")) {
            Assignment o = new OptionalAssignment(0, "", "", "", "", 0);
            createTask(o, lines);
            todoList.add(o);
            taskMap1.put(o.getNumber(), o);

        } else if (currentClass.equals("Urgent Assignment")) {
            UrgentAssignment u = new UrgentAssignment(0, "", "", "", "", 0, 0, 0);
            createTask2(u, lines);
            todoList.add(u);
            taskMap1.put(u.getNumber(), u);
        }

    }

    private void createTask2(UrgentAssignment u, List<String> lines) {
        for (String s : lines) {
            if (s.startsWith("Number")) {
                u.setNumber(Integer.parseInt(s.substring(8)));
            } else if (s.startsWith("Content")) {
                u.setContent(s.substring(9));
            } else if (s.startsWith("Course")) {
                u.setContent(s.substring(8));
            } else if (s.startsWith("Date")) {
                u.setDate(s.substring(6));
            } else if (s.startsWith("Type")) {
                u.setType(s.substring(6));
            } else if (s.startsWith("Timeneeded")) {
                u.setTimeneeded(Double.parseDouble(s.substring(12)));
            } else if (s.startsWith("Level of urgency")) {
                u.setLevelofurgency(Integer.parseInt(s.substring(18)));
            } else if (s.startsWith("Percentage of weight")) {
                u.setPercentageofweight(Integer.parseInt(s.substring(22)));
            }
        }
    }

    private void createTask(Assignment a, List<String> lines) {

        for (String s : lines) {
            if (s.startsWith("Number")) {
                a.setNumber(Integer.parseInt(s.substring(8)));
            } else if (s.startsWith("Content")) {
                a.setContent(s.substring(9));
            } else if (s.startsWith("Course")) {
                a.setCourse(s.substring(8));
            } else if (s.startsWith("Date")) {
                a.setDate(s.substring(6));
            } else if (s.startsWith("Type")) {
                a.setType(s.substring(6));
            } else if (s.startsWith("Timeneeded")) {
                a.setTimeneeded(Double.parseDouble(s.substring(12)));
            }
        }
    }
}



