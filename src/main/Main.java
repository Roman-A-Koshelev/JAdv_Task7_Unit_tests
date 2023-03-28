import calc.CalcException;
import calc.Calculator;
import java.util.Scanner;

public class Main {
    static void calculate(Calculator calc) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Необходимо ввести два дробных числа и знак операции (‘+’, ‘-’, ‘*’ или ‘/’).");

            System.out.print("Введите первое число:   ");
            double a = in.nextDouble();

            System.out.print("Введите второе число:   ");
            double b = in.nextDouble();

            System.out.print("Введите знак операции:  ");
            String op = in.next();
            in.close();

            calc.evaluate(a, b, op);
            System.out.printf("Результат операции = %.4f", calc.getValue());
        }
        catch (CalcException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Calculator calc = new Calculator();
            calculate(calc);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
