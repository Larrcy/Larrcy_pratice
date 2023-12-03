package Char02.S8.LeetCode142;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        //定义快慢指针指向头节点
        ListNode slow = head;
        ListNode fast = head;
        //快指针走两步 慢指针走一步
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            //当快慢指针相遇则说明有环
            if (slow == fast) {// 有环
                ListNode index1 = fast;
                ListNode index2 = head;
                // 两个指针，从头结点和相遇结点，各走一步，直到相遇，相遇点即为环入口
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                //最后返回环的入口索引
                return index1;
            }
        }
        //遍历完后没有则无环
        return null;
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
