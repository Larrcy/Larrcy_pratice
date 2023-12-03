package day31.Old.AC.LeetCode19;

//删除倒数第k个节点
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //有可能会删除头节点故要利用虚拟指针
        //快慢指针法 先让快指针走k+1步
        //之后快慢指针一起走
        //当快指针指向空时则慢指针走向要删除节点的前一个节点
        ListNode dynamicNode =new ListNode(-1);
        dynamicNode.next=head;
        ListNode fast =dynamicNode;
        ListNode slow =dynamicNode;
        for (int i = 0; i <= n; i++) {
            fast=fast.next;
        }
        while (fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return dynamicNode.next;
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
