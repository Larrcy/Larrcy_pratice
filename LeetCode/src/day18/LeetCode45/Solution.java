package day18.LeetCode45;

public class Solution {
    public int jump(int[] nums) {
        int step = 0;
        if (nums.length == 1 || nums.length == 0) {
            return step;
        }
        //记录当前覆盖的区域
        int curDistance = 0;
        //记录下一步的覆盖区域
        int nextDistance = 0;
        //当前记录的覆盖范围达到最大值后要统计下一步的覆盖范围
        for (int i = 0; i < nums.length; i++) {
            //记录下一步的覆盖范围为当前覆盖范围中最大的一步
            nextDistance = Math.max(nextDistance, i + nums[i]);
            //若下标i达到当前最大覆盖区域且没有覆盖数组长度则更新下一步的覆盖区域
            if (i == curDistance) {
                if (curDistance != nums.length - 1) {
                    curDistance = nextDistance;
                    step++;
                    //若当前覆盖区域达到了数组长度则跳出循环
                    //若没有达到则返回默认值
                    if (curDistance >= nums.length - 1)
                        break;
                } else break;

            }

        }
        return step;

    }

}
