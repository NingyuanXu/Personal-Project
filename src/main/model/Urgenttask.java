package main.model;

public class Urgenttask extends Task{

    private int levelofurgency;
    private int percentageofweight;


    public Urgenttask(int number, String content, String course, String type, String date, int timeneeded) {
        super(number, content, course, type, date, timeneeded);
    }


    @Override
    public String complete() {
        String urgentstring ="The urgent task has been completed.";
        System.out.println(urgentstring);
        return urgentstring;
    }


    @Override
    public String toString() {
        return "Urgenttask{ URGENCY!!!" +
                "number=" + number +
                ", content='" + content + '\'' +
                ", course='" + course + '\'' +
                ", date='" + date + '\'' +
                ", type='" + type + '\'' +
                ", timeneeded=" + timeneeded +
                '}';
    }

    public int getLevelofurgency() {
        return levelofurgency;
    }

    public void setLevelofurgency(int levelofurgency) {
        this.levelofurgency = levelofurgency;
    }

    public int getPercentageofweight() {
        return percentageofweight;
    }

    public void setPercentageofweight(int percentageofweight) {
        this.percentageofweight = percentageofweight;
    }


    @Override
    public String setreminder() {
        String s3 ="You still have urgent tasks to do. Please do it AS SOON AS POSSIBLE!!!";
        System.out.println(s3);
        return s3;
    }
}
