package day23.LeetCode445;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r1 = reverse(l1);
        ListNode r2 = reverse(l2);
        return addNumbers(r1, r2);


    }

    public ListNode addNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        //pre 记录cur的位置
        ListNode pre = null;
        //记录进位
        int carry = 0;
        while (l1 != null && l2 != null) {
            cur.val = l1.val + l2.val + carry;
            carry = cur.val / 10;
            cur.val = cur.val % 10;
            cur.next = new ListNode(0);
            pre = cur;
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        //若l1长
        while (l1 != null) {
            cur.val = l1.val + carry;
            carry = cur.val / 10;
            cur.val = cur.val % 10;
            cur.next = new ListNode(0);
            pre = cur;
            cur = cur.next;
            l1 = l1.next;
        }
        //若l2长
        while (l2 != null) {
            cur.val = l2.val + carry;
            carry = cur.val / 10;
            cur.val = cur.val % 10;
            cur.next = new ListNode(0);
            pre = cur;
            cur = cur.next;
            l2 = l2.next;
        }
        //最后判断最后一位是否需要进位
        if (carry == 0) {
            pre.next = null;
        } else {
            cur.val = carry;
        }
        return res;
    }

    public ListNode reverse(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
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
