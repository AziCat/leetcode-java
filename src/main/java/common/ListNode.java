package common;

/**
 * @author yan
 * @version 1.0
 * @date 2019/9/10
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public static ListNode build(String str) {
        //1->2->3->4->5
        if (null != str && !str.isEmpty()) {
            ListNode head = new ListNode(0);
            ListNode temp = head;
            for (String i : str.split("->")) {
                ListNode listNode = new ListNode(Integer.parseInt(i));
                temp.next = listNode;
                temp = listNode;
            }
            return head.next;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.val);
        ListNode next = this.next;
        while (null != next) {
            sb.append("->").append(next.val);
            next = next.next;
        }
        return sb.toString();
    }
}