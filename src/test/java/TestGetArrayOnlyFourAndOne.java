import lesson6.Lesson6;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestGetArrayOnlyFourAndOne {

    private static Lesson6 lesson6;

    @BeforeClass
    public static void init() {
        lesson6 = new Lesson6();
    }

    @Test
    public void testGetArrayOnlyFourAndOne_Simple() {
        int[] arrayIn = {1, 1, 1, 4, 4, 1, 4, 4};
        Assert.assertTrue(lesson6.getArrayOnlyFourAndOne(arrayIn));
    }

    @Test
    public void testGetArrayOnlyFourAndOne_OnlyFour() {
        int[] arrayIn = {4, 4, 4, 4, 4, 4, 4, 4};
        Assert.assertFalse(lesson6.getArrayOnlyFourAndOne(arrayIn));
    }

    @Test
    public void testGetArrayOnlyFourAndOne_OnlyOne() {
        int[] arrayIn = {1, 1, 1, 1, 1, 1, 1, 1};
        Assert.assertFalse(lesson6.getArrayOnlyFourAndOne(arrayIn));
    }

    @Test
    public void testGetArrayOnlyFourAndOne_HasOtherDigit() {
        int[] arrayIn = {1, 2, 1, 4, 4, 1, 4, 4};
        Assert.assertFalse(lesson6.getArrayOnlyFourAndOne(arrayIn));
    }

    @Test(expected = NullPointerException.class)
    public void testGetArrayOnlyFourAndOne_ArrayNull() {
        int[] arrayIn = null;
        lesson6.getArrayOnlyFourAndOne(arrayIn);
    }

    @Test
    public void testGetArrayOnlyFourAndOne_HasOtherDigits() {
        int[] arrayIn = {1, 6, 1, 4, 4, 12, 4, 4};
        Assert.assertFalse(lesson6.getArrayOnlyFourAndOne(arrayIn));
    }

    @Test
    public void testGetArrayOnlyFourAndOne_Empty() {
        int[] arrayIn = {};
        Assert.assertFalse(lesson6.getArrayOnlyFourAndOne(arrayIn));
    }
}
