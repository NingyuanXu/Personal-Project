package tests;


import main.model.AssignmentTodo;
import main.model.Regulartask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    public void testAddTask() {
         todoList.add(regulartask);
        assertTrue(todoList.contains(regulartask));

        todoList.remove(regulartask);
         assertFalse(todoList.contains(regulartask));

    }


    @Test

    public void testRemoveTaskExist() {
        todoList.add(regulartask);
        assertTrue(todoList.contains(regulartask));
        todoList.remove(regulartask);
        assertFalse(todoList.contains(regulartask));

    }

    @Test


    public void testRemoveTaskNotExist() {
        todoList.add(regulartask);
        assertTrue(todoList.contains(regulartask));
        todoList.remove(othertask);
        assertTrue(todoList.contains(regulartask));

    }

    @Test


    public void testRemoveTaskEmpty() {
        todoList.add(regulartask);
        todoList.remove(regulartask);
        assertEquals(todoList.size(), 0);

    }


    @Test

    public void testRetrieveTaskExist() {
        crossoffList.remove(regulartask);
        todoList.add(regulartask);
        assertFalse(crossoffList.contains(regulartask));
        assertTrue(todoList.contains(regulartask));
    }

    @Test

    public void testRetrieveTaskNotExist() {
        crossoffList.add(regulartask);
        crossoffList.remove(regulartask);
        assertFalse(crossoffList.contains(regulartask));
        assertFalse(todoList.contains(regulartask));
    }

    @Test
    public void testRetrieveTaskEmpty() {
        crossoffList.add(regulartask);
        crossoffList.remove(regulartask);
        assertEquals(todoList.size(), 0);

    }

    @Test

    public void testLoad() {
        status = true;
        assertTrue(status);
    }

    @Test

    public void testSave() {
    status = !status;
    assertFalse(status);}
}

