package lesson7.tests;


import lesson7.Calculator;
import lesson7.myTest.AfterSuite;
import lesson7.myTest.Assert;
import lesson7.myTest.BeforeSuite;
import lesson7.myTest.Test;

public class CalcAddTest {

    @BeforeSuite
    public void init(){
        System.out.println("Class CalcAddTest --------------------------------------------------");
    }

//    @BeforeSuite
//    public void init2(){
//        Calculator calculator = new Calculator();
//        System.out.println("YES!!!");
//    }

    @Test(priority = 1)
    public void addTestSimple() {
        Calculator calculator = new Calculator();
        int result = calculator.add(2, 5);
        Assert.assertEquals(7, result);
    }

    @Test(priority = 5)
    public void addTestNegativeNumber() {
        Calculator calculator = new Calculator();
        int result = calculator.add(2, -6);
        Assert.assertEquals(-4, result);
    }

    @Test(priority = 10)
    public void addTestZero() {
        Calculator calculator = new Calculator();
        int result = calculator.add(2, 0);
        Assert.assertEquals(2, result);
    }

    @Test(priority = 5)
    public void addTestZeroZero() {
        Calculator calculator = new Calculator();
        int result = calculator.add(0, 0);
        Assert.assertEquals(0, result);
    }

    @AfterSuite
    public void close(){
        System.out.println("-------------------------------------------------------------------\n");
    }

}
