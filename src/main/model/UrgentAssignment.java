package main.model;

public class UrgentAssignment extends Assignment {

    private int levelofurgency;
    private int percentageofweight;



    public UrgentAssignment(int number, String content, String course, String type, String date, double timeneeded, int levelofurgency,int percentageofweight) {
        super(number, content, course, type, date, timeneeded);
        this.levelofurgency = levelofurgency;
        this.percentageofweight = percentageofweight;
    }



    @Override
    public String toString() {
        return "Urgent Assignment  " +
                messagePrinter.printcontent() +
            "Level of urgency: " + levelofurgency +"  "+
            "Percentage of weight: " + percentageofweight;
}



    public void setLevelofurgency(int levelofurgency) {
        this.levelofurgency = levelofurgency;
    }


    public void setPercentageofweight(int percentageofweight) {
        this.percentageofweight = percentageofweight;
    }



}
