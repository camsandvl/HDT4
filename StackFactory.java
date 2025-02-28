/**
 * Emily Góngora, Camila Sandoval, Ale Sierra
 * 
 * Clase que permite al usuario seleccionar la implementación del Stack, lee el nombre del stack que desea el usuario
 *  y si no es valido tira un mensaje
 * 
 */
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
