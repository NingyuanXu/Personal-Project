package tests;


import exceptions.ItemNotThereException;
import exceptions.NegativeNumberException;
import exceptions.TooManyThingsToDoException;
import main.model.Operation;
import main.model.Regulartask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class TestOperation {
    Regulartask regulartask;
    Regulartask othertask;
    Operation todo;
    ArrayList<Regulartask> todoList;
    ArrayList<Regulartask> crossoffList;
    private boolean status = true;


    int Number = 1;

    @BeforeEach
    public void runBefore() throws IOException {

        todoList = new ArrayList<>();
        crossoffList = new ArrayList<>();
        regulartask = new Regulartask(1, "Webwork3", "Math200", "Webwork", "2018.8.29 11:59pm", 5);
        othertask = new Regulartask(2, "Webwork3", "Math200", "Webwork", "2018.8.29 11:59pm", 5);
    }

    @Test

    public void testAddRegularTask() throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream("1\ns\ns\ns\n3\np\n".getBytes());
        System.setIn(in);
        try {
            todo = new Operation(false);
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
        assertEquals(todo.todoList.getTodoList().size(), 1);

    }

    @Test

    public void testAddOptionalTask() throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream("3\ns\ns\ns\n3\np\n".getBytes());
        System.setIn(in);
        try {
            todo = new Operation(false);
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
        assertEquals(todo.todoList.getTodoList().size(), 1);

    }

    @Test

    public void testAddUrgentTask() throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream("2\ns\ns\ns\n2\n6\n3\n3\ns\n".getBytes());
        System.setIn(in);
        try {
            todo = new Operation(false);
        } catch (Exception e) {

        }
        try {
            try {
                todo.addurgentrtask();
            } catch (NegativeNumberException e) {
                e.printStackTrace();
            }
        } catch (TooManyThingsToDoException e) {
            fail("No exceptions thrown!");
        }
        assertEquals(todo.todoList.getTodoList().size(), 1);

    }

    @Test

    public void testAddRegularTaskNegativeNumberForTimeneeded() throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream("1\ns\ns\ns\n-3\np\n".getBytes());
        System.setIn(in);
        try {
            todo = new Operation(false);
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
        assertEquals(todo.todoList.getTodoList().size(), 0);

    }

    @Test

    public void testRemoveTaskItemFound() throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream("1\ns\ns\ns\n3\np\n".getBytes());
        System.setIn(in);
        try {
            todo = new Operation(false);
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

        assertEquals(todo.todoList.getTodoList().size(), 1);
        try {
            todo.removetask(1);
        } catch (ItemNotThereException e) {
            fail("No exceptions");
        }
        assertEquals(todo.todoList.getTodoList().size(), 0);
    }

    @Test

    public void testRemoveTaskItemNotFound() throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream("1\ns\ns\ns\n3\np\n".getBytes());
        System.setIn(in);
        try {
            todo = new Operation(false);
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

        assertEquals(todo.todoList.getTodoList().size(), 1);
        try {
            todo.removetask(2);
            fail("Exception!");
        } catch (ItemNotThereException e) {

        }
        assertEquals(todo.todoList.getTodoList().size(), 1);
    }

    @Test

    public void testRetrieveTaskItemFound() throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream("1\ns\ns\ns\n3\np\n".getBytes());
        System.setIn(in);
        try {
            todo = new Operation(false);
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

        assertEquals(todo.todoList.getTodoList().size(), 1);
        try {
            todo.removetask(1);
        } catch (ItemNotThereException e) {
            fail("No exceptions thrown!");
        }
        assertEquals(todo.todoList.getTodoList().size(), 0);
        try {
            todo.retrievetask(1);
        } catch (ItemNotThereException e) {
            fail("No exceptions thrown!");
        }
        assertEquals(todo.crossoffList.crossoffList.size(), 0);
        assertEquals(todo.todoList.getTodoList().size(), 1);


    }

    @Test

    public void testRetrieveTaskItemNotFound() throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream("1\ns\ns\ns\n3\np\n".getBytes());
        System.setIn(in);
        try {
            todo = new Operation(false);
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

        assertEquals(todo.todoList.getTodoList().size(), 1);
        try {
            todo.removetask(1);

        } catch (ItemNotThereException e) {
            fail("");
        }
        assertEquals(todo.todoList.getTodoList().size(), 0);
        try {
            todo.retrievetask(2);
            fail("");
        } catch (ItemNotThereException e) {

        }
        assertEquals(todo.crossoffList.crossoffList.size(), 1);
        assertEquals(todo.todoList.getTodoList().size(), 0);


    }


    @Test

    public void testAddUrgentTaskNegativeNumberForTLevelOfUrgency() throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream("2\ns\ns\ns\n2\n-6\n3\n3\ns\n".getBytes());
        System.setIn(in);
        try {
            todo = new Operation(false);
        } catch (Exception e) {

        }
        try {
            try {
                todo.addurgentrtask();
                fail("Exceptions Thrown!");
            } catch (NegativeNumberException e) {

            }
        } catch (TooManyThingsToDoException e) {
            fail("No exceptions thrown!");
        }
        assertEquals(todo.todoList.getTodoList().size(), 0);

    }

    @Test

    public void testAddUrgentTaskNegativeNumberForPercentageOfWeight() throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream("2\ns\ns\ns\n2\n6\n-3\n3\ns\n".getBytes());
        System.setIn(in);
        try {
            todo = new Operation(false);
        } catch (Exception e) {

        }
        try {
            try {
                todo.addurgentrtask();
                fail("Exceptions Thrown!");
            } catch (NegativeNumberException e) {

            }
        } catch (TooManyThingsToDoException e) {
            fail("No exceptions thrown!");
        }
        assertEquals(todo.todoList.getTodoList().size(), 0);

    }
    @Test

    public void testAddRegularTaskTooManyTasksToDo() throws IOException {
        try {
            todo = new Operation(false);
        } catch (Exception e) {

        }
        for(int i =0; i<10; i++) {
            try {
                addRegularTask(todo);
            } catch (NegativeNumberException e) {
                e.printStackTrace();
            }catch (TooManyThingsToDoException e) {
                fail("No exceptions thrown!");
            }
        }
        assertEquals(todo.todoList.getTodoList().size(), 1);

        try {
            addRegularTask(todo);

        }catch (TooManyThingsToDoException e){
            fail("llll");

        }catch (NegativeNumberException e){
            fail("hhhh");

        }


    }

    private void addRegularTask(Operation todo) throws TooManyThingsToDoException, NegativeNumberException, IOException {
        ByteArrayInputStream in = new ByteArrayInputStream("1\ns\ns\ns\n3\np\n".getBytes());
        System.setIn(in);
        todo.addregulartask();

        }
}





