package day05.LeetCode228;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            //low记录区间起始位置
            int low = i;
            i++;
            while (i < n && nums[i] - nums[i - 1] == 1) {
                //当区间差值为1时 区间上限向右移动一位
                i++;
            }
            //记录区间上限所对应的下标
            int high = i - 1;
            //传递区间起始位置
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            if (low < high) {
                //若区间数不唯一则加上箭头
                temp.append("->");
                temp.append(Integer.toString(nums[high]));
            }
            //若唯一则直接添加至集合
            ret.add(temp.toString());
        }

        return ret;
    }
}
