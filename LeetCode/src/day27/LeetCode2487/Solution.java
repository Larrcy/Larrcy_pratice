package day27.LeetCode2487;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur!= null) {
            while (!stack.isEmpty() && stack.peek().val < cur.val) {
                stack.pop();
            }
            stack.push(cur);
            cur = cur.next;
        }
        ListNode pr = null;
        while (!stack.isEmpty()) {
            stack.peek().next = pr;
            pr = stack.peek();
            stack.pop();
        }
        return pr;

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
