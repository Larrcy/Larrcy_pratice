package Offer3.S1;

public class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        //有可能对头节点进行删除操作 故创建一个新的节点用于记录头节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null) {
            if (temp.next.val == val) {
                //删除节点
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return dummyHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
