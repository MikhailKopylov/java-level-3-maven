import lesson6.Lesson6;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestGetArrayAfterLastFour {
    private Lesson6 lesson6;

    @Before
    public void init() {
        lesson6 = new Lesson6();
    }

    @Test
    public void testGetArrayAfterLastFour_Simple() {
        int[] arrayIn = {1, 2, 3, 4, 5, 6};
        Assert.assertArrayEquals(new int[]{5, 6}, lesson6.getArrayAfterLastFour(arrayIn));
    }

    @Test
    public void testGetArrayAfterLastFour_DoubleFour() {
        int[] arrayIn = {1, 4, 3, 5, 4, 6};
        Assert.assertArrayEquals(new int[]{6}, lesson6.getArrayAfterLastFour(arrayIn));
    }

    @Test(expected = NullPointerException.class)
    public void testGetArrayAfterLastFour_ArrayInNull() {
        int[] arrayIn = null;
        lesson6.getArrayAfterLastFour(arrayIn);
    }

    @Test
    public void testGetArrayAfterLastFour_WithoutFour() {
        int[] arrayIn = {1, 2, 3, 5, 5, 6};
        Assert.assertArrayEquals(new int[]{}, lesson6.getArrayAfterLastFour(arrayIn));
    }

    @Test
    public void testGetArrayAfterLastFour_OnlyFour() {
        int[] arrayIn = {4, 4, 4, 4, 4, 4};
        Assert.assertArrayEquals(new int[]{}, lesson6.getArrayAfterLastFour(arrayIn));
    }

    @Test
    public void testGetArrayAfterLastFour_LastFour() {
        int[] arrayIn = {1, 2, 3, 4, 5, 4};
        Assert.assertArrayEquals(new int[]{}, lesson6.getArrayAfterLastFour(arrayIn));
    }

}
