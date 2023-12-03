package day24.LeetCode61;

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode cur = head;
        int len = 1;
        while (cur.next != null) {
            cur = cur.next;
            len++;
        }
        int size = len - (k % len);
        if (size == len) return head;
        //将链表首尾相连
        //此时cur指向最后一个节点
        //cur的下一个位置指向头节点
        cur.next = head;
        while (size != 0) {
            cur = cur.next;
            size--;
        }
        ListNode newHead = cur.next;
        cur.next = null;

        return newHead;
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
