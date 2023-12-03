package day46.LeetCode1019;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            int x =cur.val;
            while (cur.next != null && cur.next.val <= x) {
                cur = cur.next;
            }
            if (cur.next == null) {
                list.add(0);
            } else {
                list.add(cur.next.val);
            }
            cur=temp;

        }
        int[]res =new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i]=list.get(i);
        }
        return res;

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
