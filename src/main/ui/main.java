package main.ui;

import exceptions.ItemNotThereException;
import exceptions.NegativeNumberException;
import exceptions.TooManyThingsToDoException;
import main.model.Assignment;
import main.model.Operation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;


public class main {
    private AssignemntTodoApp assignemntTodoApp;
    private AddRegularAssignment addRegularAssignment;
    private AddUrgentAssignment addUrgentAssignment;
    private AddOptionalAssignment addOptionalAssignment;
    private Display display;
    private Delete delete;
    private Retrieve retrieve;

    public static void main(String[] args) throws MalformedURLException, IOException {

        BufferedReader br = null;

        try {
            String theURL = "https://www.ugrad.cs.ubc.ca/~cs210/2018w1/welcomemsg.html"; //this can point to any URL
            URL url = new URL(theURL);
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;

            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {

                sb.append(line);
                sb.append(System.lineSeparator());
            }

            System.out.println(sb);
        } finally {

            if (br != null) {
                br.close();
            }
        }




        Scanner scanner = new Scanner(System.in);
        String operation;

        Operation todo = new Operation(true);

        new AssignemntTodoApp();

        System.out.println("This is an Assignment Todo App.");

        System.out.println("\nWhat would you like to do\n " +
                "\n[1] add a REGULAR assignment to the Todo list." +
                "\n[2] add an URGENT assignment to the Todo List." +
                "\n[3] add an OPTIONAL assignment to the Todo List." +
                "\n[4] show all the assignments in the Todo List. " +
                "\n[5] cross off an item from the Todo List. " +
                "\n[6] retrieve an item.  ");
        System.out.println("\nPlease enter your option.");


        while (true) {



            operation = scanner.nextLine();


            if (operation.equals("1")) {

                try {
                    todo.addregulartask();
                } catch (NegativeNumberException e) {
                    System.out.println("You entered a negative number!");
                }catch (TooManyThingsToDoException e) {
                    System.out.println("You have too many things to do.");
                }finally {
                    System.out.println("\nPlease enter your option.");
                }



            } else if (operation.equals("2")) {
                try {
                    try {
                        todo.addurgentrtask();
                    } catch (NegativeNumberException e) {
                        System.out.println("You entered a negative number!");
                    }
                } catch (TooManyThingsToDoException e) {
                    System.out.println("You have too many things to do.");
                }finally {
                    System.out.println("\nPlease enter your option.");
                }


            } else if (operation.equals("3")) {
                try {
                    try {
                        todo.addoptionaltask();
                    } catch (NegativeNumberException e) {
                        System.out.println("You entered a negative number!");
                    }
                } catch (TooManyThingsToDoException e) {
                    System.out.println("You have too many things to do.");
                }finally {
                    System.out.println("\nPlease enter your option.");
                }


            } else if (operation.equals("4")) {


                for(Assignment assignment : todo.todoList.getTodoList()){
                    System.out.println(assignment.toString());

                }

                System.out.println("Please enter your option.");


            } else if (operation.equals("5")) {

                for (Assignment assignment : todo.todoList.getTodoList()) {
                    System.out.println(assignment.toString());

                }
                System.out.println("Please select the number for the item that you would like to display.");
                operation = scanner.nextLine();
                try {
                    todo.removetask(Integer.parseInt(operation));
                } catch (ItemNotThereException e) {
                    System.out.println("ITEM NOT FOUND!");

                }finally {
                    System.out.println("Please enter your option.");
                }



            } else if (operation.equals("6")) {

                for (Assignment assignment : todo.crossoffList.crossoffList) {
                    System.out.println(assignment.toString());

                }
                System.out.println("Please enter the number of the item that you would like to retrieve.");
                operation = scanner.nextLine();
                try {
                    todo.retrievetask(Integer.parseInt(operation));
                } catch (ItemNotThereException e) {
                    System.out.println("ITEM NOT FOUND!");

                }finally {
                    System.out.println("Please enter your option.");
                }


            } else if (operation.equals("quit")) {
                PrintWriter writer = new PrintWriter("outputfile.txt", "UTF-8");
                writer.println(todo.todoList.Number);
                for(Assignment assignment : todo.todoList.getTodoList()){
                    writer.println(assignment.toString());
                }
                writer.close();
                break;
            }
        }
    }
}