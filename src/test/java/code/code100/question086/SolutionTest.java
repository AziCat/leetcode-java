package code.code100.question086;

import common.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void partition() {
        Solution solution = new Solution();
        ListNode head = ListNode.build("1->4->2->3->5->2");
        ListNode ans = solution.partition(head, 5);
        Assert.assertEquals("1->4->2->3->2->5", ans.toString());
    }
    @Test
    public void partition2() {
        Solution solution = new Solution();
        ListNode head = ListNode.build("1->4->3->2->5->2");
        ListNode ans = solution.partition(head, 3);
        Assert.assertEquals("1->2->2->4->3->5", ans.toString());
    }

    @Test
    public void partition1() {
        Solution solution = new Solution();
        ListNode head = ListNode.build("1->4->3->5");
        ListNode ans = solution.partition(head, 0);
        Assert.assertEquals("1->4->3->5", ans.toString());
    }
    @Test
    public void partition21() {
        Solution solution = new Solution();
        ListNode head = ListNode.build("1->4->3->5");
        ListNode ans = solution.partition(head, 5);
        Assert.assertEquals("1->4->3->5", ans.toString());
    }

    @Test
    public void partition211() {
        Solution solution = new Solution();
        ListNode head = ListNode.build("2->1");
        ListNode ans = solution.partition(head, 2);
        Assert.assertEquals("1->2", ans.toString());
    }
}