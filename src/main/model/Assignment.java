package main.model;

import java.util.Objects;

public abstract class Assignment {
    public final MessagePrinter messagePrinter = new MessagePrinter(this);
    protected int number;
    protected String content;
    protected String course;
    protected String date;
    protected String type;
    protected double timeneeded;


    public Assignment(int number, String content, String course, String type, String date, double timeneeded)  {
        this.number = number;
        this.content = content;
        this.course = course;
        this.date = date;
        this.type = type;
        this.timeneeded = timeneeded;
    }



    // EFFECTS: get the number for the task
    public int getNumber() {
        return number;
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

    public double getTimeneeded() {
        return timeneeded;
    }

    // MODIFIES: this
    // EFFECTS: sets number to parameter
    public void setNumber(int number) {
        this.number = number;
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

    public void setTimeneeded(double timeneeded) {
        this.timeneeded = timeneeded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assignment assignment = (Assignment) o;
        return number == assignment.number &&
                Double.compare(assignment.timeneeded, timeneeded) == 0 &&
                Objects.equals(content, assignment.content) &&
                Objects.equals(course, assignment.course) &&
                Objects.equals(date, assignment.date) &&
                Objects.equals(type, assignment.type);
    }

    @Override
    public int hashCode() {

        return Objects.hash(number, content, course, date, type, timeneeded);
    }



}

