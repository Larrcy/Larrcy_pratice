package day31.Old.AC.LeetCode203;

import java.util.List;
//删除链表的指定节点
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dynamicNode = new ListNode(0);
        ListNode cur =dynamicNode;
        dynamicNode.next=head;
        while (cur.next!=null){
            if(cur.next.val==val){
                cur.next=cur.next.next;
            }
           else cur=cur.next;
        }
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
