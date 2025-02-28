/**
 * Emily Góngora, Camila Sandoval, Ale Sierra
 * 
 * Clase que implementa el patrón singleton para la calculadora, convierte una expresión infix a postfix y evalúa el resultado
 * el método infix a postfix convierte la expresión leyeendo caracter por caracter y los va comparando con los operadores
 * 
 */
import java.util.Stack;

public class Calculadora {
    public String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        String[] tokens = infix.split(" ");

        for (String token : tokens) {
            char c = token.charAt(0);
            if (Character.isDigit(c)) {
                postfix.append(token).append(" ");
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }

        return postfix.toString().trim();
    }

    private int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    public int evaluacionPostfix(String postfix) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = postfix.split(" ");

        for (String token : tokens) {
            if (Character.isDigit(token.charAt(0))) {
                stack.push(Integer.parseInt(token));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                int result = applyOperator(a, b, token.charAt(0));
                stack.push(result);
            }
        }

        return stack.pop();
    }

    private int applyOperator(int a, int b, char operator) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            case '^':
                return (int) Math.pow(a, b);
            default:
                throw new IllegalArgumentException("Operador desconocido: " + operator);
        }
    }

    public static Calculadora getInstance() {
        return new Calculadora();
    }
}