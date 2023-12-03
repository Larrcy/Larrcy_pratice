package LeetCode75_4.LeetCode437;

public class Solution2 {
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        if (targetSum == 0) {
            count++;
        }
        if (targetSum != 0) {
            count += 0;
        }
        if (root.left != null) {
            targetSum -= root.left.val;
            pathSum(root.left, targetSum);
            targetSum += root.left.val;
        }
        if (root.right!=null){
            targetSum-=root.right.val;
            pathSum(root.right,targetSum);
            targetSum+=root.right.val;
        }
        return count;

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
