package code.code250.question203;

import common.ListNode;

/**删除链表中等于给定值 val 的所有节点。

示例:

输入: 1->2->6->3->4->5->6, val = 6
输出: 1->2->3->4->5
 * @author yan
 * @version 1.0
 * @date 2019/12/31
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode ans = new ListNode(0);
        ans.next = head;
        ListNode pre = ans;
        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
            }else {
                pre=pre.next;
            }
            head = head.next;
        }
        return ans.next;
    }
}
