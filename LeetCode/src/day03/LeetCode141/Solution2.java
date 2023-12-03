package day03.LeetCode141;

public class Solution2 {
    //快慢指针法
    /*
    定义两个指针，一快一慢。
    慢指针每次只移动一步，而快指针每次移动两步。
    初始时，慢指针放在位置 head 快指针放在head的下一位
    如果在移动的过程中，快指针与慢指针相遇，就说明该链表为环形链表。
    否则快指针将到达链表尾部 链表不存在环
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow =head;
        ListNode fast =head.next;

        while (fast!=slow){
            if(fast==null||fast.next==null){
                //当快指针走到最后时 则无环
                return false;
            }
            //慢指针走一步 快指针走两步
            slow=slow.next;
            fast=fast.next.next;
        }
        //当快慢指针相遇 则有环
        return true;
    }

}
