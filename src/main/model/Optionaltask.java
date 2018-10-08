package main.model;

public class Optionaltask extends Task {
    public Optionaltask(int number, String content, String course, String type, String date, int timeneeded) {
        super(number, content, course, type, date, timeneeded);
    }


    @Override
    public String toString() {
        return "Optionaltask{" +
                "number=" + number +
                ", content='" + content + '\'' +
                ", course='" + course + '\'' +
                ", date='" + date + '\'' +
                ", type='" + type + '\'' +
                ", timeneeded=" + timeneeded +
                '}';
    }

    @Override
    public String complete() {
        String optionalstring ="The optional task has been completed.";
        System.out.println(optionalstring);
        return optionalstring;
    }

    @Override
    public String setreminder() {
        String s3 ="You still have optional tasks to do";
        System.out.println(s3);
        return s3;
    }
}
