package code.code150.question141;

import common.ListNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void hasCycle() throws Exception {
        Solution solution = new Solution();
        Assert.assertFalse(solution.hasCycle(ListNode.build("1->2")));
    }

    @Test
    public void hasCycle1() throws Exception {
        Solution solution = new Solution();
        ListNode head = ListNode.build("1->2");
        head.next = head;
        Assert.assertTrue(solution.hasCycle(head));
    }

}