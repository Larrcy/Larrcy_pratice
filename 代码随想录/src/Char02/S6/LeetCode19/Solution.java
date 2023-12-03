package Char02.S6.LeetCode19;

public class Solution {
    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dumyhead =new ListNode(-1);
        //虚拟节点存储头节点的值
        dumyhead.next=head;
        //建立快慢指针都指向虚拟节点
        //快指针要比慢指针快n+1步
        //最后返回到的节点是删除节点的前一个节点才能进行删除操作
        ListNode fast =dumyhead;
        ListNode slow =dumyhead;
        //快指针移动步数
        for (int i = 0; i <=n  ; i++){
            fast = fast.next;
        }
        //当快指针所指元素不为空则快慢指针同时移动
        //当快指针为空时则找到要删除的节点的前一个节点
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next=slow.next.next;
        //head已发生变化
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
