package day52.LeetCode82;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        //用虚拟节点模拟
        //虚拟节点指向第一个节点
        //判断链表的前两个节点是否相等
        //相等则进行删除操作
        ListNode dummy = new ListNode(0, head), cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            int val = cur.next.val;
            if (cur.next.next.val == val)
                //循环删除连续的相同节点
                while (cur.next != null && cur.next.val == val)
                    cur.next = cur.next.next;
            else
                cur = cur.next;
        }
        return dummy.next;
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
