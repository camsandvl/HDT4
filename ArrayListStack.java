/**
 * Emily Góngora, Camila Sandoval, Ale Sierra
 * 
 * Clase ejecuta el stack cono un arraylist, implementa la interfaz IStack
 * 
 */
import java.util.ArrayList;

public class ArrayListStack<T> implements IStack<T> {
    private ArrayList<T> stack = new ArrayList<>();

    @Override
    public void push(T item) {
        stack.add(item);
    }
    /**
     * se usa un runtime exception para verificar si el stack esta vacio, en este caso, y verifica excepciones 
     * que pueden ocurrir al ejectuar el programa
     */
    @Override
    public T pop() {
        if (isEmpty()) throw new RuntimeException("Stack vacío");
        return stack.remove(stack.size() - 1);
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new RuntimeException("Stack vacío");
        return stack.get(stack.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int size() {
        return stack.size();
    }
}
