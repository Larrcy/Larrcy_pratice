package day24.LeetCode979;

public class Solution {
    private int ans;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node) {
        //统计每颗子树的硬币个数coins以及节点个数nodes
        //硬币多就移出子树硬币少就移入子树
        //coins =coinsLeft+coinsRight+node.val
        //nodes=nodesLeft+nodesRight+1
        //coins-nodes即移动次数
        //要加绝对值 coins>node时是移出小于时是移入
        //本题求移动次数故取绝对值
        //d=coins-nodes
        if (node == null)
            return 0;
        int d = dfs(node.left) + dfs(node.right) + node.val - 1;
        ans += Math.abs(d);
        return d;
    }

    public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
}
