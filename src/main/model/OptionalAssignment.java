package main.model;

import java.io.IOException;
import java.util.ArrayList;

public class OptionalAssignment extends Assignment {
    public OptionalAssignment(int number, String content, String course, String type, String date, double timeneeded) throws IOException {
        super(number, content, course, type, date, timeneeded);
    }
    public OptionalAssignment(ArrayList<String> data){
        super(data);
    }


    @Override
    public String toString() {
        return "OptionalAssignment" +"\n"+

                messagePrinter.printcontent();
    }



    @Override
    public String complete() {
        String optionalstring = "The optional task "+messagePrinter.complete();
        System.out.println(optionalstring);
        return optionalstring;
    }

    @Override
    public void print() {
        messagePrinter.print();
    }

    @Override
    public String setreminder() {
        String s3 = " optional tasks to do"+messagePrinter.setreminder();
        System.out.println(s3);
        return s3;
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
