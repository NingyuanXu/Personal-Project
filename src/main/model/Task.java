package main.model;


public class Task {
    private int index;
    private String content;
    private String course;
    private String date;
    private String type;
    private int timeneeded;


    @Override
    public String toString() {
        return "Task{" +
                "index=" + index +
                ", content='" + content + '\'' +
                ", course='" + course + '\'' +
                ", date='" + date + '\'' +
                ", type='" + type + '\'' +
                ", timeneeded=" + timeneeded +
                '}';
    }


    public Task(int index, String content, String course, String type, String date, int timeneeded) {
        this.index = index;
        this.content = content;
        this.course = course;
        this.date = date;
        this.type = type;
        this.timeneeded = timeneeded;
    }


    // EFFECTS: get the index for the task
    public int getIndex() {
        return index;
    }


    // EFFECTS: get the content for the task
    public String getContent() {
        return content;
    }


    // EFFECTS: get the course for the task

    public String getCourse() {
        return course;
    }

    // EFFECTS: get the date for the task

    public String getDate() {
        return date;
    }

    // EFFECTS: get the type for the task

    public String getType() {
        return type;
    }

    // EFFECTS: get the time needed for the task

    public int getTimeneeded() {
        return timeneeded;
    }

    // MODIFIES: this
    // EFFECTS: sets index to parameter
    public void setIndex(int index) {
        this.index = index;
    }

    // MODIFIES: this
    // EFFECTS: sets content to parameter

    public void setContent(String content) {
        this.content = content;
    }

    // MODIFIES: this
    // EFFECTS: sets course to parameter
    public void setCourse(String course) {
        this.course = course;
    }

    // MODIFIES: this
    // EFFECTS: sets date to parameter
    public void setDate(String date) {
        this.date = date;
    }

    // MODIFIES: this
    // EFFECTS: sets type to parameter

    public void setType(String type) {
        this.type = type;
    }

    // MODIFIES: this
    // EFFECTS: sets timeneeded to parameter

    public void setTimeneeded(int timeneeded) {
        this.timeneeded = timeneeded;
    }
}








