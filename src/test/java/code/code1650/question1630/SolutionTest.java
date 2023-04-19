package code.code1650.question1630;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.List;

public class SolutionTest extends TestCase {

    public void testCheckArithmeticSubarrays() {
        Solution solution = new Solution();
        List<Boolean> result = solution.checkArithmeticSubarrays(new int[]{4,6,5,9,3,7},
                new int[]{0,0,2}, new int[]{2,3,5});
        Assert.assertEquals("[true, false, true]", result.toString());
    }

    public void testCheckArithmeticSubarrays2() {
        Solution solution = new Solution();
        List<Boolean> result = solution.checkArithmeticSubarrays(new int[]{-12, -9, -3, -12, -6, 15, 20, -25, -20, -15, -10},
                new int[]{0, 1, 6, 4, 8, 7}, new int[]{4, 4, 9, 7, 9, 10});
        Assert.assertEquals("[false, true, false, false, true, true]", result.toString());
    }
}