package Offer2.S2;

public class Solution {
    public ListNode reverseList(ListNode head) {
        return reverse(head, null);

    }

    public ListNode reverse(ListNode cur, ListNode pre) {
        if (cur == null) {
            return pre;
        }
        ListNode temp = cur.next;
        cur.next = pre;
        return reverse(temp, cur);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
