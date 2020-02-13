package code.code250.question234;

import common.ListNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void isPalindrome() throws Exception {
        Solution solution = new Solution();
        ListNode head = ListNode.build("1->2->2->1");
        Assert.assertTrue(solution.isPalindrome(head));
    }

    @Test
    public void isPalindrome1() throws Exception {
        Solution solution = new Solution();
        ListNode head = ListNode.build("1");
        Assert.assertTrue(solution.isPalindrome(head));
    }
    @Test
    public void isPalindrome2() throws Exception {
        Solution solution = new Solution();
        ListNode head = ListNode.build("1->1");
        Assert.assertTrue(solution.isPalindrome(head));
    }
    @Test
    public void isPalindrome3() throws Exception {
        Solution solution = new Solution();
        ListNode head = ListNode.build("1->2->3->1");
        Assert.assertFalse(solution.isPalindrome(head));
    }

}