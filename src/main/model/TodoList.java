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
    public Map<Integer,Task > taskMap  = new HashMap<>();


    public TodoList(Operation operation) {

        this.operation = operation;
    }

    public void buildTask(String currentClass, ArrayList<String> temp) {
        if (currentClass != "") {
            if (currentClass.equals("Regulartask")) {
                todoList.add(new Regulartask(temp));
            }
            if (currentClass.equals("Optionaltask")) {
                todoList.add(new Optionaltask(temp));
            }
            if (currentClass.equals("Urgenttask")) {
                todoList.add(new Urgenttask(temp));
            }
        }
    }

    public void removetask(int num) throws ItemNotThereException {

        if (taskMap.containsKey(num)) {
            todoList.remove(taskMap.get(num));
            operation.getCrossoffList().crossoffList.add(taskMap.get(num));
            System.out.println("The item you selected has been deleted from the Todo List.\n");
            System.out.println("You have " + todoList.size() + " items left in your TodoList");

        } else {
            throw new ItemNotThereException();
        }
    }

    public void addregulartask() throws TooManyThingsToDoException, NegativeNumberException, IOException {
        scanner = new Scanner(System.in);
        Task t = new Regulartask(Number, "", "", "", "", Number);
        System.out.println("Please enter the regular assignment in text.");
        String content = scanner.nextLine();
        t.setContent(content);
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
        if (todoList.size() >= 10)
            throw new TooManyThingsToDoException();
        if (!todoList.contains(t))
        {todoList.add(t);
        t.addTodoList(this);
        taskMap.put(Number,t);
        Number++;
        System.out.println("The assignment " + Number + " is added successfully!");
        }
    }

    public void addurgentrtask() throws TooManyThingsToDoException, NegativeNumberException, IOException {
        scanner = new Scanner(System.in);
        Urgenttask t2 = new Urgenttask(Number, "", "", "", "", Number, Number, Number);
        System.out.println("Please enter the URGENT assignment in text.");
        String content = scanner.nextLine();
        t2.setContent(content);
        System.out.println("Please enter the course of the assignment.");
        String course = scanner.nextLine();
        t2.setCourse(course);
        System.out.println("Please enter the type of the assignment: Webwork, Lab, Essay, Other");
        String type = scanner.nextLine();
        t2.setType(type);
        System.out.println("Please enter the due date for this assignment,e.g 2018/10/01,11:59pm");
        String date = scanner.nextLine();
        t2.setDate(date);
        System.out.println("Please enter the time needed for the assignment.");
        double timeneeded = Double.parseDouble(scanner.nextLine());
        if (timeneeded < 0)
            throw new NegativeNumberException();
        t2.setTimeneeded(timeneeded);
        assert (timeneeded > 0);
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
        if (todoList.size() >= 10)
            throw new TooManyThingsToDoException();
        if (!todoList.contains(t2))
        {todoList.add(t2);
        t2.addTodoList(this);
        taskMap.put(Number,t2);
        Number++;
        System.out.println("The assignment " + Number + " is added successfully!");
        }
    }

    public void addoptionaltask() throws TooManyThingsToDoException, NegativeNumberException, IOException {
        scanner = new Scanner(System.in);
        Task t3 = new Optionaltask(Number, "", "", "", "", Number);
        System.out.println("Please enter the OPTIONAL assignment in text.");
        String content = scanner.nextLine();
        t3.setContent(content);
        System.out.println("Please enter the course of the assignment.");
        String course = scanner.nextLine();
        t3.setCourse(course);
        System.out.println("Please enter the type of the assignment: Webwork, Lab, Essay, Other");
        String type = scanner.nextLine();
        t3.setType(type);
        System.out.println("Please enter the due date for this assignment,e.g 2018/10/01,11:59pm");
        String date = scanner.nextLine();
        t3.setDate(date);
        System.out.println("Please enter the time needed for the assignment.");
        double timeneeded = Integer.parseInt(scanner.nextLine());
        if (timeneeded < 0)
            throw new NegativeNumberException();
        t3.setTimeneeded(timeneeded);
        assert (timeneeded > 0);
        if (todoList.size() >= 10)
            throw new TooManyThingsToDoException();
        if (!todoList.contains(t3))
        {todoList.add(t3);
        t3.addTodoList(this);
        taskMap.put(Number,t3);
        Number++;
        System.out.println("The assignment " + Number + " is added successfully!");
        }
    }

    public List<Task> getTodoList() {
        return todoList;
    }
}