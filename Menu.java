/**
 * Emily Góngora, Camila Sandoval, Ale Sierra
 * 
 * Esta clase permite al usuario seleccionar la implementación del Stack,
 * leer una expresión infix desde un archivo, convertirla a postfix y 
 * evaluar el resultado utilizando una calculadora.
 *depende de calculadora, istack y stackfactory
 * 
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    private Calculadora calculadora;
    private IStack<Integer> stack;

    public Menu() {
        this.calculadora = Calculadora.getInstance();
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Seleccione la implementación del Stack: arraylist, vector, lista");
            String tipoStack = scanner.nextLine();

            this.stack = StackFactory.getStack(tipoStack);
            try {
                String expresion = leerArchivo("C:\\Users\\males\\OneDrive\\Escritorio\\programas 2\\HDT4\\HDT4\\datos.txt");

                System.out.println("Expresión infix: " + expresion);
                String postfix = calculadora.infixToPostfix(expresion);
                System.out.println("Expresión postfix: " + postfix);
                System.out.println("Resultado: " + calculadora.evaluacionPostfix(postfix));
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }
            System.out.println("¿Desea realizar otra operación? (s/n)");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("n")) {
                continuar = false;
            }
        }
        scanner.close();
    }

    public String leerArchivo(String ruta) throws IOException {
        StringBuilder contenido = new StringBuilder();
        
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\males\\OneDrive\\Escritorio\\programas 2\\HDT4\\HDT4\\datos.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        }
        
        return contenido.toString().trim();
    }


    public static void main(String[] args) {
        new Menu().iniciar();
    }


}
