package LeetCode75_2.LeetCode724;

public class Solution {
    public static void main(String[] args) {
        int[]nums={1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(nums));
    }
    public static int pivotIndex(int[] nums) {
        int length = nums.length;

        // L 和 R 分别表示左右两侧的乘积列表
        int[] L = new int[length];
        int[] R = new int[length];

        // L[i] 为索引 i 左侧所有元素的乘积
        // 对于索引为 '0' 的元素，因为左侧没有元素，所以 L[0] = 0
        L[0] = 0;
        //[0,2,3]
        for (int i = 1; i < length; i++) {
            L[i] = nums[i-1]+L[i-1];
        }

        // R[i] 为索引 i 右侧所有元素的乘积
        // 对于索引为 'length-1' 的元素，因为右侧没有元素，所以 R[length-1] = 0
        R[length - 1] = 0;
        //[0,-1,0]
        for (int i = length - 2; i >= 0; i--) {
            R[i] = nums[i + 1]+R[i+1];
        }

        // 对于索引 i，除 nums[i] 之外其余各元素的乘积就是左侧所有元素的乘积乘以右侧所有元素的乘积
        for (int i = 0; i < length; i++) {
            if(R[i]==L[i]){
                return i;
            }
        }
        return -1;
    }
}
