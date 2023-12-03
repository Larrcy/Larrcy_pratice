package LeetCode75_2.LeetCode1456;

public class Solution {
    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        System.out.println(maxVowels(s, k));
    }

    public static int maxVowels(String s, int k) {
        StringBuilder temp = new StringBuilder();
        int sum = 0;

        for (int i = 0; i < k; i++) {
            temp.append(s.charAt(i));
            if (temp.charAt(i) == 'a' || temp.charAt(i) == 'e' || temp.charAt(i) == 'o' || temp.charAt(i) == 'i' || temp.charAt(i) == 'u') {
                sum++;
            }
        }
        int maxSum = sum;

        for (int i = k; i < s.length(); i++) {
            //判断左右两端删除和添加的元素是否为元音字母
            int q = temp.charAt(0) == 'a' || temp.charAt(0) == 'e' || temp.charAt(0) == 'i' || temp.charAt(0) == 'o' || temp.charAt(0) == 'u' ? 1 : 0;
            int p = s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u' ? 1 : 0;
            temp = temp.deleteCharAt(0).append(s.charAt(i));
            //更新sum的值
            sum = sum - q + p;
            maxSum= Math.max(sum, maxSum);
        }
        return maxSum;
    }

}
