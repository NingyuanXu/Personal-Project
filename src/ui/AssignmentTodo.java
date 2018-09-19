package ui;

import Model.Task;
import java.util.ArrayList;
import java.util.Scanner;

public class AssignmentTodo {
    ArrayList<Task> todoList = new ArrayList<>();
    ArrayList<Task> crossoffList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    String operation;
    int Number = 1;

    public void removetask (int Number) {
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

    public void retrievetask (int Number) {

                for (Task t : crossoffList) {
                    if (t.getNumber() == Number) {
                        crossoffList.remove(t);
                        todoList.add(t);
                        System.out.println("The item you selected has been retrieved and placed back to the Todo List.");
                        break;
                    }
                }

                }




    public AssignmentTodo() {

        System.out.println("Welcome to my project! This is an AssignmentTodo List App.");
        System.out.println("what would you like to do [1] add a to do list item, [2] cross off an item [3] show all the items todo, [4] retrieve an item");



        while (true) {

            System.out.println("Please enter your option.");

            operation = scanner.nextLine();


            if (operation.equals("1")) {



                Task t = new Task(Number,"","","","",Number);
                System.out.println("Please enter the assignment in text");
                String content = scanner.next();
                t.setContent(content);
                System.out.println("Please enter the due date for this assignment.");
                String date = scanner.next();
                t.setDate(date);
                System.out.println("Enter the course of the assignment.");
                String course = scanner.next();
                t.setCourse(course);
                System.out.println("Enter the type of the assignment.");
                String type = scanner.next();
                t.setType(type);
                System.out.println("Enter the time needed for the assignment.");
                int timeneeded = scanner.nextInt();
                t.setTimeneeded(timeneeded);
                System.out.println("The assignment " +    Number   + " is added successfully!");
                todoList.add(t);
                Number++;


                }



            else if (operation.equals("2")) {
                System.out.println(todoList);
                System.out.println("Select the number for the item that you would like to delete.");
                operation = scanner.nextLine();
                removetask(Integer.parseInt(operation));

            }



            else if (operation.equals("3")) {

                System.out.println(todoList);

            }

            else if (operation.equals("4")) {

                System.out.println(crossoffList);
                System.out.println("Enter the number of the item that you would like to retrieve.");
                operation = scanner.nextLine();
                retrievetask(Integer.parseInt(operation));
            }



            else if (operation.equals("quit")) {
                break;
            }

        }
    }


    public static void main(String[] args) {
        new AssignmentTodo();

    }
}


