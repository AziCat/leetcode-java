package code.code150.question147;

import common.ListNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void insertionSortList() throws Exception {
        Solution solution = new Solution();
        ListNode head = ListNode.build("-1->5->3->4->0");
        Assert.assertEquals("-1->0->3->4->5",solution.insertionSortList(head).toString());
    }
    @Test
    public void insertionSortList1() throws Exception {
        Solution solution = new Solution();
        ListNode head = ListNode.build("-1->0->3->4->5");
        Assert.assertEquals("-1->0->3->4->5",solution.insertionSortList(head).toString());
    }

    @Test
    public void insertionSortList2() throws Exception {
        Solution solution = new Solution();
        ListNode head = ListNode.build("-1->0->-3->1->5->8->1");
        Assert.assertEquals("-3->-1->0->1->1->5->8",solution.insertionSortList(head).toString());
    }

}