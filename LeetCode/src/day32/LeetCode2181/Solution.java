package day32.LeetCode2181;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public ListNode mergeNodes(ListNode head) {
        head = head.next;
        ListNode ansNode = new ListNode();
        ListNode node = ansNode;
        int sum = 0;
        while (head != null) {
            // 如果不是0，累加
            if (head.val != 0) {
                sum += head.val;
            }
            // 是0，把sum取出，加入到答案里
            else {
                node.next = new ListNode(sum);
                node = node.next;
                sum = 0;
            }
            head = head.next;
        }
        return ansNode.next;
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
