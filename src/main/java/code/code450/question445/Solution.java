package code.code450.question445;

import common.ListNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 *  
 * <p>
 * 进阶：
 * <p>
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yjh
 * @version 1.0
 * @since 2021/4/19 14:59
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<Integer> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();
        while (l1 != null || l2 != null) {
            if (null != l1) {
                stack1.addLast(l1.val);
                l1 = l1.next;
            }
            if (null != l2) {
                stack2.addLast(l2.val);
                l2 = l2.next;
            }
        }
        //补0
        int maxSize = Math.max(stack1.size(), stack2.size());
        while (stack1.size() < maxSize) {
            stack1.addFirst(0);
        }
        while (stack2.size() < maxSize) {
            stack2.addFirst(0);
        }
        ListNode pre = null;
        Integer preInt = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int sum = stack1.removeLast() + stack2.removeLast() + preInt;
            preInt = sum / 10;
            ListNode cur = new ListNode(sum % 10);
            cur.next = pre;
            pre = cur;
        }
        if (preInt != 0) {
            ListNode cur = new ListNode(preInt);
            cur.next = pre;
            pre = cur;
        }

        return pre;
    }
}
