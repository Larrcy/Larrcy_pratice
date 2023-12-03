package day12.LeetCode24;

import java.util.List;

public class Solution {
    public static void main(String[] args) {

    }

    public ListNode swapPairs(ListNode head) {
        //创建一个虚拟指针
        ListNode dumyhead = new ListNode(-1);
        dumyhead.next = head;
        //创建指针指向虚拟节点
        ListNode cur = dumyhead;
        //cur.next会指向cur.next.next
        //要创建一个节点用来存储cur.next的值
        ListNode temp;
        //存储cur.next.next.next
        ListNode temp1;
        //反转到最后会出现两种情况
        //剩余1个节点则cur.next.next=null
        //不剩余节点则cur.next=null
        //此时停止交换
        while (cur.next != null && cur.next.next != null) {
            //要先声明temp 和temp1 不然指针改变后值会发生变化
            temp = cur.next;
            temp1 = cur.next.next.next;
            //假设为-1->1->2->3->4
            //cur开始时为-1的位置
            //首先让cur指向2
            cur.next = cur.next.next;
            //再让2指向1
            cur.next.next = temp;
            //最后让1指向3
            temp.next = temp1;
            //然后cur移动到2的位置 再次交换cur后两个位置的元素
            cur = cur.next.next;


        }
        return dumyhead.next;

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
