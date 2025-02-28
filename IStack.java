/**
    Emily Góngora, Camila Sandoval, Ale Sierra
    Interfaz q define los métodos que debe tener un stack
*/
public interface IStack<T> {
    void push(T item);
    T pop();
    T peek();
    boolean isEmpty();
    int size();
}

