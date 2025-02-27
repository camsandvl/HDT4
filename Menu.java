import java.awt.SystemColor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Scanner;

public class Menu {
    private Calculadora calculadora;
    public Menu () {
        calculadora = Calculadora.getInstance();
    }

    public String leerArchivo(String archivo) {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contenido.toString();
    }

    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione la implementación de Stack:");
        System.out.println("1. ArrayList");
        System.out.println("2. Vector");
        System.out.println("3. Lista Encadenada");
        int opcion = sc.nextInt();
        
        //IStack <Float> stack = elegiorStack(opcion); pendiente

        String infix = leerArchivo ("datos.txt");
        System.out.println("Expresion infix: " + infix);
        String postfix = calculadora.infixToPostfix(infix.trim());
        System.out.println("Expresión postfix" + postfix);

        float resultado = calculadora.evaluacionPostfix(postfix);
        System.out.println("Resultado" + resultado);
    }

    //pendiente elegirStack
}
