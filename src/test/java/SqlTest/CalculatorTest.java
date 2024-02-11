package SqlTest;

import SqlPodklyuchenie.Calculator;
import org.checkerframework.checker.units.qual.C;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CalculatorTest {

    @Test(expected = ArithmeticException.class)
    public void testDiv1() {
        new Calculator().div(1,0);
    }

    @Test
    public void testDiv2(){
        Exception exception = assertThrows(ArithmeticException.class, () ->{
            Calculator calculator = new Calculator();
            calculator.div(1,0);
        });
        assertEquals("ДЕЛЕНИЕ НА НОЛЬ", exception.getMessage());
    }
}
