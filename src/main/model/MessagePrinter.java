package main.model;

import implementations.Dailytask;

public class MessagePrinter implements Dailytask {
    private final Assignment assignment;

    public MessagePrinter(Assignment assignment) {
        this.assignment = assignment;
    }

    public String printcontent() {
        return
                "number: " + assignment.getNumber() + "\n" +
                        "content: " + assignment.getContent() + "\n" +
                        "course: " + assignment.getCourse() + "\n" +
                        "date: " + assignment.getDate() + "\n" +
                        "type: " + assignment.getType() + "\n" +
                        "timeneeded: " + assignment.getTimeneeded() + "\n";
    }

    public void print() {
        System.out.println("The assignment is added successfully!");
    }

    @Override
    public String setreminder() {
        String s = " has been completed.";
        return s;
    }

    @Override
    public String complete() {
        String s = "You still have.";
        return s;
    }
}