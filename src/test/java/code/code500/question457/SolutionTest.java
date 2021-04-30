package code.code500.question457;

import junit.framework.TestCase;
import org.junit.Assert;

public class SolutionTest extends TestCase {

    public void testCircularArrayLoop() {
        int[] nums = {2, -1, 1, 2, 2};
        Solution solution = new Solution();
        Assert.assertTrue(solution.circularArrayLoop(nums));
    }

    public void testCircularArrayLoop1() {
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 1, -5};
        Solution solution = new Solution();
        Assert.assertFalse(solution.circularArrayLoop(nums));
    }


}