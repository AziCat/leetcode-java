package code.code50.question024;

import code.code50.question002.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void swapPairs() {
        Assert.assertEquals("2->1->4->3",
                solution.swapPairs(ListNode.build("1->2->3->4")).toString());
    }

    @Test
    public void swapPairs1() {
        Assert.assertEquals("2->1->4->3->5",
                solution.swapPairs(ListNode.build("1->2->3->4->5")).toString());
    }

    @Test
    public void swapPairs2() {
        Assert.assertEquals("2->1->3",
                solution.swapPairs(ListNode.build("1->2->3")).toString());
    }
    @Test
    public void swapPairs3() {
        Assert.assertEquals("1",
                solution.swapPairs(ListNode.build("1")).toString());
    }
    @Test
    public void swapPairs4() {
        Assert.assertNull(solution.swapPairs(null));
    }
}