package day42.LeetCode565;

public class Solution {
    public int arrayNesting(int[] nums) {
        //求环的最大长度
        //nums中的数包含若干个"环"(环形链表),每个元素属于特定的环且环的长度确定
        //遍历nums,记录已访问过的元素
        int ans = 0, n = nums.length;
        boolean[] visited = new boolean[n];
        for (int num : nums) {
            if (visited[num]) {
                continue;
            }
            int cnt = 0;
            while (!visited[num]) {
                visited[num] = true;
                num = nums[num];
                cnt++;
            }
            ans = Math.max(ans,cnt);
        }
        return ans;
    }
}
