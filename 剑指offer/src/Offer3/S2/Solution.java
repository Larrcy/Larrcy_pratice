package Offer3.S2;

public class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        ListNode dynamicHead =new ListNode(0);
        dynamicHead.next=head;
      ListNode temp = dynamicHead;
      int count =len+1-k;
      while (temp.next!=null){
          count--;
          temp=temp.next;
          if(count==0) {
          break;
          }
      }
      return temp;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
