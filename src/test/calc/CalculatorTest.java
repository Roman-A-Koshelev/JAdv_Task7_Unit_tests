package calc;

import org.junit.Assert;

public class CalculatorTest {
    static final double EPS_13 = 1e-13;

    @org.junit.Test
    public void evaluateSumTwoNumbers() {
        Calculator calc = new Calculator();
        double actual = calc.evaluate(12.4, 0.17895, Calculator.OP_PLUS);
        double expected = 12.57895;
        Assert.assertEquals("Суммирование двух чисел выполнено с ошибкой.", expected, actual, EPS_13);
    }

    @org.junit.Test
    public void evaluateSumNumberAndZero() {
        Calculator calc = new Calculator();
        double actual = calc.evaluate(12.4, 0.0, Calculator.OP_PLUS);
        double expected = 12.4;
        Assert.assertEquals(expected, actual, EPS_13);
    }

    @org.junit.Test
    public void evaluateSumTwoZeros() {
        Calculator calc = new Calculator();
        double actual = calc.evaluate(0, 0, Calculator.OP_PLUS);
        double expected = 0;
        Assert.assertEquals(expected, actual, EPS_13);
    }

    @org.junit.Test
    public void evaluateMinusTwoNumbers() {
        Calculator calc = new Calculator();
        double actual = calc.evaluate(23.7, 14.56, Calculator.OP_MINUS);
        double expected = 9.14;
        Assert.assertEquals(expected, actual, EPS_13);
    }

    @org.junit.Test
    public void evaluateMinusZeroAndNumber() {
        Calculator calc = new Calculator();
        double actual = calc.evaluate(0, 33.9, Calculator.OP_MINUS);
        double expected = -33.9;
        Assert.assertEquals(expected, actual, EPS_13);
    }

    @org.junit.Test
    public void evaluateMinusTwoZeros() {
        Calculator calc = new Calculator();
        double actual = calc.evaluate(0, 0, Calculator.OP_MINUS);
        double expected = 0;
        Assert.assertEquals(expected, actual, EPS_13);
    }

    @org.junit.Test
    public void evaluateMultTwoNumbers() {
        Calculator calc = new Calculator();
        double actual = calc.evaluate(12.5, -2.4, Calculator.OP_MULT);
        double expected = -30.0;
        Assert.assertEquals(expected, actual, EPS_13);
    }

    @org.junit.Test
    public void evaluateMultNumberAndZero() {
        Calculator calc = new Calculator();
        double actual = calc.evaluate(-12.5, 0.0, Calculator.OP_MULT);
        double expected = 0.0;
        Assert.assertEquals(expected, actual, EPS_13);
    }

    @org.junit.Test
    public void evaluateDivTwoNumbers() {
        Calculator calc = new Calculator();
        double actual = calc.evaluate(100000.5, -5.0, Calculator.OP_DIV);
        double expected = -20000.1;
        Assert.assertEquals(expected, actual, EPS_13);
    }

    @org.junit.Test
    public void evaluateDivZeroOnNumber() {
        Calculator calc = new Calculator();
        double actual = calc.evaluate(0.0, -12.5,Calculator.OP_DIV);
        double expected = 0.0;
        Assert.assertEquals(expected, actual, EPS_13);
    }

//    @org.junit.Rule
//    public ExpectedException thrownExEvaluateDivNumberOnZero = ExpectedException.none();
    @org.junit.Test
    public void evaluateDivNumberOnZero() {
//        thrownExEvaluateDivNumberOnZero.expect(CalcException.class);
//        thrownExEvaluateDivNumberOnZero.expectMessage(Calculator.ERROR_ZERO_DIV);
//        Calculator calc = new Calculator();
//        calc.evaluate(-12.5, 0.0, Calculator.OP_DIV);
        CalcException ex = Assert.assertThrows(
                CalcException.class
                , () -> (new Calculator()).evaluate(-12.5, 0.0, Calculator.OP_DIV)
        );
        Assert.assertEquals(Calculator.ERROR_ZERO_DIV, ex.getMessage());
    }

    @org.junit.Test
    public void getValue() {
        Calculator calc = new Calculator();
        calc.evaluate(17.6, 1.9, Calculator.OP_PLUS);
        double actual = calc.getValue();
        double expected = 19.5;
        Assert.assertEquals("Метод getValue() вернул некорректный результат.", expected, actual, EPS_13);
    }

    @org.junit.Test
    public void evaluateWithOpIsNotSupported() {
        final String opIsNotSupported = "%";
        CalcException ex = Assert.assertThrows(
                CalcException.class
                , () -> (new Calculator()).evaluate(37.8, 27.4, opIsNotSupported)
        );
        Assert.assertEquals(Calculator.ERROR_OP_NOT_SUP, ex.getMessage());
    }

    @org.junit.Test
    public void evaluateWithOpIdIsTooLong() {
        final String opIdIsTooLong = "+-";
        CalcException ex = Assert.assertThrows(
                CalcException.class
                , () -> (new Calculator()).evaluate(-12.5, 0.0, opIdIsTooLong)
        );
        Assert.assertEquals(Calculator.ERROR_OP_NOT_SUP, ex.getMessage());
    }
}