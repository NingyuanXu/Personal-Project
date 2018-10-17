package tests;


import exceptions.ItemNotThereException;
import exceptions.NegativeNumberException;
import exceptions.TooManyThingsToDoException;
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
        ByteArrayInputStream in = new ByteArrayInputStream("1\ns\ns\ns\ns\ns\n3\np\n".getBytes());
        System.setIn(in);
        try {
            todo = new AssignmentTodo(false);
        } catch (Exception e) {

        }
        try {
            try {
                todo.addregulartask();
            } catch (NegativeNumberException e) {
                e.printStackTrace();
            }
        } catch (TooManyThingsToDoException e) {
            fail("No exceptions thrown!");
        }
        assertEquals(todo.todoList.size(), 1);

    }

    @Test

    public void testAddOptionalTask() {
        ByteArrayInputStream in = new ByteArrayInputStream("3\ns\ns\ns\ns\ns\n3\np\n".getBytes());
        System.setIn(in);
        try {
            todo = new AssignmentTodo(false);
        } catch (Exception e) {

        }
        try {
            try {
                todo.addoptionaltask();
            } catch (NegativeNumberException e) {
                e.printStackTrace();
            }
        } catch (TooManyThingsToDoException e) {
            fail("No exceptions thrown!");
        }
        assertEquals(todo.todoList.size(), 1);

    }

//    @Test
//
//    public void testAddUrgentTask() {
//        ByteArrayInputStream in = new ByteArrayInputStream("2\ns\ns\ns\ns\ns\ns\n2\n2\n2\n".getBytes());
//        System.setIn(in);
//        try {
//            todo = new AssignmentTodo(false);
//        } catch (Exception e) {
//
//        }
//        try {
//            try {
//                todo.addurgentrtask();
//            } catch (NegativeNumberException e) {
//                e.printStackTrace();
//            }
//        } catch (TooManyThingsToDoException e) {
//            fail("No exceptions thrown!");
//        }
//        assertEquals(todo.todoList.size(), 1);
//
//    }

    @Test

    public void testAddRegularTaskNegativeNumberForTimeneeded() {
        ByteArrayInputStream in = new ByteArrayInputStream("1\ns\ns\ns\ns\ns\n-3\np\n".getBytes());
        System.setIn(in);
        try {
            todo = new AssignmentTodo(false);
        } catch (Exception e) {

        }
        try {
            try {
                todo.addregulartask();
                fail("Exceptions Thrown!");
            } catch (NegativeNumberException e) {

            }
        } catch (TooManyThingsToDoException e) {
            fail("No exceptions thrown!");
        }
        assertEquals(todo.todoList.size(), 0);

    }

    @Test

    public void testRemoveTaskItemFound() {
        ByteArrayInputStream in = new ByteArrayInputStream("1\ns\ns\ns\ns\ns\n3\np\n".getBytes());
        System.setIn(in);
        try {
            todo = new AssignmentTodo(false);
        } catch (Exception e) {

        }
        try {
            try {
                todo.addregulartask();
            } catch (NegativeNumberException e) {
                fail("No exceptions thrown!");
            }
        } catch (TooManyThingsToDoException e) {
            fail("No exceptions thrown!");
        }

        assertEquals(todo.todoList.size(), 1);
        try {
            todo.removetask(1);
        } catch (ItemNotThereException e) {
            fail("No exceptions");
        }
        assertEquals(todo.todoList.size(), 0);
    }

    @Test

    public void testRemoveTaskItemNotFound() {
        ByteArrayInputStream in = new ByteArrayInputStream("1\ns\ns\ns\ns\ns\n3\np\n".getBytes());
        System.setIn(in);
        try {
            todo = new AssignmentTodo(false);
        } catch (Exception e) {

        }
        try {
            try {
                todo.addregulartask();
            } catch (NegativeNumberException e) {
                fail("No exceptions thrown!");
            }
        } catch (TooManyThingsToDoException e) {
            fail("No exceptions thrown!");
        }

        assertEquals(todo.todoList.size(), 1);
        try {
            todo.removetask(2);
            fail("Exception!");
        } catch (ItemNotThereException e) {

        }
        assertEquals(todo.todoList.size(), 1);
    }

    @Test

    public void testRetrieveTaskItemFound() {
        ByteArrayInputStream in = new ByteArrayInputStream("1\ns\ns\ns\ns\ns\n3\np\n".getBytes());
        System.setIn(in);
        try {
            todo = new AssignmentTodo(false);
        } catch (Exception e) {

        }
        try {
            try {
                todo.addregulartask();
            } catch (NegativeNumberException e) {
                fail("No exceptions thrown!");
            }
        } catch (TooManyThingsToDoException e) {
            fail("No exceptions thrown!");
        }

        assertEquals(todo.todoList.size(), 1);
        try {
            todo.removetask(1);
        } catch (ItemNotThereException e) {
            fail("No exceptions thrown!");
        }
        assertEquals(todo.todoList.size(), 0);
        try {
            todo.retrievetask(1);
        } catch (ItemNotThereException e) {
            fail("No exceptions thrown!");
        }
        assertEquals(todo.crossoffList.size(), 0);
        assertEquals(todo.todoList.size(), 1);


    }

    @Test

    public void testRetrieveTaskItemNotFound() {
        ByteArrayInputStream in = new ByteArrayInputStream("1\ns\ns\ns\ns\ns\n3\np\n".getBytes());
        System.setIn(in);
        try {
            todo = new AssignmentTodo(false);
        } catch (Exception e) {

        }
        try {
            try {
                todo.addregulartask();
            } catch (NegativeNumberException e) {
                fail("No exceptions thrown!");
            }
        } catch (TooManyThingsToDoException e) {
            fail("No exceptions thrown!");
        }

        assertEquals(todo.todoList.size(), 1);
        try {
            todo.removetask(1);

        } catch (ItemNotThereException e) {
            fail("");
        }
        assertEquals(todo.todoList.size(), 0);
        try {
            todo.retrievetask(2);
            fail("");
        } catch (ItemNotThereException e) {

        }
        assertEquals(todo.crossoffList.size(), 1);
        assertEquals(todo.todoList.size(), 0);


    }


