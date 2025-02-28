import static org.junit.Assert.*;
import org.junit.Test;

public class CalculadoraTest {

    @Test
    public void testInfixToPostfix() {
        Calculadora calc = Calculadora.getInstance();
        String infix = "3 + 4 * 2 / ( 1 - 5 ) ^ 2 ^ 3";
        String expectedPostfix = "3 4 2 * 1 5 - 2 3 ^ ^ / +";
        String actualPostfix = calc.infixToPostfix(infix);
        assertEquals(expectedPostfix, actualPostfix);
    }

    @Test
    public void testEvaluacionPostfix() {
        Calculadora calc = Calculadora.getInstance();
        String postfix = "3 4 2 * 1 5 - 2 3 ^ ^ / +";
        int expectedValue = 3;
        int actualValue = calc.evaluacionPostfix(postfix);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testApplyOperator() {
        Calculadora calc = Calculadora.getInstance();
        assertEquals(7, calc.applyOperator(3, 4, '+'));
        assertEquals(-1, calc.applyOperator(3, 4, '-'));
        assertEquals(12, calc.applyOperator(3, 4, '*'));
        assertEquals(0, calc.applyOperator(3, 4, '/'));
        assertEquals(81, calc.applyOperator(3, 4, '^'));
    }
}
