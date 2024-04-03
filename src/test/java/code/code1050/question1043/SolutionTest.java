package code.code1050.question1043;

import junit.framework.TestCase;
import org.junit.Assert;

public class SolutionTest extends TestCase {

    public void test1() {
        Solution solution = new Solution();
        Assert.assertEquals(84, solution.maxSumAfterPartitioning(new int[]{
                1, 15, 7, 9, 2, 5, 10
        }, 3));
    }

    public void test2() {
        Solution solution = new Solution();
        Assert.assertEquals(83, solution.maxSumAfterPartitioning(new int[]{
                1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3
        }, 4));
    }

    public void test3() {
        Solution solution = new Solution();
        Assert.assertEquals(1, solution.maxSumAfterPartitioning(new int[]{
                1
        }, 1));
    }
}