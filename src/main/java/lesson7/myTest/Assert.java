package lesson7.myTest;

import java.lang.reflect.Method;


public class Assert {

    private static Class clazz;
    private static Method method;

    private Assert() {

    }

    public static void setClazz(Class c) {
        clazz = c;
    }

    public static void setMethod(Method m) {
        method = m;
    }


    public static void assertEquals(int expected, int actual) {
        printResult(expected == actual);
    }

    public static void assertException(Throwable e) {
        Class<? extends Throwable> eClass = e.getCause().getClass();
        Class<? extends Throwable> annoExceptionClass = method.getAnnotation(Test.class).exception();
        if (annoExceptionClass.equals(eClass)) {
            printResult(true);
            return;
        }
        printResult(false);
    }

    private static void printResult(boolean result) {
        String methodName = getMethodName();
        String out = String.format("Method \"%s\" result : %s ",
                methodName, Boolean.toString(result).toUpperCase());
        System.out.println(out);
    }

    private static String getMethodName() {
        return method.getName();
    }

    private static String getClassName() {
        return clazz.getSimpleName();
    }
}
