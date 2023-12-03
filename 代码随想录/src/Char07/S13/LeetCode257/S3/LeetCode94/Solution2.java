package Char07.S13.LeetCode257.S3.LeetCode94;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    //递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res =new ArrayList<>();
        inorder(root,res);
        return res;

    }
    public void inorder(TreeNode root, List<Integer> res){
        if(root ==null){
            return;
        }
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);

    }
}
