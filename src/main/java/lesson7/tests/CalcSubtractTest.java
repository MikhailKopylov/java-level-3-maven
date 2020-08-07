package lesson7.tests;


import lesson7.Calculator;
import lesson7.myTest.AfterSuite;
import lesson7.myTest.Assert;
import lesson7.myTest.BeforeSuite;
import lesson7.myTest.Test;

public class CalcSubtractTest {

    @BeforeSuite
    public void init(){
        System.out.println("Class CalcSubtractTest --------------------------------------------------");
    }

//    @BeforeSuite
//    public void init2(){
//        Calculator calculator = new Calculator();
//        System.out.println("YES!!!");
//    }

    @Test(priority = 1)
    public void subTestSimple() {
        Calculator calculator = new Calculator();
        int result = calculator.subtract(2, 5);
        Assert.assertEquals(-3, result);
    }

    @Test(priority = 5)
    public void subTestNegativeNumber() {
        Calculator calculator = new Calculator();
        int result = calculator.subtract(2, -6);
        Assert.assertEquals(8, result);
    }

    @Test(priority = 10)
    public void subTestZero() {
        Calculator calculator = new Calculator();
        int result = calculator.subtract(2, 0);
        Assert.assertEquals(2, result);
    }

    @Test(priority = 5)
    public void subTestZeroZero() {
        Calculator calculator = new Calculator();
        int result = calculator.subtract(0, 0);
        Assert.assertEquals(0, result);
    }

    @AfterSuite
    public void close(){
        System.out.println("-------------------------------------------------------------------\n");
    }

}
