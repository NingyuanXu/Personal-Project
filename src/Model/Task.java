package Model;

import java.util.ArrayList;
import java.util.Date;


public class Task {
    private int number;
    private String content;
    private String course;
    private String date;

    @Override
    public String toString() {
        return "Task{" +
                "number=" + number +
                ", content='" + content + '\'' +
                ", course='" + course + '\'' +
                ", date='" + date + '\'' +
                ", type='" + type + '\'' +
                ", timeneeded=" + timeneeded +
                '}';
    }

    private String type;
    private int timeneeded;



    public Task(int number, String content, String course, String date, String type, int timeneeded) {
        this.number = number;
        this.content = content;
        this.course = course;
        this.date = date;
        this.type = type;
        this.timeneeded = timeneeded;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTimeneeded() {
        return timeneeded;
    }

    public void setTimeneeded(int timeneeded) {
        this.timeneeded = timeneeded;
    }
}


