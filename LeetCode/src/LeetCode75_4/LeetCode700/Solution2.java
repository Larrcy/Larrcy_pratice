package LeetCode75_4.LeetCode700;

public class Solution2 {
    public TreeNode searchBST(TreeNode root, int val) {
        //迭代法
        while (root!=null){
            if(root.val>val) root=root.left;
            else if(root.val<val)root=root.right;
            else return root;
        }
        return null;
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
