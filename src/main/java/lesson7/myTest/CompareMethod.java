package lesson7.myTest;
import java.lang.reflect.Method;

public class CompareMethod implements Comparable<CompareMethod>{

    @Override
    public int compareTo(CompareMethod o) {
        return   o.getAnnotation().priority() - annotation.priority() ;
    }
    private final Method method;
    private final Test annotation;

    public CompareMethod(Method method) {
        this.method = method;
        annotation =  method.getAnnotation(Test.class);
    }


    public Method getMethod() {
        return method;
    }

    public Test getAnnotation() {
        return annotation;
    }
}
