package main.model;


import exceptions.ItemNotThereException;
import exceptions.NegativeNumberException;
import exceptions.TooManyThingsToDoException;
import implementations.Loadable;
import implementations.Savable;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Files.readAllLines;


public class Operation implements Loadable, Savable {
    public final CrossoffList crossoffList = new CrossoffList(this);
    public final TodoList todoList = new TodoList(this);

    public Operation(boolean load) throws IOException {
        if (load) {
            List<String> lines = readAllLines(Paths.get("outputfile.txt"));
            if (lines.size() > 0) {
                todoList.Number = Integer.parseInt(lines.get(0));
                lines.remove(0);
            }

            String currentClass = "";
            ArrayList<String> temp = new ArrayList<>();
            for (String s : lines) {
                if (s.equals("Regulartask") || s.equals("Optionaltask") || s.equals("Urgenttask")) {
                    todoList.buildTask(currentClass, temp);
                    currentClass = s;
                    temp = new ArrayList<>();
                } else {
                    temp.add(s);
                }
            }
            todoList.buildTask(currentClass, temp);
        }

    }


    private void buildTask(String currentClass, ArrayList<String> temp) {
        todoList.buildTask(currentClass, temp);
    }


    //REQUIRES: An integer smaller than the size of crossoffList;
    //MODIFIES: this
    //EFFECTS: delete the task with same number as the parameter from todolist, and add it to the crossofflist; print out the statement as the operation is done;
    // print"The item you selected has been deleted from the todolist" if item was found
    //print "ITEM NOT FOUND!" if there is no item with the number matching to the parameter

    public void removetask(int Number) throws ItemNotThereException {

        todoList.removetask(Number);
    }


    //REQUIRES: An integer smaller than the size of crossoffList; a non-empty crossoffList
    //MODIFIES: this
    //EFFECTS: delete the task with the same number as the parameter from the crossoffList and add it to the todolist; print out the statement when the operation is done; then break;
    public void retrievetask(int Number) throws ItemNotThereException {


        crossoffList.retrievetask(Number);
    }


    //MODIFIES: Regulartask t,this
    //EFFECTS: create a new regular task t
    // then add the regular task t into todoList

    public void addregulartask() throws TooManyThingsToDoException, NegativeNumberException, IOException {
        todoList.addregulartask();
    }

    //MODIFIES: Urgenttask t,this
    //EFFECTS: create a new urgent task t
    // then add the urgent task t into todoList

    public void addurgentrtask() throws TooManyThingsToDoException, NegativeNumberException, IOException {
        todoList.addurgentrtask();
    }

    //MODIFIES: Optionaltask t,this
    //EFFECTS: create a new optional task t
    // then add the optional task t into todoList

    public void addoptionaltask() throws TooManyThingsToDoException, NegativeNumberException, IOException {
        todoList.addoptionaltask();
    }


    @Override
    public void load() {

    }

    @Override
    public void save() {

    }

    public List<Task> getTodoList() {
        return todoList.getTodoList();
    }

    public CrossoffList getCrossoffList() {
        return crossoffList;
    }
}




