package tests;

import main.model.RegularAssignment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestAssignment {

    int Number = 1;
    private RegularAssignment regularAssignment;

    @BeforeEach
    public void runBefore() throws IOException {
        regularAssignment = new RegularAssignment(Number, "", "", "", "", Number);
    }

    @Test

    public void testConstructor() throws IOException {
        RegularAssignment regularAssignment = new RegularAssignment(1, "Webwork3", "Math200", "Webwork", "2018.8.29 11:59pm", 5);
        assertEquals(regularAssignment.getNumber(), 1);
        assertEquals(regularAssignment.getContent(), "Webwork3");
        assertEquals(regularAssignment.getCourse(), "Math200");
        assertEquals(regularAssignment.getType(), "Webwork");
        assertEquals(regularAssignment.getDate(), "2018.8.29 11:59pm");
        assertEquals(regularAssignment.getTimeneeded(), 5);
        
    }
    @Test

    public void testGetNumber() {
        regularAssignment.setNumber(1);

        assertTrue(regularAssignment.getNumber() == 1);
    }

    @Test

    public void testGetContent() {
        regularAssignment.setContent("Webwork 3");

        assertTrue(regularAssignment.getContent() == "Webwork 3");
    }


    @Test

    public void testGetCourse() {
        regularAssignment.setCourse("Math200");

        assertTrue(regularAssignment.getCourse() == "Math200");
    }

    @Test

    public void testGetType() {
        regularAssignment.setType("Webwork");

        assertTrue(regularAssignment.getType() == "Webwork");
    }


    @Test

    public void testGetDate() {
        regularAssignment.setDate("2018.8.29 11:59pm");

        assertTrue(regularAssignment.getDate() == "2018.8.29 11:59pm");
    }


    @Test

    public void testGetTimeneeded() {
        regularAssignment.setTimeneeded(5);

        assertTrue(regularAssignment.getTimeneeded() == 5);
    }

    @Test

    public void testSetNumber() {
        regularAssignment.setNumber(2);

        assertTrue(regularAssignment.getNumber() == 2);
    }

    @Test

    public void testSetContent() {
        regularAssignment.setContent("Webwork 3");

        assertTrue(regularAssignment.getContent() == "Webwork 3");
    }


    @Test

    public void testSetCourse() {
        regularAssignment.setCourse("Math200");

        assertTrue(regularAssignment.getCourse() == "Math200");
    }

    @Test

    public void testSetType() {
        regularAssignment.setType("Webwork");

        assertTrue(regularAssignment.getType() == "Webwork");
    }


    @Test

    public void testSetDate() {
        regularAssignment.setDate("2018.8.29 11:59pm");

        assertTrue(regularAssignment.getDate() == "2018.8.29 11:59pm");
    }


    @Test

    public void testSetTimeneeded() {
        regularAssignment.setTimeneeded(5);

        assertTrue(regularAssignment.getTimeneeded() == 5);
    }



}

