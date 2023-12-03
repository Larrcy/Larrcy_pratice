package HJ100.AL001;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split(",");
        int[] nums = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        int[] pre = new int[nums.length];
        int[] suf = new int[nums.length];
        pre[0] = 0;
        suf[nums.length - 1] = 0;
        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            suf[i] = suf[i + 1] + nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            if (suf[i] == pre[i]) {
                System.out.println(i);
                break;
            }
        }
    }

    public boolean isWord(int[] c1, int[] c2) {
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) return false;
        }
        return true;
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

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}









