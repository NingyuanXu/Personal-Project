package main.model;


import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.Files.readAllLines;


public class AssignmentTodo  {
    public ArrayList<Task> todoList = new ArrayList<>();
    public ArrayList<Task> crossoffList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    public int Number = 1;
    private boolean status = true;

    public AssignmentTodo(boolean load) throws IOException {
        if(load) {
            List<String> lines = readAllLines(Paths.get("outputfile.txt"));
            if (lines.size()>0)
            {
                Number =Integer.parseInt(lines.get(0));
            lines.remove(0);
            }

            String currentClass = "";
            ArrayList<String> temp = new ArrayList<>();
            for (String s : lines) {
                if (s.equals("Regulartask") || s.equals("Optionaltask") || s.equals("Urgenttask")) {
                    buildTask(currentClass, temp);
                    currentClass = s;
                    temp = new ArrayList<>();
                } else {
                    temp.add(s);
                }
            }
            buildTask(currentClass, temp);
        }

    }




    private void buildTask(String currentClass, ArrayList<String> temp) {
        if(currentClass!=""){
            if(currentClass.equals("Regulartask")){
                todoList.add(new Regulartask(temp));
            }
            if(currentClass.equals("Optionaltask")){
                todoList.add(new Optionaltask(temp));
            }
            if(currentClass.equals("Urgenttask")){
                todoList.add(new Urgenttask(temp));
            }
        }
    }


    //REQUIRES: An integer smaller than the size of crossoffList;
    //MODIFIES: this
    //EFFECTS: delete the task with same number as the parameter from todolist, and add it to the crossofflist; print out the statement as the operation is done;
    // print"The item you selected has been deleted from the todolist" if item was found
    //print "ITEM NOT FOUND!" if there is no item with the number matching to the parameter

    public void removetask(int Number) {
        boolean itemThere = false;

        for (Task t : todoList) {

            if (t.getNumber() == Number) {
                itemThere = true;
                crossoffList.add(t);
                todoList.remove(t);
                break;
            }
        }
        if (itemThere) {
            System.out.println("The item you selected has been deleted from the Todo List.");
        } else {
            System.out.println("ITEM NOT FOUND!");
        }

    }


    //REQUIRES: An integer smaller than the size of crossoffList; a non-empty crossoffList
    //MODIFIES: this
    //EFFECTS: delete the task with the same number as the parameter from the crossoffList and add it to the todolist; print out the statement when the operation is done; then break;
    public void retrievetask(int Number) {
        boolean itemThere = false;


        for (Task t : crossoffList) {
            if (t.getNumber() == Number) {
                itemThere = true;
                crossoffList.remove(t);
                todoList.add(t);
                break;
            }
        }
        if (itemThere) {
            System.out.println("The item you selected has been retrieved and placed back to the Todo List.");
        } else System.out.println("ITEM NOT FOUND!");
    }


    //MODIFIES: Regulartask t,this
    //EFFECTS: create a new regular task t
    // then add the regular task t into todoList

    public void addregulartask() {
        Task t = new Regulartask(Number, "", "", "", "", Number);
        System.out.println("Please enter the assignment in text.");
        String content = scanner.next();
        t.setContent(content);
        System.out.println("Please enter the course of the assignment.");
        String course = scanner.next();
        t.setCourse(course);
        System.out.println("Please enter the type of the assignment: Webwork, Lab, Essay, Other");
        String type = scanner.next();
        t.setType(type);
        System.out.println("Please enter the due date for this assignment,e.g 2018/10/01,11:59pm");
        String date = scanner.next();
        t.setDate(date);
        System.out.println("Please enter the time needed for the assignment.");
        int timeneeded = scanner.nextInt();
        t.setTimeneeded(timeneeded);
        System.out.println("The assignment " + Number + " is added successfully!");
        todoList.add(t);
        Number++;
    }

    //MODIFIES: Urgenttask t,this
    //EFFECTS: create a new urgent task t
    // then add the urgent task t into todoList

    public void addurgentrtask() {
        Urgenttask t2 = new Urgenttask(Number, "", "", "", "", Number,Number,Number);
        System.out.println("Please enter the URGENT assignment in text.");
        String content = scanner.next();
        t2.setContent(content);
        System.out.println("Please enter the course of the assignment.");
        String course = scanner.next();
        t2.setCourse(course);
        System.out.println("Please enter the type of the assignment: Webwork, Lab, Essay, Other");
        String type = scanner.next();
        t2.setType(type);
        System.out.println("Please enter the due date for this assignment,e.g 2018/10/01,11:59pm");
        String date = scanner.next();
        t2.setDate(date);
        System.out.println("Please enter the time needed for the assignment.");
        int timeneeded = scanner.nextInt();
        t2.setTimeneeded(timeneeded);
        System.out.println("Please enter the level of urgency for the assignment, from 0-10");
        int levelofurgency = scanner.nextInt();
        t2.setLevelofurgency(levelofurgency);
        System.out.println("Please enter the percentage of weight for the assignment, eg.30");
        int percentageofweight = scanner.nextInt();
        t2.setPercentageofweight(percentageofweight);
        System.out.println("The assignment " + Number + " is added successfully!");
        todoList.add(t2);
        Number++;
    }

    //MODIFIES: Optionaltask t,this
    //EFFECTS: create a new optional task t
    // then add the optional task t into todoList

    public void addoptionaltask() {
        Task t3 = new Optionaltask(Number, "", "", "", "", Number);
        System.out.println("Please enter the OPTIONAL assignment in text.");
        String content = scanner.next();
        t3.setContent(content);
        System.out.println("Please enter the course of the assignment.");
        String course = scanner.next();
        t3.setCourse(course);
        System.out.println("Please enter the type of the assignment: Webwork, Lab, Essay, Other");
        String type = scanner.next();
        t3.setType(type);
        System.out.println("Please enter the due date for this assignment,e.g 2018/10/01,11:59pm");
        String date = scanner.next();
        t3.setDate(date);
        System.out.println("Please enter the time needed for the assignment.");
        int timeneeded = scanner.nextInt();
        t3.setTimeneeded(timeneeded);
        System.out.println("The assignment " + Number + " is added successfully!");
        todoList.add(t3);
        Number++;
    }



}




