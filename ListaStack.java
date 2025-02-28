/**
 * Emily Góngora, Camila Sandoval, Ale Sierra
 * 
 * Clase que ejecuta el stack de tipo lista, implementa la interfaz IStack
 */
public class ListaStack<T> implements IStack<T> {
     /**
     * Clase interna que representa un nodo en la lista enlazada.
     */
    private class Nodo {
        T data;
        Nodo next;

        Nodo(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Nodo head;

    @Override
    public void push(T item) {
        Nodo newNode = new Nodo(item);
        newNode.next = head;
        head = newNode;
    }
     /**
     * se usa un runtime exception para verificar si el stack esta vacio, en este caso, y verifica excepciones 
     * que pueden ocurrir al ejectuar el programa
     */
    @Override
    public T pop() {
        if (isEmpty()) throw new RuntimeException("Stack vacío");
        T data = head.data;
        head = head.next;
        return data;
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new RuntimeException("Stack vacío");
        return head.data;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        int count = 0;
        Nodo current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}
