package day02.LeetCode108;

public class Solution {
    public static void main(String[] args) {
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);

    }

    //创建一个构建二叉搜索树的函数
    //创建树大部分情况要用递归
    //传入参数为 数组  数组起点  数组终点
    public TreeNode build(int[] nums, int start, int end) {
        if (start>end) {
            //当开始位置在结束位置之后则结束
            return null;
        }
        //寻找中间节点
        int mid = (start + end) / 2;
        //得到数组的中间值 并设为根节点
        TreeNode root =new TreeNode(nums[mid]);
        //从数组的中间值将数组分为两部分
        //利用二分法将左右两部分继续分开
        root.left=build(nums,start,mid-1);
        root.right=build(nums,mid+1,end);

        //最后返回根节点
        return root;
    }
}

class TreeNode {
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