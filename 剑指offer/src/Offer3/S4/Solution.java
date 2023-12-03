package Offer3.S4;

public class Solution {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != null) {
            lenA++;
            curA = curA.next;
        }
        while (curB != null) {
            lenB++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        if (lenA < lenB) {
            int len = lenB;
            lenB = lenA;
            lenA = len;
            ListNode temp;
            temp = curB;
            curB = curA;
            curA = temp;
        }
        int gap = lenA - lenB;
        while (gap > 0) {
            curA = curA.next;
            gap--;

        }
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
