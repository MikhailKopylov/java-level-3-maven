package lesson7.tests;

import lesson7.Calculator;
import lesson7.myTest.AfterSuite;
import lesson7.myTest.Assert;
import lesson7.myTest.BeforeSuite;
import lesson7.myTest.Test;

public class CalcMultTest {

    @BeforeSuite
    public void init(){
        System.out.println("Class CalcTestMult --------------------------------------------------");
    }

    @Test(priority = 9)
    public void multTestSimple() {
        Calculator calculator = new Calculator();
        int result = calculator.mult(2, 5);
        Assert.assertEquals(10, result);
    }

    @Test(priority = 8)
    public void multTestNegativeNumber() {
        Calculator calculator = new Calculator();
        int result = calculator.mult(2, -6);
        Assert.assertEquals(-12, result);
    }

    @Test(priority = 9)
    public void multTestZero() {
        Calculator calculator = new Calculator();
        int result = calculator.add(2, 0);
        Assert.assertEquals(2, result);
    }

    @Test(priority = 5)
    public void multTestZeroZero() {
        Calculator calculator = new Calculator();
        int result = calculator.add(0, 0);
        Assert.assertEquals(0, result);
    }

    @AfterSuite
    public void close(){
        System.out.println("---------------------------------------------------------------------\n");
    }

}
