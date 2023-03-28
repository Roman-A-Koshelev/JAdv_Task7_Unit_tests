package calc;

import calc.operations.*;

/**
 * Калькулятор
 */
public class Calculator {
    public static final String OP_PLUS = "+";
    public static final String OP_MINUS = "-";
    public static final String OP_MULT = "*";
    public static final String OP_DIV = "/";

    public static final String ERROR_OP_NOT_SUP = "Операция не поддерживается!";
    public static final String ERROR_ZERO_DIV = "Делитель не должен быть равен нулю!";
    private double val = 0.0;
    /**
     * Метод выполняет операции калькулятора (сложение, вычитание, деление или
     * умножение) над дробными числами.
     * @param a Первое дробное число
     * @param b Второе дробное число
     * @param strOp Операция выполняемая над дробными числами.
     * @return Код ошибки. Код == 0 - OK, Код < 0 - Ошибка.
     */
    public double evaluate(double a, double b, String strOp) throws CalcException {
        if (1 != strOp.length()) {
            throw new CalcException(ERROR_OP_NOT_SUP);
        }

        Operation op;
        switch(strOp.charAt(0)) {
            case '+':
                op = new Plus();
                val = op.evaluate(a, b);
                return val;

            case '-':
                op = new Minus();
                val = op.evaluate(a, b);
                return val;

            case '*':
                op = new Mult();
                val = op.evaluate(a, b);
                return val;

            case '/':
                op = new Div();
                val = op.evaluate(a, b);
                if (Double.isNaN(val)) {
                    throw new CalcException(ERROR_ZERO_DIV);
                }
                return val;
        }

        throw new CalcException(ERROR_OP_NOT_SUP);
    }

    public double getValue() {
        return val;
    }

}
