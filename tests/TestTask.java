package tests;

import main.model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTask {

    int Number = 1;
    private Task task;

    @BeforeEach
    public void runBefore() {
        task = new Task(Number, "", "", "", "", Number);
    }

    @Test

    public void testConstructor() {
        Task task = new Task(1, "Webwork3", "Math200", "Webwork", "2018.8.29 11:59pm", 5);
        assertEquals(task.getNumber(), 1);
        assertEquals(task.getContent(), "Webwork3");
        assertEquals(task.getCourse(), "Math200");
        assertEquals(task.getType(), "Webwork");
        assertEquals(task.getDate(), "2018.8.29 11:59pm");
        assertEquals(task.getTimeneeded(), 5);
        
    }
    @Test

    public void testGetNumber() {
        task.setNumber(1);

        assertTrue(task.getNumber() == 1);
    }

    @Test

    public void testGetContent() {
        task.setContent("Webwork 3");

        assertTrue(task.getContent() == "Webwork 3");
    }


    @Test

    public void testGetCourse() {
        task.setCourse("Math200");

        assertTrue(task.getCourse() == "Math200");
    }

    @Test

    public void testGetType() {
        task.setType("Webwork");

        assertTrue(task.getType() == "Webwork");
    }


    @Test

    public void testGetDate() {
        task.setDate("2018.8.29 11:59pm");

        assertTrue(task.getDate() == "2018.8.29 11:59pm");
    }


    @Test

    public void testGetTimeneeded() {
        task.setTimeneeded(5);

        assertTrue(task.getTimeneeded() == 5);
    }

    @Test

    public void testSetNumber() {
        task.setNumber(2);

        assertTrue(task.getNumber() == 2);
    }

    @Test

    public void testSetContent() {
        task.setContent("Webwork 3");

        assertTrue(task.getContent() == "Webwork 3");
    }


    @Test

    public void testSetCourse() {
        task.setCourse("Math200");

        assertTrue(task.getCourse() == "Math200");
    }

    @Test

    public void testSetType() {
        task.setType("Webwork");

        assertTrue(task.getType() == "Webwork");
    }


    @Test

    public void testSetDate() {
        task.setDate("2018.8.29 11:59pm");

        assertTrue(task.getDate() == "2018.8.29 11:59pm");
    }


    @Test

    public void testSetTimeneeded() {
        task.setTimeneeded(5);

        assertTrue(task.getTimeneeded() == 5);
    }



}

