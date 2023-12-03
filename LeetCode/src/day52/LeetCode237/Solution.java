package day52.LeetCode237;

public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        //该节点无法定位
        //则将该节点的下一个节点的值赋值给自己
        //然后删除下一个节点
        node.next = node.next.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
