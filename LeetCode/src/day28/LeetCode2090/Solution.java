package day28.LeetCode2090;

public class Solution {
    public int[] getAverages(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len];
        int l = 0;
        long sum = 0; //不为long 类型的话，最后一个用例会溢出
        for (int i = 0; i < nums.length; i++) {
            res[i] = -1;
            if (i < 2 * k) { //当前窗口大小不够，就向右扩一个
                sum += nums[i];
            }else {
                sum += nums[i];//窗口右扩一个,此时窗口大小刚好为2k+1
                res[i - k] = (int) (sum / (2 * k + 1)); //那么i - k索引处的元素就是在窗口中间，就可以算该处为中心的平均值
                sum -= nums[l++];//窗口左边界收缩一个，可以使窗口大小保持为2 * k + 1
            }
        }
        return res;
    }

}
