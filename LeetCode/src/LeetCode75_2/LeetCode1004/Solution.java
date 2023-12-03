package LeetCode75_2.LeetCode1004;

public class Solution {
    public static void main(String[] args) {
        int[]nums ={0,1,1,1,0,1,1,0,1};

    }
    public int longestOnes(int[] A, int K) {
        int n = A.length;
        //记录1的个数
        int res = 0;
        //定义count用来统计反转次数
        int count = 0;
        //定义左右边界
        int left = 0;
        int right = 0;
        //从右边界开始
        while(right<n){
            //若右边界出现0则进行反转
            if(A[right]==0){
                count++;
            }
            //不是0则继续向右寻找
            right++;
            //若反转次数大于题目要求的次数
            while(count>K){
                //若左边界为0则向右移动一次且减少一次反转次数
                if(A[left]==0){
                    count--;
                }
                left++;
            }
            //统计最大的反转次数
            res = Math.max(res,right-left);
        }
        return res;
    }
}
