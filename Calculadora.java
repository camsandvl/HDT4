/**
 * Emily Góngora, Camila Sandoval, Ale Sierra
 * Clase Calculadora que utiliza un patrón Singleton para poder crear una sola instancia de esta en diferentes clases.
 * Proporciona métodos para convertir expresiones infix a postfix y evaluar expresiones postfix.
 * 
 */
import java.util.Stack;

public class Calculadora {
  private static Calculadora instancia;

  private Calculadora() { }

/**
 * obtiene la instancia de la clase calculadora
 * @return
 */
  public static Calculadora getInstance() {
    if (instancia == null) {
      instancia = new Calculadora();
    }
      return instancia;
  }

  public String infixToPostfix (String infix) {
    Stack <Character> pila = new Stack<> ();
    StringBuilder postfix = new StringBuilder();

    for (char c : infix.toCharArray()) {
      if (Character.isDigit(c)) {
        postfix.append(c);
      } else if (c == '(') {
        pila.push(c);
      } else if (c == ')') {
        while (!pila.isEmpty() && pila.peek() != '(') {
          postfix.append(pila.pop());
        }
        pila.pop();
      } else {
        while (!pila.isEmpty() && prioridad(c) <= prioridad(pila.peek())) {
          postfix.append(pila.pop());
        }
        pila.push(c);
      }
    }

    while (!pila.isEmpty()) {
      postfix.append(pila.pop());
    }
    return postfix.toString();
  }

  public float evaluacionPostfix(String postfix) {
    Stack <Float> pila = new Stack<>();

    for (char c: postfix.toCharArray()) {
      if (Character.isDigit(c)) {
        pila.push((float) (c - '0'));
      } else {
        float a = pila.pop();
        float b = pila.pop();
        switch (c) {
          case '+' -> pila.push(a + b);
          case '-' -> pila.push(b - a);
          case '*' -> pila.push(a * b);
          case '/' -> pila.push(b / a);
        }
      }
    }
    return pila.pop();
  }

  /**
  * método que permite establecer el orden aritmético de los operadores.
  * 
  * @param operador el operador aritmético cuyo orden se desea determinar
  * @return un valor entero que representa la prioridad del operador
  */
  private int prioridad(char operador) {
    return switch (operador) {
      case '+', '-' -> 1;
      case '*', '/' -> 2;
      default -> 0;
    };
  }
}


