package tests;


import main.model.AssignmentTodo;
import main.model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestAssignmentTodo {
    Task task;
    Task othertask;
    AssignmentTodo todo;
    ArrayList<Task> todoList;
    ArrayList<Task> crossoffList;


    int Number = 1;

    @BeforeEach
    public void runBefore() {
        todoList = new ArrayList<>();
        crossoffList = new ArrayList<>();
        task = new Task(1, "Webwork3", "Math200", "Webwork", "2018.8.29 11:59pm", 5);
        othertask = new Task(2, "Webwork3", "Math200", "Webwork", "2018.8.29 11:59pm", 5);

    }

    @Test

    public void testAddTask() {
        todoList.add(task);
        assertTrue(todoList.contains(task));
        todoList.remove(task);
        assertFalse(todoList.contains(task));

    }



    @Test

    public void testRemoveTaskExist() {
        todoList.add(task);
        assertTrue(todoList.contains(task));
        todoList.remove(task);
        assertFalse(todoList.contains(task));

    }

    @Test


    public void testRemoveTaskNotExist() {
        todoList.add(task);
        assertTrue(todoList.contains(task));
        todoList.remove(othertask);
        assertTrue(todoList.contains(task));

    }

    @Test


    public void testRemoveTaskEmpty() {
        todoList.add(task);
        todoList.remove(task);
        assertEquals(todoList.size(),0);

    }



    @Test

    public void testRetrieveTaskExist() {
        crossoffList.remove(task);
        todoList.add(task);
        assertFalse(crossoffList.contains(task));
        assertTrue(todoList.contains(task));
    }

    @Test

    public void testRetrieveTaskNotExist() {
        crossoffList.add(task);
        crossoffList.remove(task);
        assertFalse(crossoffList.contains(task));
        assertFalse(todoList.contains(task));
    }

    @Test
    public void testRetrieveTaskEmpty() {
        crossoffList.add(task);
        crossoffList.remove(task);
        assertEquals(todoList.size(),0);

    }

}
