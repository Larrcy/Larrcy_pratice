package Char02.S4.LeetCode206;

public class Solution2 {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        return reverse(null, head);
    }

    //pre开始时存放NULL表示反转后的尾部
    private ListNode reverse(ListNode prev, ListNode cur) {
        //若cur为空则有两种情况
        //1.链表为空 则返回空prev初始值为空则可返回prev
        //2.链表不为空 则返回prev 从prev开始遍历整个链表
        if (cur == null) {
            return prev;
        }
        ListNode temp = null;
        temp = cur.next;// 先保存下一个节点
        cur.next = prev;// 反转
        // 更新prev、cur位置
        // prev = cur;
        // cur = temp;
        return reverse(cur, temp);
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
