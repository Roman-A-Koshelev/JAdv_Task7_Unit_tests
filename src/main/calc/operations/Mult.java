package calc.operations;

public class Mult implements Operation {
    @Override
    public double evaluate(double a, double b) {
        return a * b;
    }
}
