package LeetCode75_3.LeetCode2095;

public class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        if(len==1)return null;
        int index = len / 2;
        ListNode curr = head;
        while (curr != null) {
            index--;
            if(curr.next!=null &&index==0){
                curr.next = curr.next.next;
            }
            curr = curr.next;

        }
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
