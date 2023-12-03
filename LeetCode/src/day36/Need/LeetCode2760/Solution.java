package day36.Need.LeetCode2760;

public class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        //最长子数组长度
        int max = 0;
        int l = 0;
        int r = 0;
        while(r < nums.length){
            if(nums[l] % 2 != 0 || nums[l] > threshold){
                l++;
                r++;
                continue;
            }
            //左边界满足时 更新max
            max = Math.max(max,r-l+1);
            //右指针到数组最后时 提前返回 以免移动指针越界
            if(r == nums.length -1) return max;
            //左边界满足 尝试移动右指针
            r++;
            //右指针的值超过阈值或者出现连续奇偶数 将左指针更新成r
            if(nums[r-1] % 2 == nums[r] % 2 || nums[r] > threshold){
                l = r;
                continue;
            }
            //如果右指针移动后正常 更新max
            max = Math.max(max,r-l+1);
        }
        return max;

    }

}
