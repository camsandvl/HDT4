/**
 * Emily Góngora, Camila Sandoval, Ale Sierra
 * 
 * Ejecuta el stack de tipo vector y implementa la interfaz IStack
 * 
 */
import java.util.Vector;

public class VectorStack<T> implements IStack<T> {
    private Vector<T> stack = new Vector<>();

    @Override
    public void push(T item) {
        stack.add(item);
    }
    /**
     * se usa un runtime exception para verificar si el stack esta vacio, en este caso, y verifica excepciones 
     * que pueden ocurrir al ejectuar
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
