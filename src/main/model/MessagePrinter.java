package main.model;

public class MessagePrinter {
    private final Assignment assignment;

    public MessagePrinter(Assignment assignment) {
        this.assignment = assignment;
    }

    public String printcontent() {
        return
                 assignment.getNumber() + " "+"\n" +
                        "Content: " + assignment.getContent() + "\n" +
                        "Course: " + assignment.getCourse() + "\n" +
                        "Date: " + assignment.getDate() + "\n" +
                        "Type: " + assignment.getType() + "\n" +
                        "Timeneeded: " + assignment.getTimeneeded() + "\n";
    }



}