package day27.LeetCode2511;

public class Solution {
    public int captureForts(int[] forts) {
        int maxVal = 0;
        // 记录上一次出现特殊标记的索引
        int preIndex = 0;
        for (int i = 0; i < forts.length; i++) {
            // 特殊标记1
            if (forts[i] == 1) {
                if (forts[preIndex] == -1) {
                    maxVal = Math.max(maxVal, i - preIndex - 1);
                }
                preIndex = i;
            }
            // 特殊标记-1
            if (forts[i] == -1) {
                if (forts[preIndex] == 1) {
                    maxVal = Math.max(maxVal, i - preIndex - 1);
                }
                preIndex = i;
            }
            // 其余是0，不用处理
        }

        return maxVal;
    }

}
