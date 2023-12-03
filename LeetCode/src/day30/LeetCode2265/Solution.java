package day30.LeetCode2265;

public class Solution {
    int ans = 0;
    int[] point = {0, 0};//point[0]为子树节点数量，point[1]为子树节点之和
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode node) {
        int num = 1, sum = node.val;
        if (node.left != null) {
            point = dfs(node.left);//递归找节点的左子树
            num += point[0];
            sum += point[1];
        }
        if (node.right != null) {
            point = dfs(node.right);//递归找节点的右子树
            num += point[0];
            sum += point[1];
        }
        if (node.val == sum / num) ans++;
        return new int[]{num, sum};
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
