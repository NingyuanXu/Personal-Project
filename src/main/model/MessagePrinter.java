package main.model;

public class MessagePrinter {
    private final Task task;

    public MessagePrinter(Task task) {
        this.task = task;
    }

    public String printcontent() {
        return
                "number: " + task.getNumber() + "\n" +
                        "content: " + task.getContent() + "\n" +
                        "course: " + task.getCourse() + "\n" +
                        "date: " + task.getDate() + "\n" +
                        "type: " + task.getType() + "\n" +
                        "timeneeded: " + task.getTimeneeded() + "\n";
    }


}