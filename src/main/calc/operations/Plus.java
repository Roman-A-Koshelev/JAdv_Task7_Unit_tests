package calc.operations;

public class Plus implements Operation {
    @Override
    public double evaluate(double a, double b) {
        return a + b;
    }
}
