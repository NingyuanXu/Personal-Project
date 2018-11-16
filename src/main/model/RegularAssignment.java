package main.model;


import java.io.IOException;
import java.util.ArrayList;

public class RegularAssignment extends Assignment {


    public RegularAssignment(int number, String content, String course, String type, String date, double timeneeded) throws IOException {
        super(number, content, course, type, date, timeneeded);
    }

    public RegularAssignment(ArrayList<String> data){
        super(data);
    }


    @Override
    public String toString() {
        return "RegularAssignment" +"\n" +
                messagePrinter.printcontent();
    }


    @Override
    public String setreminder() {
        String s2 = " regular tasks to do"+messagePrinter.setreminder();
        System.out.println(s2);
        return s2;
    }

    @Override
    public String complete() {

        String regularstring = "The regular task "+messagePrinter.complete();
        System.out.println(regularstring);
        return regularstring;
    }

    @Override
    public void print() {

        messagePrinter.print();
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








