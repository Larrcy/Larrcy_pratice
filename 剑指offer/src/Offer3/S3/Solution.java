package Offer3.S3;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //合并链表
        //创建一个新链表并指定头尾节点（长度为0 值为0）
        ListNode head = new ListNode(0);
        ListNode tail = head;
        //当两个链表不为空时进行判断
        while (l1 != null & l2 != null) {
            //若链表1的值小于链表2的值
            //同时从两个链表的头节点开始比较
            if (l1.val <= l2.val) {
                //将list1的节点的值赋给新链表
                tail.next = l1;
                //list1的节点后移一位
                l1 = l1.next;
                //新链表的尾节点后移一位
                tail = tail.next;
            } else {
                //若链表1的值大于链表2的值
                //则将list2的节点赋值给新链表
                tail.next = l2;
                l2 = l2.next;
                tail = tail.next;
            }
        }
        //如果一个节点走完，另一个节点没有走完
        //则继续走没走完的节点
        while (l1 == null && l2 != null) {
            tail.next = l2;
            l2 = l2.next;
            tail = tail.next;
        }
        while (l2 == null && l1 != null) {
            tail.next = l1;
            //list1的节点后移一位
            l1 = l1.next;
            //新链表的尾节点后移一位
            tail = tail.next;

        }
        //遍历完成返回新链表的头
        return head.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
