import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTest {
    private IStack<Integer> arrayListStack;
    private IStack<Integer> vectorStack;
    private IStack<Integer> listaStack;

    @BeforeEach
    void setUp() {
        arrayListStack = new ArrayListStack<>();
        vectorStack = new VectorStack<>();
        listaStack = new ListaStack<>();
    }

    @Test
    void testPushAndPeek() {
        arrayListStack.push(10);
        vectorStack.push(20);
        listaStack.push(30);

        assertEquals(10, arrayListStack.peek());
        assertEquals(20, vectorStack.peek());
        assertEquals(30, listaStack.peek());
    }

    @Test
    void testPop() {
        arrayListStack.push(5);
        vectorStack.push(15);
        listaStack.push(25);

        assertEquals(5, arrayListStack.pop());
        assertEquals(15, vectorStack.pop());
        assertEquals(25, listaStack.pop());

        assertTrue(arrayListStack.isEmpty());
        assertTrue(vectorStack.isEmpty());
        assertTrue(listaStack.isEmpty());
    }

    @Test
    void testIsEmpty() {
        assertTrue(arrayListStack.isEmpty());
        assertTrue(vectorStack.isEmpty());
        assertTrue(listaStack.isEmpty());

        arrayListStack.push(1);
        vectorStack.push(2);
        listaStack.push(3);

        assertFalse(arrayListStack.isEmpty());
        assertFalse(vectorStack.isEmpty());
        assertFalse(listaStack.isEmpty());
    }

    @Test
    void testMultiplePushPop() {
        arrayListStack.push(1);
        arrayListStack.push(2);
        arrayListStack.push(3);

        vectorStack.push(4);
        vectorStack.push(5);
        vectorStack.push(6);

        listaStack.push(7);
        listaStack.push(8);
        listaStack.push(9);

        assertEquals(3, arrayListStack.pop());
        assertEquals(2, arrayListStack.pop());
        assertEquals(1, arrayListStack.pop());
        assertTrue(arrayListStack.isEmpty());

        assertEquals(6, vectorStack.pop());
        assertEquals(5, vectorStack.pop());
        assertEquals(4, vectorStack.pop());
        assertTrue(vectorStack.isEmpty());

        assertEquals(9, listaStack.pop());
        assertEquals(8, listaStack.pop());
        assertEquals(7, listaStack.pop());
        assertTrue(listaStack.isEmpty());
    }
}

