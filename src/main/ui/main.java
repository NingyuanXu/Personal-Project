package main.ui;

import main.model.AssignmentTodo;
import main.model.Task;
import main.model.Urgenttask;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class main {


    public static void main(String[] args) throws IOException {

        Task t = new Urgenttask(1, "", "", "", "", 2);
        t.setreminder();
        t.complete();

        Scanner scanner = new Scanner(System.in);
        String operation;


        AssignmentTodo todo = new AssignmentTodo(true);


        System.out.println("\nWelcome to my project! This is an AssignmentTodo App.");
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

                todo.addregulartask();
                System.out.println("Please enter your option.");

            } else if (operation.equals("2")) {
                todo.addurgentrtask();
                System.out.println("Please enter your option.");

            } else if (operation.equals("3")) {
                todo.addoptionaltask();
                System.out.println("Please enter your option.");

            } else if (operation.equals("4")) {


                for(Task task: todo.todoList){
                    System.out.println(task.toString());

                }
                System.out.println("Please enter your option.");


            } else if (operation.equals("5")) {

                for (Task task : todo.todoList) {
                    System.out.println(task.toString());

                }
                System.out.println("Please select the number for the item that you would like to delete.");
                operation = scanner.nextLine();
                todo.removetask(Integer.parseInt(operation));
                System.out.println("Please enter your option.");


            } else if (operation.equals("6")) {

                for (Task task : todo.crossoffList) {
                    System.out.println(task.toString());

                }
                System.out.println("Please enter the number of the item that you would like to retrieve.");
                operation = scanner.nextLine();
                todo.retrievetask(Integer.parseInt(operation));
                System.out.println("Please enter your option.");

            } else if (operation.equals("quit")) {
                PrintWriter writer = new PrintWriter("outputfile.txt", "UTF-8");
                writer.println(todo.Number);
                for(Task task:todo.todoList){
                    writer.println(task.toString());
                }
                writer.close();
                break;
            }
        }
    }
}









