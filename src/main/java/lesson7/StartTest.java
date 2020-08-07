package lesson7;

import lesson7.myTest.*;
import lesson7.tests.CalcAddTest;
import lesson7.tests.CalcDevTest;
import lesson7.tests.CalcMultTest;
import lesson7.tests.CalcSubtractTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class StartTest {

    public static final int MAX_COUNT_BEFORE_SUIT = 1;
    private static final int MAX_COUNT_AFTER_SUIT = 1;
    private static int countDoneMethods = 0;
    private static boolean isBeforeSuiteDone = false;
    private static boolean isAfterSuiteDone = false;


    public static void main(String[] args) {

        start(CalcAddTest.class);

        start(CalcMultTest.class);

        start(CalcDevTest.class);

        start(CalcSubtractTest.class);
    }

    private static <T> void start(Class<T> c) {
        //Для продолжения выполнения тестов при возникновении исключения
        isBeforeSuiteDone = false;
        isAfterSuiteDone = false;
        boolean isFinish = false;
        countDoneMethods = 0;

        while (!isFinish) {
            try {
                isFinish = startTest(c);
            } catch (Exception e) {
                Assert.assertException(e);
            }
        }
    }

    private static <T> boolean startTest(Class<T> c) throws Exception {
        if (c.isAnnotationPresent(Test.class)) {
            throw new RuntimeException("Невозможно провести тест класса без аннотации @Test!");
        }

        Assert.setClazz(c);

        Constructor<T> constructor = c.getConstructor();
        T testClass = (T) constructor.newInstance();
        Method[] methods = c.getDeclaredMethods();

        //Условие для единичного выполнения при возникновении исключения в одном из методов
        if(!isBeforeSuiteDone){
            runBeforeSuite(testClass, methods);
        }
        isBeforeSuiteDone = true;

        runTest(testClass, methods);

        //Условие для единичного выполнения при возникновении исключения в одном из методов
        if(!isAfterSuiteDone){
            runAfterSuite(testClass, methods);
        }
        isAfterSuiteDone = true;
        return true;
    }

    private static <T> void runTest(T testClass, Method[] methods) throws IllegalAccessException, InvocationTargetException {
        Method[] priorityMethods = SortedMethods.getSortedMethods(methods);
        for (int i = countDoneMethods; i < priorityMethods.length; i++) {
            countDoneMethods++;
            if (priorityMethods[i].isAnnotationPresent(Test.class)) {
                Assert.setMethod(priorityMethods[i]);
                priorityMethods[i].invoke(testClass);
            }
        }
    }

    private static <T> void runAfterSuite(T testClass, Method[] methods) throws IllegalAccessException, InvocationTargetException {
        Method afterSuiteMethod = null;
        int countAfterSuite = 0;
        for (Method method : methods) {
            if (method.isAnnotationPresent(AfterSuite.class)) {
                Assert.setMethod(method);
                afterSuiteMethod = method;
                countAfterSuite++;
            }
        }
        if (countAfterSuite > MAX_COUNT_AFTER_SUIT) {
            throw new RuntimeException("Аннотации @AfterSuite не может быть более одной в классе!!!");
        }
        if (afterSuiteMethod != null) {
            afterSuiteMethod.invoke(testClass);
        }
    }

    private static <T> void runBeforeSuite(T testClass, Method[] methods) throws IllegalAccessException, InvocationTargetException {
        Method beforeSuiteMethod = null;
        int countBeforeSuite = 0;
        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                Assert.setMethod(method);
                beforeSuiteMethod = method;
                countBeforeSuite++;
            }
        }
        if (countBeforeSuite > MAX_COUNT_BEFORE_SUIT) {
            throw new RuntimeException("Аннотации @BeforeSuite не может быть более одной в классе!!!");
        }
        if (beforeSuiteMethod != null) {
            beforeSuiteMethod.invoke(testClass);
        }
    }

}
