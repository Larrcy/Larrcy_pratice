package day32.LeetCode2058;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] res = new int[2];
        ListNode pre = null;
        ListNode cur = head;
        int len = 1;
        List<Integer> list = new ArrayList<>();
        while (cur != null && cur.next != null) {
            pre = cur;
            cur = cur.next;
            len++;
            if ((pre.val < cur.val && cur.val > cur.next.val) || (pre.val > cur.val && cur.val < cur.next.val)) {
                list.add(len);
            }
        }
        if (list.size() == 0) return new int[]{-1, -1};
        res[1] = list.get(list.size() - 1) - list.get(0);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) - list.get(i) < min) {
                min = list.get(i + 1) - list.get(i);
            }
        }
        res[0] = min;
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
