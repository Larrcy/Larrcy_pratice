package day31.Old.WA.LeetCode24;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        //创建一个虚拟指针 涉及头节点操作的时候就要创建虚拟指针
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
            temp = cur.next;//指向1
            temp1 = cur.next.next.next;//指向3
            //假设为-1->1->2->3->4
            //cur开始时为-1的位置
            //首先让cur指向2
            cur.next = cur.next.next;
            //再让2指向1
            cur.next.next = temp;
            //最后让1指向3
            temp.next = temp1;
            //此时链表为-1->2->1->3->4
            //然后cur移动到2的位置 再次交换cur后两个位置的元素
            cur = cur.next.next;
            //此时cur所指的位置为1相当于第一次交换时的-1 该节点不参与交换
            //下一个位置才开始参与交换


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
