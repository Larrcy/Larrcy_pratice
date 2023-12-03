package day37.LeetCode560;

import java.util.*;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        //若第一次t相加刚好为k 此时d为0
        //但map中并不存在0 因此我们将这种情况特殊处理
        map.put(0,1);
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int ans = 0;
        for (int i = 1; i < sum.length; i++) {
            //k=sum[i]-sum[j-1]
            //sum[j-1]=sum[i]-k
            //即sum[j-1]=t-k
            int t = sum[i], d = t - k;


            if (map.containsKey(d)) ans += map.get(d);
            //为防止出现t==d的情况因此将put放在后面
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        return ans;
    }

}
