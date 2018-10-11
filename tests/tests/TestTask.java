package tests;

import main.model.Regulartask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTask {

    int Number = 1;
    private Regulartask regulartask;

    @BeforeEach
    public void runBefore() {
        regulartask = new Regulartask(Number, "", "", "", "", Number);
    }

    @Test

    public void testConstructor() {
        Regulartask regulartask = new Regulartask(1, "Webwork3", "Math200", "Webwork", "2018.8.29 11:59pm", 5);
        assertEquals(regulartask.getNumber(), 1);
        assertEquals(regulartask.getContent(), "Webwork3");
        assertEquals(regulartask.getCourse(), "Math200");
        assertEquals(regulartask.getType(), "Webwork");
        assertEquals(regulartask.getDate(), "2018.8.29 11:59pm");
        assertEquals(regulartask.getTimeneeded(), 5);
        
    }
    @Test

    public void testGetNumber() {
        regulartask.setNumber(1);

        assertTrue(regulartask.getNumber() == 1);
    }

    @Test

    public void testGetContent() {
        regulartask.setContent("Webwork 3");

        assertTrue(regulartask.getContent() == "Webwork 3");
    }


    @Test

    public void testGetCourse() {
        regulartask.setCourse("Math200");

        assertTrue(regulartask.getCourse() == "Math200");
    }

    @Test

    public void testGetType() {
        regulartask.setType("Webwork");

        assertTrue(regulartask.getType() == "Webwork");
    }


    @Test

    public void testGetDate() {
        regulartask.setDate("2018.8.29 11:59pm");

        assertTrue(regulartask.getDate() == "2018.8.29 11:59pm");
    }


    @Test

    public void testGetTimeneeded() {
        regulartask.setTimeneeded(5);

        assertTrue(regulartask.getTimeneeded() == 5);
    }

    @Test

    public void testSetNumber() {
        regulartask.setNumber(2);

        assertTrue(regulartask.getNumber() == 2);
    }

    @Test

    public void testSetContent() {
        regulartask.setContent("Webwork 3");

        assertTrue(regulartask.getContent() == "Webwork 3");
    }


    @Test

    public void testSetCourse() {
        regulartask.setCourse("Math200");

        assertTrue(regulartask.getCourse() == "Math200");
    }

    @Test

    public void testSetType() {
        regulartask.setType("Webwork");

        assertTrue(regulartask.getType() == "Webwork");
    }


    @Test

    public void testSetDate() {
        regulartask.setDate("2018.8.29 11:59pm");

        assertTrue(regulartask.getDate() == "2018.8.29 11:59pm");
    }


    @Test

    public void testSetTimeneeded() {
        regulartask.setTimeneeded(5);

        assertTrue(regulartask.getTimeneeded() == 5);
    }



}

