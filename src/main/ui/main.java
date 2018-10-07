package main.ui;

import main.model.AssignmentTodo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class main {


    public static void main(String[] args) throws IOException {


        Scanner scanner = new Scanner(System.in);
        String operation;
        PrintWriter writer = new PrintWriter("outputfile.txt", "UTF-8");

        AssignmentTodo todo = new AssignmentTodo();



        System.out.println("Welcome to my project! This is an AssignmentTodo App.");
        System.out.println("What would you like to do [1] add an assignment to the Todo list, [2] cross off an item [3] show all the Todo items [4] retrieve an item. [5] add an URGENT assignment to the Todo List");
        System.out.println("Please enter your option.");

        while (todo.load()) {

            operation = scanner.nextLine();


            if (operation.equals("1")) {

                todo.addregulartask();
                System.out.println("Please enter your option.");

            } else if (operation.equals("2")) {

                System.out.println(todo.todoList);
                System.out.println("Please select the number for the item that you would like to delete.");
                operation = scanner.nextLine();
                todo.removetask(Integer.parseInt(operation));
                System.out.println("Please enter your option.");


            } else if (operation.equals("3")) {


                for (int num = 0; num < todo.lines.size(); num++) {
                    System.out.println("Content: " + todo.lines.get(num) + " ");
                    System.out.println("Course: " + todo.lines.get(num + 1) + " ");
                    System.out.println("Date: " + todo.lines.get(num + 2) + " ");
                    System.out.println("Type: " + todo.lines.get(num + 3) + " ");
                    System.out.println("Timeneeded: " + todo.lines.get(num + 4));
                    num = num + 4;
                    System.out.println("");
                }
                System.out.println("Please enter your option.");


            } else if (operation.equals("4")) {

                System.out.println(todo.crossoffList);
                System.out.println("Please enter the number of the item that you would like to retrieve.");
                operation = scanner.nextLine();
                todo.retrievetask(Integer.parseInt(operation));
                System.out.println("Please enter your option.");

            }

            else if (operation.equals("5")) {
                todo.addurgentrtask();
                System.out.println("Please enter your option.");

            }

            else if (operation.equals("quit")) {
                writer.println(todo.lines);
                writer.close();
                todo.save();
            } else {
                System.out.println("INVALID Input");
                System.out.println("Please enter your option.");

            }
        }





        }
        }

