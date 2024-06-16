package pro.sky.calculator;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class CalculatorServiceParametrizedTest {
    private final CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
    @ParameterizedTest
    @MethodSource("provideParamsForPlusTest")
    void plusTest(int a, int b, int expected) {
    int actual = calculatorService.plus(a,b);
        Assertions.assertEquals(expected,actual);
    }

    static Stream<Arguments> provideParamsForPlusTest() {
    return Stream.of(
            Arguments.of(1,1,2),
            Arguments.of(1,0,1),
            Arguments.of(0,1,1)
    );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForMinusTest")
    void minusTest(int a, int b, int expected) {
        int actual = calculatorService.minus(a,b);
        Assertions.assertEquals(expected,actual);
    }

    static Stream<Arguments> provideParamsForMinusTest() {
        return Stream.of(
                Arguments.of(1,1,0),
                Arguments.of(1,0,1),
                Arguments.of(0,1,-1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForMultiplyTest")
    void multiplyTest(int a, int b, int expected) {
        int actual = calculatorService.multiply(a,b);
        Assertions.assertEquals(expected,actual);
    }

    static Stream<Arguments> provideParamsForMultiplyTest() {
        return Stream.of(
                Arguments.of(1,1,1),
                Arguments.of(1,0,0),
                Arguments.of(0,1,0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForDivideTest")
    void divideTest(int a, int b, int expected) {
        int actual = calculatorService.divide(a,b);
        Assertions.assertEquals(expected,actual);
    }

    static Stream<Arguments> provideParamsForDivideTest() {
        return Stream.of(
                Arguments.of(1,1,1),
                Arguments.of(-1,-1,1),
                Arguments.of(1,-1,-1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForDivideNegativeTest")
    void divideNegativeTest(int a, int b) {
        assertThrows(IllegalArgumentException.class, () -> calculatorService.divide(a,b));
    }

    static Stream<Arguments> provideParamsForDivideNegativeTest() {
        return Stream.of(
                Arguments.of(1,0),
                Arguments.of(-1,0)
        );
    }
}
