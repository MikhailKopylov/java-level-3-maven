package lesson7.myTest;




import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {

    int priority();

    Class<? extends Throwable> exception() default Test.Empty.class;

    public static class Empty extends Throwable{
        private Empty(){}
    }


}
