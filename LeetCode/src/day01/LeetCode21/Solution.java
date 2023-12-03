package day01.LeetCode21;


public class Solution {
    public static void main(String[] args) {

    }

    //合并链表
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //创建一个新链表并指定头尾节点（长度为0）
        ListNode head = new ListNode(0);
        ListNode tail = head;
        //当两个链表不为空时进行判断
        while (list1 != null & list2 != null) {
            //若链表1的值小于链表2的值
            //同时从两个链表的头节点开始比较
            if (list1.val <= list2.val) {
                //将list1的节点的值赋给新链表
                tail.next = list1;
                //list1的节点后移一位
                list1 = list1.next;
                //新链表的尾节点后移一位
                tail = tail.next;
            } else {
                //若链表1的值大于链表2的值
                //则将list2的节点赋值给新链表
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        //如果一个节点走完，另一个节点没有走完
        //一个链表为空的情况也如此
        //则继续走没走完的节点
        //要保证节点不为空防止出现空指针异常
        while (list1 == null&&list2!=null) {
            tail.next = list2;
            list2 = list2.next;
            tail = tail.next;
        }
        while (list2 == null&&list1!=null) {
            tail.next = list1;
            //list1的节点后移一位
            list1 = list1.next;
            //新链表的尾节点后移一位
            tail = tail.next;

        }
        //遍历完成返回新链表的头
        return head.next;
    }
}

class ListNode {
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