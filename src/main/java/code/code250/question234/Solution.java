package code.code250.question234;

import common.ListNode;

import java.util.List;

/**
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/2/13
 */
public class Solution {
    /**
     * 快慢指针找出中节点，反转后半段再比较
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (null != head) {
            ListNode pre = new ListNode(0);
            pre.next = head;
            ListNode slowNode = pre, fastNode = pre;
            int counter = 0;
            while (fastNode.next != null) {
                fastNode = fastNode.next;
                counter++;
                if (fastNode.next != null) {
                    counter++;
                    fastNode = fastNode.next;
                    slowNode = slowNode.next;
                }
            }
            ListNode reserveNode = reverse(slowNode.next);
            if (counter % 2 == 0) {
                slowNode.next = null;
            }
            while (head != null) {
                if (head.val != reserveNode.val) {
                    return false;
                }
                head = head.next;
                reserveNode = reserveNode.next;
            }
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}
