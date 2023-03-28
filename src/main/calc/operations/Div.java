package calc.operations;

public class Div implements Operation {
    @Override
    public double evaluate(double a, double b) {
        if (0 == b) {
            return Double.NaN;
        }

        return a / b;
    }
}
