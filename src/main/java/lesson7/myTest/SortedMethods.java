package lesson7.myTest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class SortedMethods  {

    Method[] methods;

    public SortedMethods(Method... methods) {
        this.methods = methods;
    }

    public static Method[] getSortedMethods(Method... methods){
        List<CompareMethod> compareMethods = new ArrayList<>();
        for (Method method : methods) {
            if(method.isAnnotationPresent(Test.class)){
                compareMethods.add(new CompareMethod(method));
            }
        }

        compareMethods.sort(CompareMethod::compareTo);

        List<Method> sortedMethod =new ArrayList<>();
        for (CompareMethod compareMethod : compareMethods) {
            sortedMethod.add(compareMethod.getMethod());
        }

        return  sortedMethod.toArray(new Method[0]);
    }

}
