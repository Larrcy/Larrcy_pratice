package day63.SlideWindow.LeetCode1031;

/**
 * 滑动窗口
 * 给你一个整数数组 nums 和两个整数 firstLen 和 secondLen，请你找出并返回两个非重叠 子数组 中元素的最大和，长度分别为 firstLen 和 secondLen 。
 * <p>
 * 长度为 firstLen 的子数组可以出现在长为 secondLen 的子数组之前或之后，但二者必须是不重叠的。
 * <p>
 * 子数组是数组的一个 连续 部分。
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {0, 6, 5, 2, 2, 5, 1, 9, 4};
        System.out.println(maxSumTwoNoOverlap(nums, 1, 2));
    }

    public static int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {

        if (firstLen + secondLen == nums.length) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
            return sum;
        }
        int left = 0;
        int sum1 = 0;
        int res1 = 0;
        int res2 = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum1 += nums[i];
            while (i - left + 1 >= secondLen) {
                if (res1 < sum1) {
                    res1 = sum1;
                }
                sum1 -= nums[left];
                if (left >= firstLen) {
                    int left2 = 0;
                    int sum2 = 0;
                    for (int j = 0; j < left; j++) {
                        sum2 += nums[j];
                        while (j - left2 + 1 >= firstLen) {
                            if (res2 < sum2) {
                                res2 = sum2;
                            }
                            sum2 -= nums[left2];
                            left2++;
                        }
                    }
                }
                if (nums.length - i - 1 >= firstLen) {
                    int left2 = i + 1;
                    int sum2 = 0;
                    for (int j = i + 1; j < nums.length; j++) {
                        sum2 += nums[j];
                        while (j - left2 + 1 >= firstLen) {
                            if (res2 < sum2) {
                                res2 = sum2;
                            }
                            sum2 -= nums[left2];
                            left2++;
                        }
                    }
                }
                left++;
                if (res1 + res2 > res) {
                    res = res1 + res2;
                }
                //收集完结果后重置每一次的结果
                res1 =0;
                res2 =0;
            }
        }
        return res;
    }
}
