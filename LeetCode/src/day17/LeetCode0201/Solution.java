package day17.LeetCode0201;



import java.util.HashSet;
import java.util.Set;

public class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode cur =new ListNode(0);
        cur.next=head;
        Set<Integer>set =new HashSet<>();
        while (cur.next!=null){
            if(set.add(cur.next.val)){
                cur=cur.next;
            }else cur.next=cur.next.next;
        }

        return head;
    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
