package tests;


import main.model.AssignmentTodo;
import main.model.Regulartask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class TestAssignmentTodo {
    Regulartask regulartask;
    Regulartask othertask;
    AssignmentTodo todo;
    ArrayList<Regulartask> todoList;
    ArrayList<Regulartask> crossoffList;
    private boolean status = true;


    int Number = 1;

    @BeforeEach
    public void runBefore() {

        todoList = new ArrayList<>();
        crossoffList = new ArrayList<>();
        regulartask = new Regulartask(1, "Webwork3", "Math200", "Webwork", "2018.8.29 11:59pm", 5);
        othertask = new Regulartask(2, "Webwork3", "Math200", "Webwork", "2018.8.29 11:59pm", 5);
    }

    @Test

    public void testAddRegularTask() {
        ByteArrayInputStream in = new ByteArrayInputStream("1\ns\ns\ns\n3\np\n".getBytes());
        System.setIn(in);
        try {
            todo = new AssignmentTodo(false);
        } catch (Exception e) {

        }
        todo.addregulartask();
        assertEquals(todo.todoList.size(), 1);

    }

    @Test

    public void testAddOptionalTask() {
        ByteArrayInputStream in = new ByteArrayInputStream("1\ns\ns\ns\n3\np\n".getBytes());
        System.setIn(in);
        try {
            todo = new AssignmentTodo(false);
        } catch (Exception e) {

        }
        todo.addoptionaltask();
        assertEquals(todo.todoList.size(), 1);

    }

    @Test

    public void testAddUrgentTask() {
        ByteArrayInputStream in = new ByteArrayInputStream("1\ns\ns\ns\n3\np\n3\n4\n".getBytes());
        System.setIn(in);
        try {
            todo = new AssignmentTodo(false);
        } catch (Exception e) {

        }
        todo.addoptionaltask();
        assertEquals(todo.todoList.size(), 1);

    }

    @Test

    public void testRemoveTask() {
        ByteArrayInputStream in = new ByteArrayInputStream("1\ns\ns\ns\n3\np\n".getBytes());
        System.setIn(in);
        try {
            todo = new AssignmentTodo(false);
        } catch (Exception e) {

        }
        todo.addregulartask();

        assertEquals(todo.todoList.size(), 1);
        todo.removetask(1);
        assertEquals(todo.todoList.size(), 0);

    }


    @Test

    public void testRetrieveTask() {
        ByteArrayInputStream in = new ByteArrayInputStream("1\ns\ns\ns\n3\np\n".getBytes());
        System.setIn(in);
        try {
            todo = new AssignmentTodo(false);
        } catch (Exception e) {

        }
        todo.addregulartask();

        assertEquals(todo.todoList.size(), 1);
        todo.removetask(1);
        assertEquals(todo.todoList.size(), 0);
        todo.retrievetask(1);
        assertEquals(todo.crossoffList.size(), 0);
        assertEquals(todo.todoList.size(), 1);


    }
}





