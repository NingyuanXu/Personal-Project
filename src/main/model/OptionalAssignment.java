package main.model;

public class OptionalAssignment extends Assignment {
    public OptionalAssignment(int number, String content, String course, String type, String date, double timeneeded)  {
        super(number, content, course, type, date, timeneeded);
    }


    @Override
    public String toString() {
        return "Optional Assignment  "+

                messagePrinter.printcontent();
    }




}
