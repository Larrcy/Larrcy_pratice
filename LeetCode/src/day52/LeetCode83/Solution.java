package day52.LeetCode83;

public class Solution {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            //当前节点与下个节点相同时 要进行去重
            if (cur.val == cur.next.val) {
                //将当前节点的下个节点跳过 指向下下个节点
                cur.next = cur.next.next;

            } else {
                cur = cur.next;
            }
        }

        //最后返回头节点得到新链表
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
