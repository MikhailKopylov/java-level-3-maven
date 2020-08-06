package lesson7.tests;

import lesson7.Calculator;
import lesson7.myTest.AfterSuite;
import lesson7.myTest.Assert;
import lesson7.myTest.BeforeSuite;
import lesson7.myTest.Test;

public class CalcDevTest {

    @BeforeSuite
    public void init(){
        System.out.println("Class CalcDevTest --------------------------------------------------");
    }

    @Test(priority = 4)
    public void devTestSimple() {
        Calculator calculator = new Calculator();
        int result = calculator.dev(20, 5);
        Assert.assertEquals(4, result);
    }

    @Test(priority = 3)
    public void devTestNegativeNumber() {
        Calculator calculator = new Calculator();
        int result = calculator.dev(-6, 2);
        Assert.assertEquals(-3, result);
    }

    @Test(priority = 5, exception = ArithmeticException.class)
    public void devTestZero() {
        Calculator calculator = new Calculator();
        int result = calculator.dev(2, 0);
        Assert.assertEquals(2, result);
    }

    @Test(priority = 8, exception = ArithmeticException.class)
    public void devTestZeroZero() {
        Calculator calculator = new Calculator();
        calculator.dev(0, 0);

    }

    @AfterSuite
    public void close(){
        System.out.println("---------------------------------------------------------------------\n");
    }

}
