package SqlPodklyuchenie;

public class Calculator {

    public int div(int a, int b) throws ArithmeticException{
        if (a==0 || b == 0) {
            throw new ArithmeticException("ДЕЛЕНИЕ НА НОЛЬ");
        } else {
            return a / b;
        }
    }
}
