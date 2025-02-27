public class StackFactory {
    public static <T> IStack<T> getStack(String tipo) {
        switch (tipo.toLowerCase()) {
            case "arraylist":
                return new ArrayListStack<>();
            case "vector":
                return new VectorStack<>();
            case "lista":
                return new ListaStack<>();
            default:
                throw new IllegalArgumentException("Tipo de stack no válido");
        }
    }
}
