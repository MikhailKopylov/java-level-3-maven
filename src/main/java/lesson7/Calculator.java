package lesson7;

public class Calculator {

    public Calculator() {
    }

    public int add(int x, int y){
        return x + y;
    }

    public int subtract(int x, int y){
        return x - y;
    }

    public int mult(int x, int y){
        return x * y;
    }

    public int dev (int x, int y){
        if(y == 0){
            throw new ArithmeticException("Нельзя делить на ноль!!");
        }
        return x / y;
    }
}
