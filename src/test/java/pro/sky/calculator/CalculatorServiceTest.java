package pro.sky.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorServiceTest {
    private final CalculatorServiceImpl calculatorServiceImpl = new CalculatorServiceImpl();
    @Test
    void plusTest() {
        int a = 1;
        int b = 1;
        int expected = 2;
        int actual = calculatorServiceImpl.plus(a, b);
        Assertions.assertEquals(expected, actual);

        a = -1;
        b = -1;
        expected = -2;
        actual = calculatorServiceImpl.plus(a, b);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void minusTest() {
        int a = 1;
        int b = 1;
        int expected = 0;
        int actual = calculatorServiceImpl.minus(a, b);
        Assertions.assertEquals(expected, actual);

        a = -1;
        b = -1;
        expected = 0;
        actual = calculatorServiceImpl.minus(a, b);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void multiplyTest() {
        int a = 1;
        int b = 1;
        int expected = 1;
        int actual = calculatorServiceImpl.multiply(a, b);
        Assertions.assertEquals(expected, actual);

        a = -1;
        b = -1;
        expected = 1;
        actual = calculatorServiceImpl.multiply(a, b);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void divideTest() {
        int a = 1;
        int b = 1;
        int expected = 1;
        int actual = calculatorServiceImpl.divide(a, b);
        Assertions.assertEquals(expected, actual);

        a = -1;
        b = -1;
        expected = 1;
        actual = calculatorServiceImpl.divide(a, b);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void divideNegativeTest() {
        assertThrows(IllegalArgumentException.class, () -> calculatorServiceImpl.divide(1,0));
    }
}
