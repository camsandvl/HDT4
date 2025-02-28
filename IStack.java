/**
    Emily Góngora, Camila Sandoval, Ale Sierra
<<<<<<< HEAD
    Interfaz que define los métodos que debe tener un stack
=======
    Interfaz q define los métodos que debe tener un stack
>>>>>>> 3d3bd9b12ec2418b277e584f577fa2cbaba9f950
*/
public interface IStack<T> {
    void push(T item);
    T pop();
    T peek();
    boolean isEmpty();
    int size();
}

