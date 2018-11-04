package main.model;


import java.io.IOException;
import java.util.ArrayList;

public class Regulartask extends Task {


    public Regulartask(int number, String content, String course, String type, String date, double timeneeded) throws IOException {
        super(number, content, course, type, date, timeneeded);
    }

    public Regulartask(ArrayList<String> data){
        super(data);
    }


    @Override
    public String toString() {
        return "Regulartask" +"\n" +
                messagePrinter.printcontent();
    }


    @Override
    public String setreminder() {
        String s2 = "You still have regular tasks to do";
        System.out.println(s2);
        return s2;
    }

    @Override
    public String complete() {

        String regularstring = "The regular task has been completed.";
        System.out.println(regularstring);
        return regularstring;
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
            }
        }
    }


    @Override
    public void load() {

    }
}








