package day05.LeetCode234;

import java.util.List;

public class Solution {
    public static void main(String[] args) {

        ListNode head2 =new ListNode(2);
        ListNode head= new ListNode(1,head2);
        System.out.println(isPalindrome(head));

    }
    public static boolean isPalindrome(ListNode head) {
        StringBuilder sb =new StringBuilder();
        if(head.next==null){
            return true;
        }
        while (head!=null){
            //添加节点值
            sb.append(head.val);
            head=head.next;
        }
        //判断倒序后是否相等
        if(sb.toString().equals(sb.reverse().toString())){
            return true;
        }else
            return false;

    }
}


class ListNode {
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
