package LeetCode75_3.LeetCode328;

public class Solution2 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        //cur作为指针
        ListNode cur = head;
        //curr为偶数链表的头节点不可移动
        ListNode curr = head.next;
        //p作为指针可以移动
        ListNode p = curr;
        while (cur.next != null && p.next != null) {
            cur.next = p.next;
            cur = cur.next;

            p.next = cur.next;
            p = p.next;
        }
        cur.next = curr;
        return head;

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
