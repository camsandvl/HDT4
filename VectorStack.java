/**
 * Emily Góngora, Camila Sandoval, Ale Sierra
 * 
<<<<<<< HEAD
 * Clase que ejecuta el stack de tipo vector, implementa la interfaz IStack
=======
 * Ejecuta el stack de tipo vector y implementa la interfaz IStack
>>>>>>> 3d3bd9b12ec2418b277e584f577fa2cbaba9f950
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
<<<<<<< HEAD
     * que pueden ocurrir al ejectuar el programa
=======
     * que pueden ocurrir al ejectuar
>>>>>>> 3d3bd9b12ec2418b277e584f577fa2cbaba9f950
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
<<<<<<< HEAD

    @Override
    public int size() {
        return stack.size();
    }
}
=======
>>>>>>> 3d3bd9b12ec2418b277e584f577fa2cbaba9f950

    @Override
    public int size() {
        return stack.size();
    }
}
