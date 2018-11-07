package main.model;

import exceptions.ItemNotThereException;
import exceptions.NegativeNumberException;
import exceptions.TooManyThingsToDoException;

import java.io.IOException;
import java.util.*;

public class TodoList {
    private final Operation operation;
    public List<Task> todoList = new ArrayList<Task>();
    public Scanner scanner;
    public int Number = 1;
    public static Map<Integer,Task > taskMap  = new HashMap<>();


    public TodoList(Operation operation) {

        this.operation = operation;
    }

    public void buildTask(String currentClass, ArrayList<String> temp) {
        if (currentClass != "") {
            if (currentClass.equals("Regulartask")) {
                Regulartask r = new Regulartask(temp);
                todoList.add(r);
                taskMap.put(r.getNumber(),r);
            }
            if (currentClass.equals("Optionaltask")) {
                Optionaltask o = new Optionaltask(temp);
                todoList.add(o);
                taskMap.put(o.getNumber(),o);

            }
            if (currentClass.equals("Urgenttask")) {
                Urgenttask u = new Urgenttask(temp);
                todoList.add(u);
                taskMap.put(u.getNumber(),u);

            }
        }
    }

    public void removetask(int num) throws ItemNotThereException {

        if (taskMap.containsKey(num)) {
            todoList.remove(taskMap.get(num));
            operation.getCrossoffList().crossoffList.add(taskMap.get(num));
            taskMap.remove(num);
            System.out.println("The item you selected has been deleted from the Todo List.\n");
            System.out.println("You have " + todoList.size() + " items left in your TodoList");
        }
       else {throw new ItemNotThereException();}

    }


    public void addregulartask() throws TooManyThingsToDoException, NegativeNumberException, IOException {
        scanner = new Scanner(System.in);
        Task t = new Regulartask(Number, "", "", "", "", Number);
        System.out.println("Please enter the regular assignment in text.");
        String content = scanner.nextLine();
        t.setContent(content);
        addTaskHelperOne(t);
        addTaskHelperTwo(t);
    }

    public void addurgentrtask() throws TooManyThingsToDoException, NegativeNumberException, IOException {
        scanner = new Scanner(System.in);
        Urgenttask t2 = new Urgenttask(Number, "", "", "", "", Number, Number, Number);
        System.out.println("Please enter the URGENT assignment in text.");
        String content = scanner.nextLine();
        t2.setContent(content);
        addTaskHelperOne(t2);
        addUrgentTaskHelper(t2);
        addTaskHelperTwo(t2);
    }

    public void addoptionaltask() throws TooManyThingsToDoException, NegativeNumberException, IOException {
        scanner = new Scanner(System.in);
        Task t3 = new Optionaltask(Number, "", "", "", "", Number);
        System.out.println("Please enter the optional assignment in text.");
        String content = scanner.nextLine();
        t3.setContent(content);
        addTaskHelperOne(t3);
        addTaskHelperTwo(t3);
    }

    private void addTaskHelperOne(Task t) throws NegativeNumberException {
        System.out.println("Please enter the course of the assignment.");
        String course = scanner.nextLine();
        t.setCourse(course);
        System.out.println("Please enter the type of the assignment: Webwork, Lab, Essay, Other");
        String type = scanner.nextLine();
        t.setType(type);
        System.out.println("Please enter the due date for this assignment,e.g 2018/10/01,11:59pm");
        String date = scanner.nextLine();
        t.setDate(date);
        System.out.println("Please enter the time needed for the assignment.");
        double timeneeded = Double.parseDouble(scanner.nextLine());
        if (timeneeded < 0)
            throw new NegativeNumberException();
        t.setTimeneeded(timeneeded);
        assert (timeneeded > 0);
    }

    private void addTaskHelperTwo(Task t) throws TooManyThingsToDoException {
        if (todoList.size() >= 10)
            throw new TooManyThingsToDoException();
        if (!todoList.contains(t)) {
            todoList.add(t);
            t.addTodoList(this);
            taskMap.put(Number, t);
            System.out.println("The assignment " + Number + " is added successfully!");
            Number++;
        }
    }



    private void addUrgentTaskHelper(Urgenttask t2) throws NegativeNumberException {
        System.out.println("Please enter the level of urgency for the assignment, from 0-10");
        int levelofurgency = Integer.parseInt(scanner.nextLine());
        if (levelofurgency < 0)
            throw new NegativeNumberException();
        t2.setLevelofurgency(levelofurgency);
        assert (levelofurgency > 0);
        System.out.println("Please enter the percentage of weight for the assignment in the final, eg. 30");
        int percentageofweight = Integer.parseInt(scanner.nextLine());
        if (percentageofweight < 0)
            throw new NegativeNumberException();
        t2.setPercentageofweight(percentageofweight);
        assert (percentageofweight > 0);
    }






    public List<Task> getTodoList() {
        return todoList;
    }


}