package LeetCode75_3.LeetCode328;

public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        //odd记录奇数节点
        //evevHead记录偶数节点的起始位置
        //even用来收集偶数节点
        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = evenHead;
        while (even != null && even.next != null) {
            //收集奇数节点
            //1-2-3
            //1-3
            odd.next = even.next;
            odd = odd.next;
            //2-3-4
            //2-4
            even.next = odd.next;
            even = even.next;
        }
        //最后将奇数节点的尾连到偶数节点的头上
        odd.next = evenHead;
        return head;
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
