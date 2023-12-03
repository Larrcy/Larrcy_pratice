package day35.LeetCode665;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //遇到递减的情况 先将递增末尾的元素记录下来
            if (nums[i] > nums[i + 1]) {
                int tmp = nums[i];
                //若不是首元素 将nums[i-1]赋值给nums[i]使其变小
                if (i >= 1) {
                    nums[i] = nums[i - 1];
                } else {
                    //若是首元素 则将nums[i+1]的值赋值给nums[i]
                    nums[i] = nums[i + 1];
                }
                //若变小后的元素还是大于nums[i+1]
                //则说明nums[i+1]太小 需要将其变大
                if (nums[i] > nums[i + 1]) {
                    //还原nums[i]的值
                    nums[i] = tmp;
                    //将nums[i+1]变为nums[i]
                    nums[i + 1] = nums[i];
                }
                cnt++;
                if (cnt == 2) {
                    return false;
                }
            }
        }
        return true;
    }
}
