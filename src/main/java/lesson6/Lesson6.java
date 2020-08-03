package lesson6;

import java.util.Arrays;

public class Lesson6 {
    public static final int LAST_NUMBER = 4;


    public int[] getArrayAfterLastFour(int[] arrayIn) {
        int[] result = new int[]{};
        for (int i = arrayIn.length - 1; i >= 0; i--) {
            if (arrayIn[i] == LAST_NUMBER) {
                return Arrays.copyOfRange(arrayIn, i + 1, arrayIn.length);
            }
        }
        return result;
    }

    public boolean getArrayOnlyFourAndOne(int[] arrayIn){
        boolean hasOne = false;
        boolean hasFour = false;
        for (int i : arrayIn) {
            if(arrayIn[i] != 1 && arrayIn[i] != 4){
                return false;
            }
            if(arrayIn[i] == 1){
                hasOne = true;
            }
            if(arrayIn[i] == 4){
                hasFour = true;
            }
        }
        return hasOne && hasFour;
    }
}
