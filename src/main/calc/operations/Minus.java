package calc.operations;

public class Minus implements Operation {
    @Override
    public double evaluate(double a, double b) {
        return a - b;
    }
}
