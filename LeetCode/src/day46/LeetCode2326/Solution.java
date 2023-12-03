package day46.LeetCode2326;

import java.util.Arrays;

public class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        for (int[] r : res) Arrays.fill(r, -1);
        int t = 0, b = m - 1, l = 0, r = n - 1;
        ListNode cur = head;
        while (cur != null) {
            for (int i = l; i <= r; i++) {
                res[t][i] = cur.val;
                cur = cur.next;
                if (cur == null) return res;
            }
            t++;
            for (int i = t; i <= b; i++) {
                res[i][r] = cur.val;
                cur = cur.next;
                if (cur == null) return res;
            }
            r--;
            for (int i = r; i >= l; i--) {
                res[b][i] = cur.val;
                cur = cur.next;
                if (cur == null) return res;
            }
            b--;
            for (int i = b; i >= t; i--) {
                res[i][l] = cur.val;
                cur = cur.next;
                if (cur == null) return res;
            }
            l++;
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