//    @Test
//
//    public void testAddUrgentTaskNegativeNumberForTLevelOfUrgency() {
//        ByteArrayInputStream in = new ByteArrayInputStream("2\ns\ns\ns\ns\ns\n3\np\n-3\n4\n".getBytes());
//        System.setIn(in);
//        try {
//            todo = new AssignmentTodo(false);
//        } catch (Exception e) {
//
//        }
//        try {
//            try {
//                todo.addurgentrtask();
//                fail("Exceptions Thrown!");
//            } catch (NegativeNumberException e) {
//
//            }
//        } catch (TooManyThingsToDoException e) {
//            fail("No exceptions thrown!");
//        }
//        assertEquals(todo.todoList.size(), 0);
//
//    }
//
//    @Test
//
//    public void testAddUrgentTaskNegativeNumberForPercentageOfWeight() {
//        ByteArrayInputStream in = new ByteArrayInputStream("2\ns\ns\ns\ns\ns\n3\np\n3\n-4\n".getBytes());
//        System.setIn(in);
//        try {
//            todo = new AssignmentTodo(false);
//        } catch (Exception e) {
//
//        }
//        try {
//            try {
//                todo.addurgentrtask();
//                fail("Exceptions Thrown!");
//            } catch (NegativeNumberException e) {
//
//            }
//        } catch (TooManyThingsToDoException e) {
//            fail("No exceptions thrown!");
//        }
//        assertEquals(todo.todoList.size(), 0);
//
//    }
//    @Test
//
//    public void testAddRegularTaskTooManyTasksToDo() {
//        ByteArrayInputStream in = new ByteArrayInputStream("1\ns\ns\ns\ns\ns\n3\np\n3\n4\n1\ns\ns\ns\ns\ns\n3\np\n3\n4\n1\ns\ns\ns\ns\ns\n3\np\n3\n4\n1\ns\ns\ns\ns\ns\n3\np\n3\n4\n1\ns\ns\ns\ns\ns\n3\np\n3\n4\n".getBytes());
//        try {
//            todo = new AssignmentTodo(false);
//        } catch (Exception e) {
//
//        }
//        try {
//            todo.addregulartask();
//            fail("Exceptions are caught");
//        } catch (TooManyThingsToDoException e) {
//
//        }
//        assertEquals(todo.todoList.size(), 5);
//
//    }
}





