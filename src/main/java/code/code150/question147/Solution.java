package code.code150.question147;

import common.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 对链表进行插入排序。
 * 插入排序算法：
 * <p>
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 * 示例 1：
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insertion-sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2019/12/2
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode tail = dummy;
        ListNode pre = dummy;
        while (head != null && head.next != null) {
            if (head.next.val < head.val) {
                //判断是从dummy开始还是从tail开始
                if (head.next.val >= tail.val) {
                    while (tail.next.val < head.next.val) {
                        tail = tail.next;
                    }
                    ListNode temp = head.next;
                    head.next = temp.next;
                    temp.next = tail.next;
                    tail.next = temp;
                    tail = temp;
                }else {
                    while (pre.next.val < head.next.val) {
                        pre = pre.next;
                    }
                    ListNode temp = head.next;
                    head.next = temp.next;
                    temp.next = pre.next;
                    pre.next = temp;
                    tail = temp;
                    pre = dummy;
                }

            }else {
                head = head.next;
            }
        }
        return dummy.next;
    }
}
