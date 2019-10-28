package code.code50.question002;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 *
 * @author yan
 * @version 1.0
 * @date 2019/9/10
 */
public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l1_4 = new ListNode(5);
        ListNode l1_3 = new ListNode(5);
        l1.next = l1_4;
        l1_4.next = l1_3;

        ListNode l2 = new ListNode(5);
        ListNode l2_6 = new ListNode(5);
        ListNode l2_4 = new ListNode(5);
        l2.next = l2_6;
        //l2_6.next = l2_4;

        Solution solution = new Solution();
        ListNode listNode = solution.addTwoNumbers2(l1, l2);
        System.out.println(listNode);
    }

    /**
     * 递归
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (null != l1 || null != l2) {
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;
            int sum = l1Val + l2Val;
            int temp = sum > 9 ? 1 : 0;
            int newVal = sum > 9 ? sum - 10 : sum;
            ListNode node = new ListNode(newVal);

            if (null != l1) {
                l1 = l1.next;
            }
            if (null != l2) {
                l2 = l2.next;
            }

            if (temp != 0) {
                if (l1 == null) {
                    l1 = new ListNode(temp);
                } else {
                    l1.val = l1.val + temp;
                }
            }
            node.next = addTwoNumbers2(l1, l2);
            return node;
        }
        return null;
    }

    /**
     * 伪指针
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        int temp = 0;
        ListNode listNode = new ListNode(0);
        ListNode tempNode = listNode;
        while (null != l1 || null != l2 || temp != 0) {
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;
            int sum = l1Val + l2Val + temp;
            temp = sum > 9 ? 1 : 0;
            int newVal = sum > 9 ? sum - 10 : sum;
            ListNode nextNode = new ListNode(newVal);
            tempNode.next = nextNode;
            tempNode = nextNode;
            if (null != l1) {
                l1 = l1.next;
            }
            if (null != l2) {
                l2 = l2.next;
            }
        }
        return listNode.next;
    }
}
