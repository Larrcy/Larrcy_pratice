package day45.Week336;
import java.util.*;
public class Solution3 {
    //.如果当前选择的子数组为美丽子数组, 那么这个数组中所有的二进制位一定都是偶数
    public long beautifulSubarrays(int[] nums) {
        HashMap<Integer, Long> map = new HashMap<>();
        map.put(0, 1l);
        int n = nums.length;
        long result = 0;

        int state = 0;
        for(int i = 0; i < n; i++){
            state ^= nums[i];
            result += map.getOrDefault(state, 0l);
            map.put(state, map.getOrDefault(state, 0l) + 1);
        }

        return result;
    }

}
