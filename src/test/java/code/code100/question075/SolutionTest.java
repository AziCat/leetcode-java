package code.code100.question075;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void sortColors() {
        Solution solution = new Solution();
        int[] arr = new int[]{2, 0, 2, 1, 1, 0};
        solution.sortColors(arr);
        Assert.assertEquals("[0, 0, 1, 1, 2, 2]", Arrays.toString(arr));
    }

    @Test
    public void sortColors1() {
        Solution solution = new Solution();
        int[] arr = new int[]{1, 2, 0, 2, 1, 1, 2};
        solution.sortColors(arr);
        Assert.assertEquals("[0, 1, 1, 1, 2, 2, 2]", Arrays.toString(arr));
    }

    @Test
    public void sortColors2() {
        Solution solution = new Solution();
        int[] arr = new int[]{1, 2, 0, 1, 1, 0, 2};
        solution.sortColors(arr);
        Assert.assertEquals("[0, 0, 1, 1, 1, 2, 2]", Arrays.toString(arr));
    }
}