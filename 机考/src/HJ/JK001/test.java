package HJ.JK001;

import javafx.scene.transform.Scale;

import java.util.*;
//完全二叉树非叶子部分后序遍历
public class test {
    static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //queue 用来存放输入的值
    //nodes 用来存放节点
    private static Queue<Integer> queue = new ArrayDeque<>();
    private static Queue<TreeNode> nodes = new ArrayDeque<>();
        //后序遍历建树
    public static TreeNode build(){
        TreeNode root =new TreeNode(queue.poll());
        nodes.add(root);
        while (!nodes.isEmpty()){
            TreeNode node =nodes.poll();
            if(!queue.isEmpty()){
                TreeNode left =new TreeNode(queue.poll());
                node.left=left;
                nodes.add(left);
            }else{
                break;
            }
            if(!queue.isEmpty()){
                TreeNode right =new TreeNode(queue.poll());
                node.right=right;
                nodes.add(right);
            }else {
                break;
            }
        }
        return root;
    }
    //移除树中的叶子节点
    public static TreeNode remove(TreeNode root){
        if(root==null){
            return null;
        }
        if(root.left==null&&root.right==null){
            return null;
        }
        root.left=remove(root.left);
        root.right=remove(root.right);
        return root;
    }
    //后序遍历删除后的二叉树并用集合进行收集
    public static void postTravel(TreeNode root, List<String>res){
        if(root==null){
            return;
        }
        postTravel(root.left, res);
        postTravel(root.right,res);
        res.add(String.valueOf(root.val));
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        for (String s : str) {
            queue.add(Integer.parseInt(s));
        }
        TreeNode root =build();
        remove(root);
        List<String>res =new ArrayList<>();
        postTravel(root, res);
        System.out.println(res);
    }
}
