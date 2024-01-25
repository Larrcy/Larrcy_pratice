package 模板.差的绝对值之和;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] distance = distance(nums);
        for (int i : distance) {
            System.out.println(i);
        }
    }
//计算当前元素num与所有其他元素差的绝对值之和
    public static int[] distance(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int left = num * i - sum[i];
            int right = sum[n] - sum[i] - num * (n - i);
            ans[i] = left + right;
        }
        return ans;
    }
}
