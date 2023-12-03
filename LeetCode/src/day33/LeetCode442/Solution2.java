package day33.LeetCode442;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<Integer>();
        //index的范围为1-n
        //对应的nums下标为0-n-1
        //index可以保证将数组中的每一个数进行负数转换
        //index相当于哈希表
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]);
            //如果是正数，那么调整为负数表示已经访问过
            //再次访问是负数则添加进结果集
            if (nums[index - 1] > 0) {
                nums[index - 1] = -nums[index - 1];
            } else {
                ans.add(index);
            }
        }
        return ans;
    }
}
