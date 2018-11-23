package main.model;


public class RegularAssignment extends Assignment {


    public RegularAssignment(int number, String content, String course, String type, String date, double timeneeded)  {
        super(number, content, course, type, date, timeneeded);
    }



    @Override
    public String toString() {
        return "Regular Assignment" +"\n" +
                messagePrinter.printcontent();
    }






}








