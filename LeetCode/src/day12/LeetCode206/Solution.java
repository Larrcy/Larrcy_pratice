package day12.LeetCode206;

public class Solution {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        //temp是临时指针 用来存储cur的下一个位置的值
        //当链表反转时 cur指向下一个数的指针会指向pre
        //会存在找不到cur下一个值的情况
        ListNode temp = null;
        //当cur指向NULL的时候反转结束
        while (cur != null) {
            // 保存下一个节点
            temp = cur.next;
            //进行反转
            cur.next = prev;
            //指针同时后移
            //顺序不可颠倒
            prev = cur;
            cur = temp;
        }
        //最后返回pre（cur为空）
        return prev;
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

