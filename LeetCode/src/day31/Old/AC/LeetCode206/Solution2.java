package day31.Old.AC.LeetCode206;

public class Solution2 {
    public ListNode reverseList(ListNode head) {
        return reverse(null, head);
    }

    public ListNode reverse(ListNode prev, ListNode cur) {
        if (cur == null) return prev;
        ListNode temp = cur.next;
        cur.next = prev;
        return reverse(cur, temp);

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
