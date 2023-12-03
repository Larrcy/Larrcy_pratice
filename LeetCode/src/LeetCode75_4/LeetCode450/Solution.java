package LeetCode75_4.LeetCode450;

public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        /*
          对二叉搜索树进行删除时有5种情况
          1.删除点为空
          2.删除点为叶子节点
          3.删除点左不为空右为空
          4.删除点左为空右不为空
          5.删除点左右都不为空
         */
        //根节点为空的情况  直接返回null
        if (root == null) return null;
        //找到删除的节点时
        if (root.val == key) {
            //若为叶子节点 直接删除即可
            if (root.left == null && root.right == null) {
                //把当前节点返回空
                return null;
            }
            //左为空 右不为空 将节点的右孩子返回
            if (root.left == null && root.right != null) {
                return root.right;
            }
            //左不为空 右为空 将节点的左孩子返回
            if (root.left != null && root.right == null) {
                return root.left;
            }
            //当左右都不为空时 我们对二叉树的结构进行调整
            if (root.left != null && root.right != null) {
                //记录要删除节点的右孩子
                TreeNode cur = root.right;
                while (cur.left != null) {
                    //找到右子树的最左边 即右子树的最小值
                    //接下来把左子树放到该节点即可
                    cur = cur.left;
                }
                //把要删除节点的左子树赋值到当前节点
                cur.left = root.left;
                return root.right;
            }

        }
        if (key < root.val) root.left=deleteNode(root.left, key);
        if (key > root.val) root.right=deleteNode(root.right, key);
        return root;
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
