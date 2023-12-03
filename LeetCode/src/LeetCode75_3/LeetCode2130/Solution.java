package LeetCode75_3.LeetCode2130;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Solution {
    //10
    //0  9
    //1  8
    //2  7
    public int pairSum(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur!= null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int ans = 0;
        for (int i = 0; i < list.size() / 2; i++) {
            ans = Math.max(ans, list.get(i) + list.get(list.size() - 1-i));
        }

        return ans;
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
