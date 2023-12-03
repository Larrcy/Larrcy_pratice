package Offer3.S2;

public class Solution2 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        //快慢指针法 快指针比慢指针多走k步 当快指针到结尾时 慢指针所指位置即为所求
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k; i++)
            fast = fast.next;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
