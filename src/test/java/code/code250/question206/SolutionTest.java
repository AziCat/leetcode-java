package code.code250.question206;

import common.ListNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void reverseList() throws Exception {
        Solution solution = new Solution();
        ListNode reverseNode = solution.reverseList(ListNode.build("1"));
        Assert.assertEquals("1", reverseNode.toString());
    }

    @Test
    public void reverseList1() throws Exception {
        Solution solution = new Solution();
        ListNode reverseNode = solution.reverseList(ListNode.build("1->2"));
        Assert.assertEquals("2->1", reverseNode.toString());
    }

    @Test
    public void reverseList2() throws Exception {
        Solution solution = new Solution();
        ListNode reverseNode = solution.reverseList(ListNode.build("1->2->3"));
        Assert.assertEquals("3->2->1", reverseNode.toString());
    }

    @Test
    public void reverseList21() throws Exception {
        Solution solution = new Solution();
        ListNode reverseNode = solution.reverseList(ListNode.build("1->2->3->4"));
        Assert.assertEquals("4->3->2->1", reverseNode.toString());
    }

    @Test
    public void reverseList12() throws Exception {
        Solution solution = new Solution();
        ListNode reverseNode = solution.reverseList(ListNode.build("1->2->3->4->5"));
        Assert.assertEquals("5->4->3->2->1", reverseNode.toString());
    }
}