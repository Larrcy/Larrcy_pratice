package day88.LeetCode670;

/**
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 */
public class Solution {

    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int n = chars.length;
        int maxNum = num;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                //枚举交换所有位
                //要求只交换1次 交换完收集结果后还原数组
                swap(chars, i, j);
                maxNum = Math.max(maxNum, Integer.parseInt(String.valueOf(chars)));
                swap(chars, i, j);
            }
        }
        return maxNum;
    }

    public void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }
}
