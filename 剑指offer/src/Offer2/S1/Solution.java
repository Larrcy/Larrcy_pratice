package Offer2.S1;

import java.util.List;

public class Solution {
    public int[] reversePrint(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            //创建temp节点保存cur的下一个节点
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
            len++;
        }
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = pre.val;
            pre = pre.next;
        }
        return nums;

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
