package main.model;


public class Regulartask extends Task {


    public Regulartask(int number, String content, String course, String type, String date, int timeneeded) {
        super(number, content, course, type, date, timeneeded);
    }

    @Override
    public String complete() {

        String regularstring ="The regular task has been completed.";
        System.out.println(regularstring);
        return regularstring;
    }

    @Override
    public String toString() {
        return "Regulartask{" +
                "number=" + number +
                ", content='" + content + '\'' +
                ", course='" + course + '\'' +
                ", date='" + date + '\'' +
                ", type='" + type + '\'' +
                ", timeneeded=" + timeneeded +
                '}';
    }


    @Override
    public String setreminder() {
        String s2 ="You still have regular tasks to do";
        System.out.println(s2);
        return s2;
    }
}








