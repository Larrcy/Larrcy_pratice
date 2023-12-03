package day03.LeetCode160;

public class Solution {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            //进行链表的循环
            //pA==null即A走完链表A则需要走链表B
            //若没走完则继续走A
            pA = pA == null ? headB : pA.next;
            //pB==null即B走完链表B则需要走链表A
            //若没走完则继续走B
            pB = pB == null ? headA : pB.next;
            //相交的时机为A B指向相同位置
            //若同时指向null则一定不相交
        }
        return pA;

    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
