package day49.LeetCode687;

public class Solution {
    // 最长同值长度，最后肯定是 '∧' 型长度 ， 用 max 记录
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return max;
    }

    // 返回以当前 root节点 为根节点出发的 最长'/'型 或 '\' 同值长度
    public int dfs(TreeNode root){
        if(root == null)
            return 0;
        // 得到左子树的最长'/'型 或 '\' 同值长度
        int maxLeft = dfs(root.left);
        // 得到右子树的最长'/'型 或 '\' 同值长度
        int maxRight = dfs(root.right);

        // 现在是左子树有 一条 '/' 型路径，右子树有一条 '\' 型路径，我们要判断这个'/' + '\' 能不能连通当前根节点 形成最长 '∧' 型同值路径
        int curLeft = 0,curRight = 0;

        // 若根节点和左根值相同，那么 根节点 到 左根之间 形成通路，根节点的 左最大同值分支 '/' 可以加上根节点 形成 长度+1 的 '/'
        // 否则只是表示 从 当前根节点 的 左根节点出发 有路径，但是和当前根节点连接断开，故当前根节点的 左出发同值路径，'/' 为0
        if(root.left!=null && root.left.val==root.val)
            curLeft = maxLeft + 1;

        // 若根节点和右根值相同，那么 根节点 到 右根之间 形成通路，根节点的 右最大同值分支 '\' 可以加上根节点 形成 长度+1 的'\'
        // 否则只是表示 从 当前根节点 的 右根节点出发 有路径，但是和当前根节点连接断开，故当前根节点的 右出发同值路径，'\' 为0
        if(root.right!=null && root.right.val==root.val)
            curRight = maxRight + 1;

        // 连接根节点的新的 '/' 和'\' 再形成 新的大 '∧'，从而让 max 记录下了 整颗树中 任意节点能形成的 最大 '∧' 同值路径长度，也是题目要求的
        max = Math.max(max,curLeft+curRight);

        // 返回 左 '/'或 右'\'中分支的长度 最长的 一支长度(若根节点和左右子树都断开，那么显然返回的是 0 ，但递归时max已经记录下了最长'∧'的长度)
        return Math.max(curLeft, curRight);
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
