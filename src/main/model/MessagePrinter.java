package main.model;

public class MessagePrinter {
    private final Assignment assignment;

    public MessagePrinter(Assignment assignment) {
        this.assignment = assignment;
    }

    public String printcontent() {
        return
                "Number: "+assignment.getNumber()  +"  " +
                        "Content: " + assignment.getContent() + "  " +
                        "Course: " + assignment.getCourse() + "  " +
                        "Date: " + assignment.getDate() + "  " +
                        "Type: " + assignment.getType() + "  " +
                        "Timeneeded: " + assignment.getTimeneeded() + "  ";
    }



}