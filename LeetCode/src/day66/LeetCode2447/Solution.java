package day66.LeetCode2447;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 nums 的子数组中元素的最大公因数等于 k 的子数组数目。
 * <p>
 * 子数组 是数组中一个连续的非空序列。
 * <p>
 * 数组的最大公因数 是能整除数组中所有元素的最大整数。
 */
public class Solution {
    public static void main(String[] args) {
        int[]nums ={9,3,1,2,6,3};
        int k =3;
        System.out.println(subarrayGCD(nums, k));
    }
    //从0位置开始枚举即可
    //gcd用来求a b的最大公约数 若为k则答案加1
    public static int subarrayGCD(int[] nums, int k) {
        int n = nums.length, ans = 0;
        for (int i = 0; i < n; ++i) {
            int g = nums[i];
            for (int j = i; j < n ; ++j) {
                //求得最大公约数后继续用公约数与后面的进行比较若为k则加1
                g = gcd(g, nums[j]);
                if (g == k) ++ans;
            }
            System.out.println(ans);
        }
        return ans;
    }

  static   int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
