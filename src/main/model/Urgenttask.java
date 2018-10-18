package main.model;

import java.util.ArrayList;

public class Urgenttask extends Task {

    private int levelofurgency;
    private int percentageofweight;


    public Urgenttask(int number, String content, String course, String type, String date, int number1, int i, double timeneeded) {
        super(number, content, course, type, date, timeneeded);
    }

    public Urgenttask(int number, String content, String course, String type, String date, double timeneeded, int levelofurgency) {
        super(number, content, course, type, date, timeneeded);
        this.levelofurgency = levelofurgency;
        this.percentageofweight = percentageofweight;
    }

    public Urgenttask(ArrayList<String> data){
        super(data);
    }


    @Override
    public String toString() {
        return "Urgenttask" +"\n"+
                printcontent()+
            "levelofurgency: " + levelofurgency +"\n"+
            "percentageofweight: " + percentageofweight +"\n";
}

    @Override
    public String complete() {
        String urgentstring = "The urgent task has been completed.";
        System.out.println(urgentstring);
        return urgentstring;
    }

    @Override
    public String setreminder() {
        String s3 = "You still have urgent tasks to do. Please do it AS SOON AS POSSIBLE!!!";
        System.out.println(s3);
        return s3;
    }



    public void setLevelofurgency(int levelofurgency) {
        this.levelofurgency = levelofurgency;
    }



    public void setPercentageofweight(int percentageofweight) {
        this.percentageofweight = percentageofweight;
    }

    @Override
    protected void load(ArrayList<String> data) {
        for(String s: data){
            if(s.startsWith("number")){
                number = Integer.parseInt(s.substring(8));
            }else if(s.startsWith("content")){
                content = s.substring(9);
            }else if(s.startsWith("course")){
                course = s.substring(8);
            }else if(s.startsWith("date")){
                date = s.substring(6);
            }else if(s.startsWith("type")){
                type = s.substring(6);
            }else if(s.startsWith("timeneeded")){
                timeneeded = Double.parseDouble(s.substring(12));
            }else if(s.startsWith("levelofurgency")){
                levelofurgency = Integer.parseInt(s.substring(16));
            }else if(s.startsWith("percentageofweight")){
                percentageofweight = Integer.parseInt(s.substring(20));
            }
        }
    }

    @Override
    public void load() {

    }
}
