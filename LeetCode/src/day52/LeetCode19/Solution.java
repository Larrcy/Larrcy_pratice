package day52.LeetCode19;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dynamic = new ListNode(0);
        dynamic.next = head;
        ListNode fast = dynamic;
        ListNode slow = dynamic;
        while (n != 0) {
            fast = fast.next;
            n--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dynamic.next;
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
