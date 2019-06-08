package calculator;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * User: salim
 * Date: 08.06.2019 14:47
 */

public class CalculatorTest {

    @Test
    public void testCalculator(){
        Calculator calc = new Calculator();
        int testResult = calc.calculate(2,2);
        assertTrue(testResult==4);
    }


}
