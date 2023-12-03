package day03.LeetCode144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//迭代法 利用栈模拟
public class Solution2 {
    //前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        //根节点为空直接返回
        if (root == null){
            return result;
        }
        //利用栈模拟  入栈顺序 根右左
        Stack<TreeNode> stack = new Stack<>();
        //先存入根节点
        stack.push(root);
        //当栈不为空时进行循环
        while (!stack.isEmpty()){
            //根出栈
            TreeNode node = stack.pop();
            //将节点的值添加到数组
            result.add(node.val);
            //再判断根的左右孩子是否为空
            //若不为空则将左右孩子入栈
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }
        }
        //最后返回结果
        return result;
    }
}
