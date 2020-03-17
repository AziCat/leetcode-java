package code.code350.question307;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumArrayTest {
    @Test
    public void test() throws Exception {
        int[] nums = {1, 2, 3};
        NumArray numArray = new NumArray(nums);
        Assert.assertEquals(1, numArray.sumRange(0, 0));
        Assert.assertEquals(6, numArray.sumRange(0, 2));
        numArray.update(1, 1);
        Assert.assertEquals(5, numArray.sumRange(0, 2));
    }

}