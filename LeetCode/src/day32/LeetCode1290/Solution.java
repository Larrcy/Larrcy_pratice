package day32.LeetCode1290;

public class Solution {
    public int getDecimalValue(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        int sum = 0;
        while (head != null) {
            sum += head.val * (int) Math.pow(2, len);
            head = head.next;
            len--;
        }
        return sum;
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
