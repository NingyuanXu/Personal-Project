package main.model;

public class MessagePrinter {
    private final Assignment assignment;

    public MessagePrinter(Assignment assignment) {
        this.assignment = assignment;
    }

    public String printcontent() {
        return
                 assignment.getNumber() + " "+"\n" +
                        "content: " + assignment.getContent() + "\n" +
                        "course: " + assignment.getCourse() + "\n" +
                        "date: " + assignment.getDate() + "\n" +
                        "type: " + assignment.getType() + "\n" +
                        "timeneeded: " + assignment.getTimeneeded() + "\n";
    }



}