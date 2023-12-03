package day32.LeetCode1721;

public class Solution {
    //值交换
    public ListNode swapNodes(ListNode head, int k) {
        //在头节点前添加哑节点避免越界且允许了头节点的交换
        ListNode yummy = new ListNode(0, head);
        //初始化pre和快慢指针都指向哑节点处
        ListNode pre = yummy, slow = yummy, fast = yummy;
        //pre和快指针走k步，找到正数第k个节点
        for(int i = 0; i < k; i++){
            pre = pre.next;
            fast = fast.next;
        }
        //快慢指针再一起走。快指针到链表末尾时慢指针指向倒数第k个节点
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        //交换两个节点的值
        int temp = pre.val;
        pre.val = slow.val;
        slow.val = temp;
        //返回链表头
        return yummy.next;
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
