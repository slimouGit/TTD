package calculator;

import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class CalculatorTest {

    @Test
    public void testAddition(){
        Calculator calc = new Calculator();
        int testResult = calc.addition(2,2);
        assertTrue(testResult==4);
    }

    @Test
    public void testDevision(){
        Calculator calc = new Calculator();
        int testResult = calc.division(6,2);
        assertTrue(testResult==3);
    }


}
