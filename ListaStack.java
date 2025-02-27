public class ListaStack<T> implements IStack<T> {
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
}
