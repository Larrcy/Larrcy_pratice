package day39.LeetCode1090;
import java.util.*;
public class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = values[i];
            nums[i][1] = labels[i];
        }
        //创建数组存储价值和标签 然后按照价值降序排列
        Arrays.sort(nums, (o1, o2) -> o2[0] - o1[0]);
        int ans = 0;
        //哈希表存放key:标签值, value:标签值出现的个数；
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length && numWanted != 0; i++) {
            int label = nums[i][1];
            int value = nums[i][0];
            //map.getOrDefault(label, 0) 根据key找value 找不到则返回0
            if (map.getOrDefault(label, 0) < useLimit) {
                ans += value;
                map.put(label, map.getOrDefault(label, 0) + 1);
                numWanted--;
            }
        }
        return ans;
    }

}
