package day44.Week319.LeetCode2471;

import java.util.*;

public class Solution {
    public int minimumOperations(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                arr[i] = poll.val;

                if (null != poll.left) queue.offer(poll.left);
                if (null != poll.right) queue.offer(poll.right);
            }

            ans += minimumOperations(arr);
        }

        return ans;
    }

    /**
     * 严格递增顺序 排序所需的最少操作数目
     * @param nums
     * @return
     */
    public int minimumOperations(int[] nums) {
        int cnt = 0, n = nums.length;
        int[] sorted = Arrays.copyOf(nums, n);
        Arrays.sort(sorted);

        // Map<num, idx>  记录值正确的索引下标
        Map<Integer, Integer> rightIdxMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            rightIdxMap.put(sorted[i], i);
        }

        for (int i = 0; i < n; i++) {
            while (true) {
                int rightIdx = rightIdxMap.get(nums[i]);

                // 不在正确的位置则交换到正确的位置
                if (rightIdx != i) {
                    cnt++;
                    this.swap(nums, i, rightIdx);
                } else {
                    break;
                }
            }
        }

        return cnt;
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
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
