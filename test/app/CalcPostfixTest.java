package app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stack.Stack;
import stack.StackVector;
import static org.junit.jupiter.api.Assertions.*;

public class CalcPostfixTest {

    private Calc calc;

    @BeforeEach
    void setUp() {
        Stack<Integer> stack = new StackVector<>();
        calc = new CalcPostfix(stack);
    }

    @Test
    void testSimpleAddition() throws Exception {
        int result = calc.Operate("5 3 +");
        assertEquals(8, result);
    }

    @Test
    void testComplexExpression() throws Exception {
        int result = calc.Operate("5 3 + 2 *");
        assertEquals(16, result);
    }

    @Test
    void testMixedOperators() throws Exception {
        int result = calc.Operate("10 2 3 * -");
        assertEquals(4, result);
    }

    @Test
    void testDivisionByZero() {
        Exception exception = assertThrows(Exception.class, () -> {
            calc.Operate("10 0 /");
        });

        assertTrue(exception.getMessage().toLowerCase().contains("cero"));
    }

    @Test
    void testInsufficientOperands() {
        Exception exception = assertThrows(Exception.class, () -> {
            calc.Operate("5 +");
        });

        assertTrue(exception.getMessage().toLowerCase().contains("operand"));
    }

    @Test
    void testInvalidToken() {
        Exception exception = assertThrows(Exception.class, () -> {
            calc.Operate("5 a +");
        });

        assertTrue(exception.getMessage().toLowerCase().contains("inval"));
    }

    @Test
    void testExtraOperands() {
        Exception exception = assertThrows(Exception.class, () -> {
            calc.Operate("5 5 5 +");
        });

        assertTrue(exception.getMessage().toLowerCase().contains("expresion"));
    }
}