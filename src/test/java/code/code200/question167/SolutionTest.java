package code.code200.question167;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void twoSum() throws Exception {
        Solution solution = new Solution();
        int[] index = solution.twoSum(new int[]{1, 2, 3, 4, 5, 6, 7}, 12);
        Assert.assertEquals(5,index[0] );
        Assert.assertEquals(7,index[1] );
    }

    @Test
    public void twoSum1() throws Exception {
        Solution solution = new Solution();
        int[] index = solution.twoSum(new int[]{0,0,1,2}, 0);
        Assert.assertEquals(1,index[0] );
        Assert.assertEquals(2,index[1] );
    }

}